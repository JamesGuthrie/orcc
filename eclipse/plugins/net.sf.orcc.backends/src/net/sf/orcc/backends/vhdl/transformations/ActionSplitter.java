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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.orcc.backends.instructions.InstSplit;
import net.sf.orcc.ir.Action;
import net.sf.orcc.ir.Actor;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.FSM;
import net.sf.orcc.ir.InstSpecific;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.NodeBlock;
import net.sf.orcc.ir.Procedure;
import net.sf.orcc.ir.State;
import net.sf.orcc.ir.Tag;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.impl.IrFactoryImpl;
import net.sf.orcc.ir.util.AbstractActorVisitor;
import net.sf.orcc.ir.util.EcoreHelper;
import net.sf.orcc.util.UniqueEdge;

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

	/**
	 * action to visit next (may be null)
	 */
	private Action nextAction;

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

			doSwitch(currentAction.getBody());
		}
		return null;
	}

	@Override
	public Object caseActor(Actor actor) {
		this.actor = actor;
		stateNames = new HashMap<String, Integer>();
		statesMap = new HashMap<String, State>();
		visitAllActions();

		DataMover mover = new DataMover(actor);
		for (Action action : actor.getActions()) {
			mover.doSwitch(action);
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

	/**
	 * Creates a new empty action with the given name.
	 * 
	 * @param name
	 *            action name
	 * @return a new empty action with the given name
	 */
	private Action createNewAction(Expression condition, String name) {
		// scheduler
		Procedure scheduler = IrFactory.eINSTANCE.createProcedure(
				"isSchedulable_" + name, IrFactory.eINSTANCE.createLocation(),
				IrFactory.eINSTANCE.createTypeBool());
		Var result = scheduler.newTempLocalVariable(
				IrFactory.eINSTANCE.createTypeBool(), "result");
		result.setIndex(1);

		NodeBlock block = IrFactoryImpl.eINSTANCE.createNodeBlock();
		block.add(IrFactory.eINSTANCE.createInstAssign(result, condition));
		block.add(IrFactory.eINSTANCE.createInstReturn(IrFactory.eINSTANCE
				.createExprVar(result)));
		for (Instruction instruction : block.getInstructions()) {
			instruction.setPredicate(IrFactory.eINSTANCE.createPredicate());
		}
		scheduler.getNodes().add(block);

		// body
		Procedure body = IrFactory.eINSTANCE.createProcedure(name,
				IrFactory.eINSTANCE.createLocation(),
				IrFactory.eINSTANCE.createTypeVoid());
		block = IrFactoryImpl.eINSTANCE.createNodeBlock();
		Instruction inst = IrFactory.eINSTANCE.createInstReturn();
		inst.setPredicate(IrFactory.eINSTANCE.createPredicate());
		block.add(inst);
		body.getNodes().add(block);

		// tag
		Tag tag = IrFactory.eINSTANCE.createTag(name);

		Action action = IrFactory.eINSTANCE.createAction(
				IrFactory.eINSTANCE.createLocation(), tag,
				IrFactory.eINSTANCE.createPattern(),
				currentAction.getOutputPattern(),
				IrFactory.eINSTANCE.createPattern(), scheduler, body);
		currentAction.setOutputPattern(IrFactory.eINSTANCE.createPattern());

		// add action to actor's actions
		actor.getActions().add(action);

		return action;
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
		String newActionName = getNewStateName();

		// create new action
		nextAction = createNewAction(IrFactory.eINSTANCE.createExprBool(true),
				newActionName);

		// remove the SplitInstruction
		NodeBlock block = instSplit.getBlock();
		EcoreHelper.delete(instSplit);

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
