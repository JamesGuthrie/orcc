/*
 * Copyright (c) 2009, IETR/INSA of Rennes
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
package net.sf.orcc.ir.transformations;

import java.util.List;
import java.util.ListIterator;

import net.sf.orcc.ir.AbstractActorVisitor;
import net.sf.orcc.ir.Actor;
import net.sf.orcc.ir.ExprBool;
import net.sf.orcc.ir.ExprVar;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.InstAssign;
import net.sf.orcc.ir.InstPhi;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.Node;
import net.sf.orcc.ir.NodeBlock;
import net.sf.orcc.ir.NodeIf;
import net.sf.orcc.ir.Var;

/**
 * This class defines a very simple Dead Code Elimination.
 * 
 * @author Matthieu Wipliez
 * 
 */
public class DeadCodeElimination extends AbstractActorVisitor {

	private void addNodes(List<Node> nodes, NodeBlock join, int index) {
		itNode.previous();
		itNode.remove();

		for (Node node : nodes) {
			itNode.add(node);
		}

		itNode.add(join);
		replacePhis(join, index);
	}

	private void replacePhis(NodeBlock joinNode, int index) {
		ListIterator<Instruction> it = joinNode.listIterator();
		while (it.hasNext()) {
			Instruction instruction = it.next();
			if (instruction.isPhi()) {
				InstPhi phi = (InstPhi) instruction;

				Var target = phi.getTarget();
				ExprVar sourceExpr = (ExprVar) phi.getValues().get(index);
				Var source = (Var) sourceExpr.getUse().getVariable();

				// translate the phi to an assign
				ExprVar expr = IrFactory.eINSTANCE.createExprVar(source);
				InstAssign assign = IrFactory.eINSTANCE.createInstAssign(
						target, expr);

				it.set(assign);

				// remove the other variable
				ExprVar localExpr = (ExprVar) phi.getValues().get(1 - index);
				Var local = localExpr.getUse().getVariable();
				procedure.getLocals().remove(local.getName());
			}
		}
	}

	@Override
	public void visit(Actor actor) {
		// remove dead ifs and whiles
		super.visit(actor);

		// combines adjacent blocks that may have been created
		new BlockCombine().visit(actor);
	}

	@Override
	public void visit(NodeIf node) {
		Expression condition = node.getCondition();
		if (condition.isBooleanExpr()) {
			if (((ExprBool) condition).isValue()) {
				addNodes(node.getThenNodes(), node.getJoinNode(), 0);
			} else {
				addNodes(node.getElseNodes(), node.getJoinNode(), 1);
			}
		}
	}

}
