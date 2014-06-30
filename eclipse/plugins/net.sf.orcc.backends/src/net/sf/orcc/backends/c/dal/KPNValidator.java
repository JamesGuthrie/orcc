package net.sf.orcc.backends.c.dal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sf.orcc.graph.Edge;
import net.sf.orcc.ir.Block;
import net.sf.orcc.ir.BlockBasic;
import net.sf.orcc.ir.InstCall;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.util.IrUtil;
import net.sf.orcc.tools.classifier.GuardSatChecker;
import net.sf.orcc.util.OrccLogger;
import net.sf.orcc.df.Actor;
import net.sf.orcc.df.Action;
import net.sf.orcc.df.State;
import net.sf.orcc.df.Transition;
import net.sf.orcc.df.Pattern;
import net.sf.orcc.df.Port;
import net.sf.orcc.df.Network;

/**
 * Class for checking Kahn process networks (KPN) compliance
 * of a network.
 * 
 * @author Jani Boutellier
 * @author James Guthrie
 * 
 */
public class KPNValidator {

	private GuardSatChecker satChecker;

	public void validate(Network network) {
		for (Actor actor : network.getAllActors()) {
			boolean isKPN = true;
			if (actor.hasFsm()) {
				for (State state : actor.getFsm().getStates()) {
					if (!inspectState(actor, state)) {
						isKPN = false;
					}
				}
			} else {
				if (actor.getActions().size() >= 1) {
					SeqTreeNode root;
					root = inspectActionList(actor, actor.getActions(), false);
					actor.setAttribute("SequenceTreeRoot", root);
					if (root == null) {
						isKPN = false;
					}
				}
			}
			if (isKPN) {
				OrccLogger.noticeln("Actor [" + actor.getName() + "] is KPN");
			} else {
				OrccLogger.noticeln("Actor [" + actor.getName() + "] is not KPN");
			}
		}
	}

	public void analyzeInputs(Network network) {
		for (Actor actor : network.getAllActors()) {
			if (actor.getInputs().size() == 0) {
				actor.addAttribute("variableInputPattern");
				continue;
			}
			if (actor.getActions().size() > 1) {
				inspectActionList(actor, actor.getActions(), true);
			} else {
				Pattern inputPattern = actor.getActions().get(0).getInputPattern();
				for(Port port : inputPattern.getPorts()) {
					port.setNumTokensConsumed(inputPattern.getNumTokensMap().get(port));
				}
			}
		}
	}

	public void analyzeOutputs(Network network) {
		for (Actor actor : network.getAllActors()) {
			if (actor.getActions().size() > 1) {
				analyzeOutputPorts(actor, actor.getActions());
			} else {
				if (actor.getActions().size() != 0) {
					Pattern outputPattern = actor.getActions().get(0).getOutputPattern();
					for(Port port : outputPattern.getPorts()) {
						port.setNumTokensProduced(outputPattern.getNumTokensMap().get(port));
					}
				}
			}
		}
	}

	private boolean inspectState(Actor actor, State srcState) {
		List<Action> actions = new ArrayList<Action>();
		for (Edge edge : srcState.getOutgoing()) {
			actions.add(((Transition) edge).getAction());
		}
		actions.addAll(actor.getActionsOutsideFsm());
		SeqTreeNode root = inspectActionList(actor, actions, false);
		srcState.setAttribute("SequenceTreeRoot", root);
		if (root == null) {
			return false;
		} else {
			return true;
		}
	}

	private SeqTreeNode inspectActionList(Actor actor, List<Action> actions, boolean actorLevel) {
		SeqTreeNode root = getPeekSequence(actor, actions);
		if (root == null) {
			OrccLogger.warnln("No peek sequence for actor: " + actor.getName() + ": " + actions.toString());
		}
		return root;
	}

	/**
	 * Get the peek sequence of <code>actor</code> for <code>actions</code>
	 *
	 * @param actor
	 * @param actions
	 * @return The root node of a peek sequence tree
	 */
	private SeqTreeNode getPeekSequence(Actor actor, List<Action> actions) {
		satChecker = new GuardSatChecker(actor);
		SeqTreeNode root = new SeqTreeNode(actions);
		return addChildren(root);
	}

	/**
	 * Recursively construct port peek sequence.
	 *
	 * @param current
	 * @return The root node of a peek sequence tree
	 */
	private SeqTreeNode addChildren(SeqTreeNode current) {
		Set<Action> actions = current.getActions();
		Set<Token> intersection = getNextReadTokens(actions);
		intersection.removeAll(current.getProcessed());
		if (!intersection.isEmpty()){
			Set<Token> processed = new HashSet<Token>();
			processed.addAll(current.getProcessed());
			processed.addAll(intersection);
			for (Action a: actions) {
				SeqTreeNode node = new SeqTreeNode(new GuardConstraint(a, new TreeSet<Token>(intersection)), a, processed);
				insertChildNode(current, node);
			}
			for (SeqTreeNode child : current.getChildren()) {
				if (addChildren(child) == null) {
					return null;
				}
			}
		} else {
			if (actions.size() != 1){
				for (Action action : actions) {
					if ((current.getConstraints() == null) || !current.getConstraints().equivalent(action)){
						OrccLogger.warnln("\t\tActions " + actions.toString() + " are not mutually exclusive");
						return null;
					}
				}
			}
		}
		return current;
	}


	/**
	 * Insert node as a child of current, if the constraints of node are sat
	 * with the constraints of an existing child, the two nodes are resolved
	 * and replaced with child nodes with mutually exclusive constraints.
	 *
	 * @param current
	 * @param node
	 */
	private void insertChildNode(SeqTreeNode current, SeqTreeNode node) {
		List<SeqTreeNode> children = current.getChildren();
		if (children.isEmpty()) {
			current.addChild(node);
		} else {
			boolean unsat = true;
			for (SeqTreeNode child : current.getChildren()) {
				if (sat(node, child) == true) {
					unsat = false;
					Set<SeqTreeNode> nodes = resolve(node, child);
					current.removeChild(child);
					for (SeqTreeNode n : nodes) {
						insertChildNode(current, n);
					}
					break;
				}
			}
			if (unsat == true) {
				current.addChild(node);
			}
		}
	}

	/**
	 * Resolve overlapping constraints between left and right, returning
	 * nodes which have mutually exclusive constraints
	 *
	 * @param left
	 * @param right
	 * @return set of nodes with mutually exclusive constraints
	 */
	private Set<SeqTreeNode> resolve(SeqTreeNode left, SeqTreeNode right) {
		GuardConstraint intersect = left.getConstraints().intersect(right.getConstraints());
		GuardConstraint leftConst = left.getConstraints().difference(right.getConstraints());
		GuardConstraint rightConst = right.getConstraints().difference(left.getConstraints());
		Set<SeqTreeNode> nodes = new HashSet<SeqTreeNode>();
		Set<Token> processed = left.getProcessed();

		Set<Action> actions = new HashSet<Action>(left.getActions());
		actions.addAll(right.getActions());
		SeqTreeNode n;
		n = new SeqTreeNode(intersect, actions, processed);
		if (sat(n)) {
			nodes.add(n);
		}
		n = new SeqTreeNode(leftConst, left.getActions(), processed);
		if (sat(n)) {
			nodes.add(n);
		}
		n = new SeqTreeNode(rightConst, right.getActions(), processed);
		if (sat(n)) {
			nodes.add(n);
		}
		return nodes;
	}

	private void analyzeOutputPorts(Actor actor, List<Action> actions) {
		for (Action first : actions) {
			for (Action second : actions) {
				compareOutputPatterns(actor, first, second);
			}
		}
	}

	private void compareOutputPatterns(Actor actor, Action firstAction, Action secondAction) {
		Pattern first = firstAction.getOutputPattern();
		Pattern second = secondAction.getOutputPattern();
		for(Port port : first.getPorts()) {
			int firstTokenRate = first.getNumTokensMap().get(port);
			port.setNumTokensProduced(firstTokenRate);
			if (second.getNumTokensMap().get(port) != null) {
				int secondTokenRate = second.getNumTokensMap().get(port);
				if (firstTokenRate != secondTokenRate) {
					OrccLogger.traceln("Info: " + actor.getName() + " port " + port.getName() + " has a variable output rate");
					port.setNumTokensProduced(-1);
				} 
			}
		}
	}

	/**
	 * Determine whether constraints of nodes left and right
	 * are simultaneously satisfiable
	 *
	 * @param left
	 * @param right
	 * @return true if satisfiable, false if mutually exclusive
	 */
	private boolean sat(SeqTreeNode left, SeqTreeNode right) {
		// Clone existing actions
		Action leftAction = IrUtil.copy(left.getActions().iterator().next());
		Action rightAction = IrUtil.copy(right.getActions().iterator().next());

		// Set constraints of cloned actions
		left.getConstraints().setConstraint(leftAction);
		right.getConstraints().setConstraint(rightAction);

		return satChecker.checkSat(leftAction, rightAction);
	}

	/**
	 * Determine whether constraints of node are satisfiable
	 *
	 * @param node
	 * @return true if satisfiable, false otherwise
	 */
	private boolean sat(SeqTreeNode node) {
		// Clone existing action
		Action action = IrUtil.copy(node.getActions().iterator().next());

		// Set constraints of cloned action
		node.getConstraints().setConstraint(action);

		return satChecker.checkSat(action);
	}

	/**
	 * Get the tokens which can be read by all actions in a DAL KPN.
	 * This is the intersection of the input tokens of all actions and
	 * the union of state tokens of all actions
	 *
	 * @param actions
	 * @return A Set of tokens
	 */
	private Set<Token> getNextReadTokens(Set<Action> actions) {
		Set<Token> theseTokens = new HashSet<Token>();
		Set<Set<Token>> allInputTokens = new HashSet<Set<Token>>();
		for (Action a : actions){
			Set<Token> inputTokens = getInputTokens(a);
			allInputTokens.add(inputTokens);
		}
		Set<Token> intersection = getIntersection(allInputTokens);
		Set<Var> deps = new HashSet<Var>();
		for (Token t : intersection) {
			if (t instanceof LoadTokenImpl) {
				deps.add(((LoadTokenImpl) t).getInstruction().getTarget().getVariable());
			}
		}
		for (Action a : actions){
			Set<Token> stateTokens = getStateTokens(a, deps);
			theseTokens.addAll(stateTokens);
		}
		Set<Token> nextRead = new TreeSet<Token>();
		nextRead.addAll(intersection);
		nextRead.addAll(theseTokens);
		return nextRead;
	}

	/**
	 * Get state tokens belonging to the scheduler of <code>action</code>
	 * given the <code>inputVars</code> which are defined by the input
	 * tokens.
	 *
	 * @param action
	 * @return A Set of tokens
	 */
	private Set<Token> getStateTokens(Action action, Collection<Var> inputVars) {
		Set<Token> tokens = new TreeSet<Token>();
		Set<Var> vars = new HashSet<Var>(inputVars);
		for (Block b : action.getScheduler().getBlocks()) {
			if (b instanceof BlockBasic) {
				for (Instruction i : ((BlockBasic) b).getInstructions()) {
					if (i instanceof InstLoad || i instanceof InstCall) {
						Token t;
						if (i instanceof InstLoad) {
							t = new LoadTokenImpl((InstLoad) i);
						} else {
							t = new CallTokenImpl((InstCall) i);
						}
						if (t.isStateToken()) {
							tokens.add(t);
							vars.add(t.getTargetVar());
						}
					}
				}
			}
		}
		// Remove tokens whose dependencies are not fulfilled
		for (Token t : tokens) {
			if (!t.depsFulfilledBy(vars)) {
				tokens.remove(t);
			}
		}
		return tokens;
	}

	/**
	 * Get the input tokens belonging to the scheduler of <code>action</code>.
	 *
	 * @param actor
	 * @return A Set of load instructions
	 */
	private Set<Token> getInputTokens(Action action) {
		Set<Token> tokens = new HashSet<Token>();
		for(Block b : action.getScheduler().getBlocks()) {
			if (b.isBlockBasic()) {
				BlockBasic bb = (BlockBasic) b;
				for (Instruction i : bb.getInstructions()) {
					if (i instanceof InstLoad || i instanceof InstCall) {
						Token t;
						if (i instanceof InstLoad) {
							t = new LoadTokenImpl((InstLoad) i);
						} else {
							t = new CallTokenImpl((InstCall) i);
						}
						if (t.isInputToken()){
							tokens.add(t);
						}
					}
				}
			}
		}
		return tokens;
	}

	/**
	 * Get the set intersection. Given a set of Sets, this function determines
	 * the intersection of all Sets and returns the elements in the intersection
	 *
	 * @param s a set of Sets
	 * @return a set representing the intersection of the values of the Sets
	 */
	private <E> Set<E> getIntersection(Set<Set<E>> s){
		Iterator<Set<E>> it = s.iterator();
		if (it.hasNext()) {
			Set<E> result = new HashSet<E>(it.next());
			while (it.hasNext()) {
				Set<E> others = it.next();
				result.retainAll(others);
			}
			return result;
		} else {
			return null;
		}
	}

}
