/*
 * Copyright (c) 2009-2010, IETR/INSA of Rennes
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
package net.sf.orcc.backends.transformations.threeAddressCodeTransformation;

import java.util.List;
import java.util.ListIterator;

import net.sf.orcc.OrccException;
import net.sf.orcc.ir.Actor;
import net.sf.orcc.ir.CFGNode;
import net.sf.orcc.ir.Cast;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.LocalVariable;
import net.sf.orcc.ir.Location;
import net.sf.orcc.ir.Procedure;
import net.sf.orcc.ir.Type;
import net.sf.orcc.ir.Use;
import net.sf.orcc.ir.Variable;
import net.sf.orcc.ir.expr.AbstractExpressionInterpreter;
import net.sf.orcc.ir.expr.BinaryExpr;
import net.sf.orcc.ir.expr.BinaryOp;
import net.sf.orcc.ir.expr.VarExpr;
import net.sf.orcc.ir.instructions.Assign;
import net.sf.orcc.ir.instructions.Call;
import net.sf.orcc.ir.instructions.PhiAssignment;
import net.sf.orcc.ir.instructions.Return;
import net.sf.orcc.ir.nodes.BlockNode;
import net.sf.orcc.ir.transforms.AbstractActorTransformation;

/**
 * Add cast in IR in the form of assign instruction where target's type differs
 * from source type.
 * 
 * @author Jérôme GORIN
 * 
 */
public class CastAdderTransformation extends AbstractActorTransformation {

	private class ExpressionTypeChecker extends AbstractExpressionInterpreter {
		private ListIterator<Instruction> it;

		/**
		 * Creates a new expression splitter with the given list iterator. The
		 * iterator must be placed immediately before the expression to be
		 * translated is used.
		 * 
		 * @param it
		 *            iterator on a list of instructions
		 */
		public ExpressionTypeChecker(ListIterator<Instruction> it) {
			this.it = it;
		}

		@Override
		public Object interpret(BinaryExpr expr, Object... args) {
			Type type = expr.getType();
			BinaryOp op = expr.getOp();
			Expression e1 = expr.getE1();
			Expression e2 = expr.getE2();

			if (op.isComparison()) {
				Cast cast = new Cast(e1.getType(), e2.getType());
				if (cast.isExtended()) {
					e1 = (Expression) e1.accept(this, e2.getType());
				} else if (cast.isTrunced()) {
					e2 = (Expression) e2.accept(this, e1.getType());
				}
			} else {
				e1 = (Expression) e1.accept(this, type);
				e2 = (Expression) e2.accept(this, type);
			}

			expr.setE1(e1);
			expr.setE2(e2);

			return expr;
		}

		@Override
		public Object interpret(VarExpr expr, Object... args) {
			Type type = (Type) args[0];

			Cast cast = new Cast(expr.getType(), type);

			if (cast.isExtended() || cast.isTrunced()) {
				Location location = expr.getLocation();

				// Make a new assignment to the binary expression
				LocalVariable target = procedure.newTempLocalVariable(file,
						type, procedure.getName() + "_" + "expr");

				target.setIndex(1);

				VarExpr varExpr = new VarExpr(location, new Use(target));

				Assign assign = new Assign(location, target, expr);

				// Add assignement to instruction's list
				it.add(assign);

				return varExpr;
			}

			return expr;
		}

	}

	private String file;

	@Override
	public void transform(Actor actor) throws OrccException {
		this.file = actor.getFile();
		super.transform(actor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void visit(Assign assign, Object... args) {
		ListIterator<Instruction> it = (ListIterator<Instruction>) args[0];
		Expression value = assign.getValue();
		if (value.isBinaryExpr()) {
			BinaryExpr binExpr = (BinaryExpr) value;
			if (binExpr.getOp() == BinaryOp.BITAND) {
				//Todo : Force i32 operation on AND expression (to be removed)			
				Type type = IrFactory.eINSTANCE.createTypeInt(32);
				binExpr.setType(type);
			}

			it.previous();

			assign.getValue().accept(new ExpressionTypeChecker(it),
					value.getType());

			it.next();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void visit(Call call, Object... args) {
		ListIterator<Instruction> it = (ListIterator<Instruction>) args[0];
		List<Expression> parameters = call.getParameters();
		Procedure procedure = call.getProcedure();
		if (!procedure.isExternal()) {
			List<Variable> variables = call.getProcedure().getParameters()
					.getList();

			for (Expression parameter : parameters) {
				Variable variable = variables
						.get(parameters.indexOf(parameter));
				it.previous();
				Expression newParam = (Expression) parameter.accept(
						new ExpressionTypeChecker(it), variable.getType());
				parameters.set(parameters.indexOf(parameter), newParam);
				it.next();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void visit(PhiAssignment phi, Object... args) {
		ListIterator<Instruction> it = (ListIterator<Instruction>) args[0];
		List<Expression> values = phi.getValues();
		Type type = phi.getTarget().getType();

		for (Expression value : values) {
			int indexValue = values.indexOf(value);
			CFGNode node = phi.getBlock().getPredecessors().get(indexValue);

			if (node.isBlockNode()) {
				it = ((BlockNode) node).lastListIterator();
			}
			Expression newValue = (Expression) value.accept(
					new ExpressionTypeChecker(it), type);
			values.set(indexValue, newValue);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void visit(Return returnInstr, Object... args) {
		ListIterator<Instruction> it = (ListIterator<Instruction>) args[0];
		Type returnType = procedure.getReturnType();

		if ((returnType != null) && (!returnType.isVoid())) {

			it.previous();
			Expression value = returnInstr.getValue();
			Expression newValue = (Expression) value.accept(
					new ExpressionTypeChecker(it), returnType);
			returnInstr.setValue(newValue);
			it.next();
		}
	}

}
