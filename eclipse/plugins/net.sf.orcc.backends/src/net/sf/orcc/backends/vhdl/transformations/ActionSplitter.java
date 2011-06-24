/*
 * Copyright (c) 2011, IETR/INSA of Rennes
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *   * Neither the name of the IETR/INSA of Rennes nor the names of its
 *     contributors may be used to endorse or promote products derived from this
 *     software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
package net.sf.orcc.backends.vhdl.transformations;

import static net.sf.orcc.ir.util.IrUtil.copy;
import static org.eclipse.emf.ecore.util.EcoreUtil.isAncestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.orcc.backends.instructions.InstSplit;
import net.sf.orcc.ir.Action;
import net.sf.orcc.ir.Actor;
import net.sf.orcc.ir.Def;
import net.sf.orcc.ir.FSM;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.InstSpecific;
import net.sf.orcc.ir.InstStore;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.NodeBlock;
import net.sf.orcc.ir.Pattern;
import net.sf.orcc.ir.Port;
import net.sf.orcc.ir.Procedure;
import net.sf.orcc.ir.State;
import net.sf.orcc.ir.Use;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.util.AbstractActorVisitor;
import net.sf.orcc.ir.util.IrUtil;
import net.sf.orcc.util.EcoreHelper;
import net.sf.orcc.util.UniqueEdge;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.jgrapht.DirectedGraph;

/**
 * This class defines a transformation that splits actions each time a
 * SplitInstruction is encountered.
 * 
 * @author Matthieu Wipliez
 * 
 */
public class ActionSplitter extends AbstractActorVisitor<Object> {

	/**
	 * name of the branch being visited
	 */
	private String branchName;

	/**
	 * action being visited
	 */
	private Action currentAction;

	/**
	 * FSM of the actor. May be null if the actor has no FSM. May be updated if
	 * an FSM is added to the actor.
	 */
	private FSM fsm;

	private int index;

	private Map<String, Var> mapGlobals;

	private Map<Var, Var> mapLocals;

	/**
	 * action to visit next (may be null)
	 */
	private Action nextAction;

	private List<Port> portWrittenList;

	/**
	 * name of the source state
	 */
	private State source;

	/**
	 * Map used to create new unique state names.
	 */
	private Map<String, Integer> stateNames;

	private Map<String, State> statesMap;

	/**
	 * name of the target state
	 */
	private State target;

	/**
	 * Adds an FSM to the given action scheduler.
	 * 
	 * @param actionScheduler
	 *            action scheduler
	 */
	private void addFsm() {
		fsm = IrFactory.eINSTANCE.createFSM();

		State initState = statesMap.get("init");
		fsm.getStates().add(initState);
		fsm.setInitialState(initState);
		for (Action action : actor.getActionsOutsideFsm()) {
			fsm.addTransition(initState, action, initState);
		}

		actor.getActionsOutsideFsm().clear();
		actor.setFsm(fsm);
	}

	@Override
	public Object caseAction(Action action) {
		this.branchName = target.getName() + "_" + action.getName();
		nextAction = action;

		while (nextAction != null) {
			currentAction = nextAction;
			nextAction = null;

			index = 0;

			// reset the list of ports written to by currentAction
			portWrittenList = new ArrayList<Port>();

			// visit current action
			doSwitch(currentAction.getBody());
		}
		return null;
	}

	@Override
	public Object caseActor(Actor actor) {
		this.actor = actor;
		stateNames = new HashMap<String, Integer>();
		statesMap = new HashMap<String, State>();
		mapLocals = new HashMap<Var, Var>();
		mapGlobals = new HashMap<String, Var>();

		visitAllActions();

		return null;
	}

	@Override
	public Object caseInstruction(Instruction instruction) {
		// do not consider deleted instructions
		if (instruction.eContainer() == null) {
			return null;
		}

		// the procedure that contains this instruction
		Procedure procedure = EcoreHelper.getContainerOfType(instruction,
				Procedure.class);

		// moves the variables defined elsewhere
		TreeIterator<EObject> it = instruction.eAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof Def) {
				Def def = (Def) eObject;
				Var var = def.getVariable();
				if (var.isLocal() && !var.getType().isList()) {
					if (!isAncestor(procedure, var)) {
						procedure.getLocals().add(var);
					}
				}
			}
		}

		// visit uses
		it = instruction.eAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof Use) {
				Use use = (Use) eObject;
				Var var = use.getVariable();
				if (var.isLocal() && !var.getType().isList()) {
					if (!isAncestor(procedure, var)) {
						// update the use
						updateUse(procedure, instruction, use);
					}
				}
			}
		}

		return null;
	}

	@Override
	public Object caseInstSpecific(InstSpecific instruction) {
		if (instruction instanceof InstSplit) {
			splitAction((InstSplit) instruction);
		}
		return null;
	}

	@Override
	public Object caseInstStore(InstStore store) {
		Var var = store.getTarget().getVariable();
		Pattern pattern = currentAction.getOutputPattern();
		if (var.eContainer() == pattern) {
			portWrittenList.add(pattern.getPort(var));
		}
		return null;
	}

	/**
	 * Creates a new empty action with the given name.
	 * 
	 * @param name
	 *            action name
	 * @return a new empty action with the given name
	 */
	private Action createNewAction(String name) {
		IrFactory fac = IrFactory.eINSTANCE;

		// scheduler
		Procedure scheduler = fac.createProcedure("isSchedulable_" + name, 0,
				fac.createTypeBool());
		NodeBlock block = scheduler.getFirst();
		Instruction inst = fac.createInstReturn(fac.createExprBool(true));
		inst.setPredicate(fac.createPredicate());
		block.add(inst);

		// body
		Procedure body = fac.createProcedure(name, 0, fac.createTypeVoid());
		block = body.getFirst();
		inst = fac.createInstReturn();
		inst.setPredicate(fac.createPredicate());
		block.add(inst);

		// create action
		Action action = fac.createAction(fac.createTag(name),
				fac.createPattern(), currentAction.getOutputPattern(),
				fac.createPattern(), scheduler, body);
		currentAction.setOutputPattern(fac.createPattern());
		movePatternVariables(action.getOutputPattern());

		// add action to actor's actions
		actor.getActions().add(action);

		return action;
	}

	/**
	 * Returns the global variable associated with the given local variable. If
	 * no global is associated yet, create one and adds a store after the
	 * definition of the given local variable.
	 * 
	 * @param local
	 *            a local variable
	 * @return the global variable associated with the given local variable
	 */
	private Var getGlobal(Var local) {
		IrFactory fac = IrFactory.eINSTANCE;

		Var global = mapGlobals.get(local.getName());
		if (global == null) {
			global = fac.createVar(0, copy(local.getType()),
					"sg_" + local.getName(), true, null);
			actor.getStateVars().add(global);
			mapGlobals.put(local.getName(), global);

			InstStore store = fac.createInstStore(global,
					fac.createExprVar(local));
			store.setPredicate(fac.createPredicate());

			Instruction inst = EcoreHelper.getContainerOfType(local.getDefs()
					.get(0), Instruction.class);
			NodeBlock block = inst.getBlock();
			int index = block.indexOf(inst);
			block.add(index + 1, store);
		}

		return global;
	}

	/**
	 * Returns a new unique state name.
	 * 
	 * @return a new unique state name
	 */
	private String getNewStateName() {
		String stateName = branchName;
		Integer count = stateNames.get(stateName);
		if (count == null) {
			count = 1;
		}
		stateNames.put(stateName, count + 1);

		return stateName + "_" + count;
	}

	/**
	 * Moves the variables that are in the output pattern of the current action
	 * and have not yet been stored.
	 * 
	 * @param nextOutput
	 *            output pattern of the next action
	 */
	private void movePatternVariables(Pattern nextOutput) {
		// move ports and variables back in the current output if they have
		// already been written
		Pattern currentOutput = currentAction.getOutputPattern();
		for (Port port : portWrittenList) {
			Var var = nextOutput.getVariable(port);
			currentOutput.setVariable(port, var);
			nextOutput.remove(port);
		}
	}

	/**
	 * Replaces the transition <code>source</code> -&gt; <code>target</code> by
	 * a transition <code>source</code> -&gt; <code>newState</code> -&gt;
	 * <code>target</code>.
	 * 
	 * @param newAction
	 *            the newly-created action
	 */
	private void replaceTransition(Action newAction) {
		// add an FSM if the actor does not have one
		if (fsm == null) {
			addFsm();
		}

		// add state and transitions
		String newStateName = newAction.getName();
		State newState = IrFactory.eINSTANCE.createState(newStateName);
		statesMap.put(newStateName, newState);
		fsm.getStates().add(newState);

		fsm.replaceTarget(source, currentAction, newState);
		fsm.addTransition(newState, newAction, target);
	}

	/**
	 * Split the current action
	 */
	private void splitAction(InstSplit instSplit) {
		// create new action
		String newActionName = getNewStateName();
		nextAction = createNewAction(newActionName);

		// remove the SplitInstruction
		NodeBlock block = instSplit.getBlock();
		IrUtil.delete(instSplit);

		// move instructions
		NodeBlock targetBlock = nextAction.getBody().getFirst();
		List<Instruction> instructions = block.getInstructions();
		targetBlock.getInstructions().addAll(0,
				instructions.subList(indexInst, instructions.size()));

		// update transitions
		replaceTransition(nextAction);

		// set new source state to the new state name
		source = statesMap.get(newActionName);
	}

	/**
	 * Updates the given use using the mapLocals map. If no local is associated
	 * yet, create one and adds a load before the given instruction.
	 * 
	 * @param procedure
	 *            the target procedure
	 * @param instruction
	 *            the current instruction
	 * @param use
	 *            a use
	 */
	private void updateUse(Procedure procedure, Instruction instruction, Use use) {
		Var var = use.getVariable();
		Var local = mapLocals.get(var);
		if (!isAncestor(procedure, local)) {
			local = procedure.newTempLocalVariable(copy(var.getType()),
					var.getName());
			local.setIndex(1);
			mapLocals.put(var, local);

			// add a load at the beginning of the block
			Var global = getGlobal(var);
			InstLoad load = IrFactory.eINSTANCE.createInstLoad(local, global);
			load.setPredicate(IrFactory.eINSTANCE.createPredicate());

			NodeBlock block = instruction.getBlock();
			block.add(index++, load);
		}

		use.setVariable(local);
	}

	/**
	 * Visits the given transition characterized by its source, target and
	 * action.
	 * 
	 * @param source
	 *            source state
	 * @param target
	 *            target state
	 * @param action
	 *            action associated with transition
	 */
	private void visit(State source, State target, Action action) {
		this.source = source;
		this.target = target;
		doSwitch(action);
	}

	/**
	 * Visits all actions of this actor.
	 */
	private void visitAllActions() {
		fsm = actor.getFsm();
		if (fsm == null) {
			// no FSM: simply visit all the actions
			List<Action> actions = new ArrayList<Action>(
					actor.getActionsOutsideFsm());

			State initState = IrFactory.eINSTANCE.createState("init");
			statesMap.put("init", initState);

			for (Action action : actions) {
				// an FSM will be created if needed, from "init" to "init" (and
				// intermediate transitions created by the BranchVisitor)

				visit(initState, initState, action);
			}
		} else {
			// with an FSM: visits all transitions
			DirectedGraph<State, UniqueEdge> graph = fsm.getGraph();
			Set<UniqueEdge> edges = graph.edgeSet();
			for (UniqueEdge edge : edges) {
				State source = graph.getEdgeSource(edge);
				State target = graph.getEdgeTarget(edge);
				Action action = (Action) edge.getObject();
				visit(source, target, action);
			}
		}
	}

}
