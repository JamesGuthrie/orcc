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
package net.sf.orcc.frontend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import net.sf.orcc.cal.cal.AstExpression;
import net.sf.orcc.cal.cal.AstExpressionBinary;
import net.sf.orcc.cal.cal.AstExpressionBoolean;
import net.sf.orcc.cal.cal.AstExpressionCall;
import net.sf.orcc.cal.cal.AstExpressionIf;
import net.sf.orcc.cal.cal.AstExpressionIndex;
import net.sf.orcc.cal.cal.AstExpressionInteger;
import net.sf.orcc.cal.cal.AstExpressionList;
import net.sf.orcc.cal.cal.AstExpressionString;
import net.sf.orcc.cal.cal.AstExpressionUnary;
import net.sf.orcc.cal.cal.AstExpressionVariable;
import net.sf.orcc.cal.cal.AstFunction;
import net.sf.orcc.cal.cal.AstGenerator;
import net.sf.orcc.cal.cal.AstProcedure;
import net.sf.orcc.cal.cal.AstStatement;
import net.sf.orcc.cal.cal.AstStatementAssign;
import net.sf.orcc.cal.cal.AstStatementCall;
import net.sf.orcc.cal.cal.AstStatementForeach;
import net.sf.orcc.cal.cal.AstStatementIf;
import net.sf.orcc.cal.cal.AstStatementWhile;
import net.sf.orcc.cal.cal.AstType;
import net.sf.orcc.cal.cal.AstTypeList;
import net.sf.orcc.cal.cal.AstVariable;
import net.sf.orcc.cal.cal.util.CalSwitch;
import net.sf.orcc.cal.expression.AstExpressionEvaluator;
import net.sf.orcc.cal.type.TypeChecker;
import net.sf.orcc.cal.util.BooleanSwitch;
import net.sf.orcc.ir.ExprVar;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.InstAssign;
import net.sf.orcc.ir.InstCall;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.InstReturn;
import net.sf.orcc.ir.InstStore;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.Location;
import net.sf.orcc.ir.Node;
import net.sf.orcc.ir.NodeBlock;
import net.sf.orcc.ir.NodeIf;
import net.sf.orcc.ir.NodeWhile;
import net.sf.orcc.ir.OpBinary;
import net.sf.orcc.ir.OpUnary;
import net.sf.orcc.ir.Procedure;
import net.sf.orcc.ir.Type;
import net.sf.orcc.ir.TypeList;
import net.sf.orcc.ir.Use;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.impl.IrFactoryImpl;
import net.sf.orcc.util.OrccUtil;
import net.sf.orcc.util.OrderedMap;
import net.sf.orcc.util.Scope;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This class transforms an AST actor to its IR equivalent.
 * 
 * @author Matthieu Wipliez
 * 
 */
public class AstTransformer {

	/**
	 * This class transforms an AST expression into one or more IR instructions
	 * and/or nodes, and returns an IR expression.
	 * 
	 */
	private class ExpressionTransformer extends CalSwitch<Expression> {

		private List<Expression> indexes;

		private Var target;

		public ExpressionTransformer() {
			indexes = new ArrayList<Expression>();
		}

		@Override
		public Expression caseAstExpressionBinary(AstExpressionBinary expression) {
			OpBinary op = OpBinary.getOperator(expression.getOperator());
			Expression e1 = doSwitch(expression.getLeft());
			Expression e2 = doSwitch(expression.getRight());

			return IrFactory.eINSTANCE.createExprBinary(e1, op, e2,
					EcoreUtil.copy(expression.getIrType()));
		}

		@Override
		public Expression caseAstExpressionBoolean(
				AstExpressionBoolean expression) {
			boolean value = expression.isValue();
			return IrFactory.eINSTANCE.createExprBool(value);
		}

		@Override
		public Expression caseAstExpressionCall(AstExpressionCall astCall) {
			Location location = Util.getLocation(astCall);
			Procedure procedure = context.getProcedure();

			// retrieve IR procedure
			AstFunction astFunction = astCall.getFunction();
			if (!mapFunctions.containsKey(astFunction)) {
				transformFunction(astFunction);
			}
			Procedure calledProcedure = mapFunctions.get(astFunction);

			// generates a new target
			Var target = procedure.newTempLocalVariable(file,
					EcoreUtil.copy(calledProcedure.getReturnType()), "call_"
							+ calledProcedure.getName());

			// creates call with spilling code around it
			createCall(location, target, calledProcedure,
					astCall.getParameters());

			// return local variable
			Expression varExpr = IrFactory.eINSTANCE.createExprVar(target);
			return varExpr;
		}

		@Override
		public Expression caseAstExpressionIf(AstExpressionIf expression) {
			Location location = Util.getLocation(expression);

			Expression condition = transformExpression(expression
					.getCondition());

			Var currentTarget = target;
			List<Expression> currentIndexes = indexes;

			Type type = expression.getIrType();
			// create a temporary variable if the target is null
			// or it is not null and the expression does not return a list
			if (target == null || !type.isList()) {
				// type of the new target will be the same as the type of the
				// existing target (if it is a scalar) or its innermost type (if
				// it is a list)
				if (target != null) {
					type = target.getType();
					if (type.isList()) {
						type = ((TypeList) type).getElementType();
					}
				}

				target = context.getProcedure().newTempLocalVariable(file,
						EcoreUtil.copy(type), "_tmp_if");
				indexes = new ArrayList<Expression>(0);
			}

			// transforms "then" statements and "else" statements
			List<Node> thenNodes = getNodes(expression.getThen());
			List<Node> elseNodes = getNodes(expression.getElse());

			NodeIf node = IrFactoryImpl.eINSTANCE.createNodeIf();
			node.setJoinNode(IrFactoryImpl.eINSTANCE.createNodeBlock());
			node.setLocation(location);
			node.setCondition(condition);
			node.getThenNodes().addAll(thenNodes);
			node.getElseNodes().addAll(elseNodes);
			context.getProcedure().getNodes().add(node);

			Expression varExpr = IrFactory.eINSTANCE.createExprVar(target);

			// restores target and indexes
			target = currentTarget;
			indexes = currentIndexes;

			// return the expression
			return varExpr;
		}

		@Override
		public Expression caseAstExpressionIndex(AstExpressionIndex expression) {
			// we always load in this case

			Location location = Util.getLocation(expression);
			AstVariable astVariable = expression.getSource().getVariable();
			Var var = context.getVariable(astVariable);
			if (var == null) {
				var = transformGlobalVariable(astVariable);
			}

			List<Expression> indexes = transformExpressions(expression
					.getIndexes());

			Var target = context.getProcedure().newTempLocalVariable(file,
					EcoreUtil.copy(expression.getIrType()),
					"local_" + var.getName());

			InstLoad load = IrFactory.eINSTANCE.createInstLoad(location,
					target, IrFactory.eINSTANCE.createUse(var), indexes);
			addInstruction(load);

			Expression varExpr = IrFactory.eINSTANCE.createExprVar(target);
			return varExpr;
		}

		@Override
		public Expression caseAstExpressionInteger(
				AstExpressionInteger expression) {
			long value = expression.getValue();
			return IrFactory.eINSTANCE.createExprInt(value);
		}

		@Override
		public Expression caseAstExpressionList(AstExpressionList astExpression) {
			Var currentTarget = target;
			List<Expression> currentIndexes = indexes;

			List<AstExpression> expressions = astExpression.getExpressions();
			List<AstGenerator> generators = astExpression.getGenerators();

			checkTarget(expressions, generators);

			if (generators.isEmpty()) {
				transformListSimple(expressions);
			} else {
				transformListGenerators(expressions, generators);
			}

			Expression expression = IrFactory.eINSTANCE.createExprVar(target);

			// restores target and indexes
			target = currentTarget;
			indexes = currentIndexes;

			// return the expression
			return expression;
		}

		@Override
		public Expression caseAstExpressionString(AstExpressionString expression) {
			return IrFactory.eINSTANCE.createExprString(OrccUtil
					.getEscapedString(expression.getValue()));
		}

		@Override
		public Expression caseAstExpressionUnary(AstExpressionUnary expression) {
			OpUnary op = OpUnary.getOperator(expression.getUnaryOperator());
			Expression expr = doSwitch(expression.getExpression());

			if (OpUnary.NUM_ELTS == op) {
				TypeList typeList = (TypeList) expr.getType();
				return IrFactory.eINSTANCE.createExprInt(typeList.getSize());
			}

			return IrFactory.eINSTANCE.createExprUnary(op, expr,
					EcoreUtil.copy(expression.getIrType()));
		}

		@Override
		public Expression caseAstExpressionVariable(
				AstExpressionVariable expression) {
			AstVariable astVariable = expression.getValue().getVariable();

			Var var = context.getVariable(astVariable);
			if (var == null) {
				var = globals.get(astVariable.getName());
				if (var == null) {
					var = transformGlobalVariable(astVariable);
				}
			}

			if (var.getType().isList()) {
				Expression varExpr = IrFactory.eINSTANCE.createExprVar(var);
				return varExpr;
			} else {
				Var v = null;
				if (context.getProcedure() != null) {
					v = getLocalVariable(var, false);
				} else {
					v = var;
				}

				Expression varExpr = IrFactory.eINSTANCE.createExprVar(v);
				return varExpr;
			}
		}

		/**
		 * Checks that the current target is not <code>null</code>. If it is,
		 * this method initializes it according to the expressions and
		 * generators.
		 * 
		 * @param expressions
		 *            a list of expressions
		 * @param generators
		 *            a list of generators
		 */
		private void checkTarget(List<AstExpression> expressions,
				List<AstGenerator> generators) {
			if (target != null) {
				return;
			}

			int size = 1;

			// size of generators
			for (AstGenerator generator : generators) {
				AstExpression astValue = generator.getLower();
				int lower = new AstExpressionEvaluator(null)
						.evaluateAsInteger(astValue);

				astValue = generator.getHigher();
				int higher = new AstExpressionEvaluator(null)
						.evaluateAsInteger(astValue);
				size *= (higher - lower) + 1;
			}

			// size of expressions
			TypeChecker checker = new TypeChecker(null);
			Type type = checker.getType(expressions);
			size *= expressions.size();

			Procedure procedure = context.getProcedure();
			Type listType = IrFactory.eINSTANCE.createTypeList(size,
					EcoreUtil.copy(type));
			target = procedure.newTempLocalVariable(file, listType, "_list");
		}

		/**
		 * Clears the target and indexes attributes.
		 */
		public void clearTarget() {
			target = null;
			indexes = new ArrayList<Expression>(0);
		}

		/**
		 * Returns a list of CFG nodes from the given expression. This method
		 * creates a new block node to hold the statements created when
		 * translating the expression, transforms the expression, and transfers
		 * the nodes created to a new list that is the result.
		 * 
		 * @param astExpression
		 *            an AST expression
		 * @return a list of CFG nodes
		 */
		private List<Node> getNodes(AstExpression astExpression) {
			Location location = Util.getLocation(astExpression);
			List<Node> nodes = context.getProcedure().getNodes();

			int first = nodes.size();
			nodes.add(IrFactoryImpl.eINSTANCE.createNodeBlock());

			Expression value = transformExpression(astExpression);
			createAssignOrStore(location, target, indexes, value);

			int last = nodes.size();

			// moves selected CFG nodes from "nodes" list to resultNodes
			List<Node> subList = nodes.subList(first, last);
			List<Node> resultNodes = new ArrayList<Node>(subList);
			subList.clear();

			return resultNodes;
		}

		/**
		 * Returns a list of CFG nodes from the given list of statements. This
		 * method creates a new block node to hold the statements, transforms
		 * the statements, and transfers the nodes created to a new list that is
		 * the result.
		 * 
		 * @param statements
		 *            a list of statements
		 * @return a list of CFG nodes
		 */
		private List<Node> getNodes(List<AstExpression> astExpressions) {
			List<Node> nodes = context.getProcedure().getNodes();

			int first = nodes.size();
			nodes.add(IrFactoryImpl.eINSTANCE.createNodeBlock());

			for (AstExpression astExpression : astExpressions) {
				Location location = Util.getLocation(astExpression);
				Expression value = transformExpression(astExpression);
				createAssignOrStore(location, target, indexes, value);
			}

			int last = nodes.size();

			// moves selected CFG nodes from "nodes" list to resultNodes
			List<Node> subList = nodes.subList(first, last);
			List<Node> resultNodes = new ArrayList<Node>(subList);
			subList.clear();

			return resultNodes;
		}

		/**
		 * Sets the target variable that is assigned a list expression with the
		 * given indexes.
		 * 
		 * @param target
		 *            a variable
		 * @param indexes
		 *            a list of indexes
		 */
		public void setTarget(Var target, List<Expression> indexes) {
			this.target = target;
			this.indexes = indexes;
		}

		/**
		 * Transforms the given expressions and generators.
		 * 
		 * @param expressions
		 *            a list of expressions
		 * @param generators
		 *            a list of generators
		 */
		private void transformListGenerators(List<AstExpression> expressions,
				List<AstGenerator> generators) {
			Var currentTarget = target;
			List<Expression> currentIndexes = indexes;

			indexes = new ArrayList<Expression>(currentIndexes);

			Procedure procedure = context.getProcedure();

			// first add local variables
			Expression index = null;
			for (AstGenerator generator : generators) {
				AstVariable astVariable = generator.getVariable();
				Var loopVar = transformLocalVariable(astVariable);
				procedure.getLocals().put(file, loopVar.getLocation(),
						loopVar.getName(), loopVar);

				AstExpression astLower = generator.getLower();
				int lower = new AstExpressionEvaluator(null)
						.evaluateAsInteger(astLower);
				Expression thisIndex = IrFactory.eINSTANCE
						.createExprVar(loopVar);
				if (lower != 0) {
					thisIndex = IrFactory.eINSTANCE.createExprBinary(thisIndex,
							OpBinary.MINUS,
							IrFactory.eINSTANCE.createExprInt(lower),
							EcoreUtil.copy(thisIndex.getType()));
				}

				AstExpression astHigher = generator.getHigher();
				int higher = new AstExpressionEvaluator(null)
						.evaluateAsInteger(astHigher);

				if (index == null) {
					index = thisIndex;
				} else {
					index = IrFactory.eINSTANCE.createExprBinary(
							IrFactory.eINSTANCE.createExprBinary(
									index,
									OpBinary.TIMES,
									IrFactory.eINSTANCE.createExprInt(higher
											- lower + 1),
									EcoreUtil.copy(index.getType())),
							OpBinary.PLUS, thisIndex, EcoreUtil.copy(index
									.getType()));
				}
			}

			indexes.add(index);

			// translates the expression (this will form the innermost nodes)
			List<Node> nodes = getNodes(expressions);

			// build the loops from the inside out
			ListIterator<AstGenerator> it = generators.listIterator(generators
					.size());
			while (it.hasPrevious()) {
				AstGenerator generator = it.previous();
				Location location = Util.getLocation(generator);

				// assigns the loop variable its initial value
				AstVariable astVariable = generator.getVariable();
				Var loopVar = context.getVariable(astVariable);

				// condition
				AstExpression astHigher = generator.getHigher();
				Expression higher = transformExpression(astHigher);
				Expression condition = IrFactory.eINSTANCE.createExprBinary(
						IrFactory.eINSTANCE.createExprVar(loopVar),
						OpBinary.LE, higher,
						IrFactory.eINSTANCE.createTypeBool());

				// add increment to body
				NodeBlock block = procedure.getLast(nodes);
				InstAssign assign = IrFactory.eINSTANCE.createInstAssign(
						location, loopVar, IrFactory.eINSTANCE
								.createExprBinary(IrFactory.eINSTANCE
										.createExprVar(loopVar), OpBinary.PLUS,
										IrFactory.eINSTANCE.createExprInt(1),
										EcoreUtil.copy(loopVar.getType())));
				block.add(assign);

				// create while
				NodeWhile nodeWhile = IrFactoryImpl.eINSTANCE.createNodeWhile();
				nodeWhile
						.setJoinNode(IrFactoryImpl.eINSTANCE.createNodeBlock());
				nodeWhile.setCondition(condition);
				nodeWhile.getNodes().addAll(nodes);

				// create assign
				block = IrFactoryImpl.eINSTANCE.createNodeBlock();
				AstExpression astLower = generator.getLower();
				Expression lower = transformExpression(astLower);
				InstAssign assignInit = IrFactory.eINSTANCE.createInstAssign(
						location, loopVar, lower);
				block.add(assignInit);

				// nodes
				nodes = new ArrayList<Node>(2);
				nodes.add(block);
				nodes.add(nodeWhile);
			}

			// add the outer while node
			procedure.getNodes().addAll(nodes);

			// restores target and indexes
			target = currentTarget;
			indexes = currentIndexes;
		}

		/**
		 * Transforms the list of expressions of an AstExpressionList (without
		 * generators).
		 * 
		 * @param expressions
		 *            a list of AST expressions
		 */
		private void transformListSimple(List<AstExpression> expressions) {
			Var currentTarget = target;
			List<Expression> currentIndexes = indexes;

			int i = 0;
			for (AstExpression expression : expressions) {
				Location location = Util.getLocation(expression);

				indexes = new ArrayList<Expression>(currentIndexes);
				indexes.add(IrFactory.eINSTANCE.createExprInt(i));
				i++;

				Expression value = transformExpression(expression);

				createAssignOrStore(location, target, indexes, value);
			}

			// restores target and indexes
			target = currentTarget;
			indexes = currentIndexes;
		}
	}

	/**
	 * This class transforms the expression passed to a print/println procedure
	 * to a list of IR expressions.
	 * 
	 * @author Matthieu Wipliez
	 * 
	 */
	private class PrintlnTransformer extends CalSwitch<Object> {

		private Object object;

		private List<Expression> parameters;

		public PrintlnTransformer(List<Expression> parameters) {
			this.parameters = parameters;
			this.object = new Object();
		}

		@Override
		public Object caseAstExpression(AstExpression astExpression) {
			Expression expression = transformExpression(astExpression);
			parameters.add(expression);

			return object;
		}

		@Override
		public Object caseAstExpressionBinary(AstExpressionBinary astExpression) {
			OpBinary op = OpBinary.getOperator(astExpression.getOperator());
			if (op == OpBinary.PLUS) {
				doSwitch(astExpression.getLeft());
				Expression expression = transformExpression(astExpression
						.getRight());
				parameters.add(expression);

				return object;
			}

			// fall back to general case
			return null;
		}

	}

	/**
	 * This class transforms an AST statement into one or more IR instructions
	 * and/or nodes. It returns null because it appends the instructions/nodes
	 * directly to the {@link #nodes} field.
	 * 
	 */
	private class StatementTransformer extends CalSwitch<Object> {

		private Object object;

		public StatementTransformer() {
			this.object = new Object();
		}

		@Override
		public Object caseAstStatementAssign(AstStatementAssign astAssign) {
			Location location = Util.getLocation(astAssign);

			// get target
			AstVariable astTarget = astAssign.getTarget().getVariable();
			Var target = context.getVariable(astTarget);
			if (target == null) {
				target = transformGlobalVariable(astTarget);
			}

			// transform indexes and value
			List<Expression> indexes = transformExpressions(astAssign
					.getIndexes());

			exprTransformer.setTarget(target, indexes);
			Expression value = transformExpression(astAssign.getValue());
			exprTransformer.clearTarget();
			createAssignOrStore(location, target, indexes, value);

			return object;
		}

		@Override
		public Object caseAstStatementCall(AstStatementCall astCall) {
			Location location = Util.getLocation(astCall);

			// retrieve IR procedure
			AstProcedure astProcedure = astCall.getProcedure();
			// special case if the procedure is a built-in procedure
			if (astProcedure.eContainer() == null) {
				transformBuiltinProcedure(astCall);
				return null;
			}

			if (!mapProcedures.containsKey(astProcedure)) {
				transformProcedure(astProcedure);
			}
			Procedure procedure = mapProcedures.get(astProcedure);

			// creates call with spilling code around it
			createCall(location, null, procedure, astCall.getParameters());

			return object;
		}

		@Override
		public Object caseAstStatementForeach(AstStatementForeach foreach) {
			Location location = Util.getLocation(foreach);
			Procedure procedure = context.getProcedure();

			// creates loop variable and assigns it
			AstVariable astVariable = foreach.getVariable();
			Var loopVar = transformLocalVariable(astVariable);
			procedure.getLocals().put(file, loopVar.getLocation(),
					loopVar.getName(), loopVar);

			AstExpression astLower = foreach.getLower();
			Expression lower = transformExpression(astLower);
			InstAssign assign = IrFactory.eINSTANCE.createInstAssign(location,
					loopVar, lower);
			addInstruction(assign);

			// condition
			AstExpression astHigher = foreach.getHigher();
			Expression higher = transformExpression(astHigher);
			Expression condition = IrFactory.eINSTANCE.createExprBinary(
					IrFactory.eINSTANCE.createExprVar(loopVar), OpBinary.LE,
					higher, IrFactory.eINSTANCE.createTypeBool());

			// body
			List<Node> nodes = getNodes(foreach.getStatements());
			NodeBlock block = procedure.getLast(nodes);
			assign = IrFactory.eINSTANCE.createInstAssign(location, loopVar,
					IrFactory.eINSTANCE.createExprBinary(
							IrFactory.eINSTANCE.createExprVar(loopVar),
							OpBinary.PLUS,
							IrFactory.eINSTANCE.createExprInt(1),
							EcoreUtil.copy(loopVar.getType())));
			block.add(assign);

			// create while
			NodeWhile nodeWhile = IrFactoryImpl.eINSTANCE.createNodeWhile();
			nodeWhile.setJoinNode(IrFactoryImpl.eINSTANCE.createNodeBlock());
			nodeWhile.setLocation(location);
			nodeWhile.setCondition(condition);
			nodeWhile.getNodes().addAll(nodes);

			procedure.getNodes().add(nodeWhile);

			return object;
		}

		@Override
		public Object caseAstStatementIf(AstStatementIf stmtIf) {
			Location location = Util.getLocation(stmtIf);
			Procedure procedure = context.getProcedure();

			Expression condition = transformExpression(stmtIf.getCondition());

			// transforms "then" statements and "else" statements
			List<Node> thenNodes = getNodes(stmtIf.getThen());
			List<Node> elseNodes = getNodes(stmtIf.getElse());

			NodeIf node = IrFactoryImpl.eINSTANCE.createNodeIf();
			node.setJoinNode(IrFactoryImpl.eINSTANCE.createNodeBlock());
			node.setLocation(location);
			node.setCondition(condition);
			node.getThenNodes().addAll(thenNodes);
			node.getElseNodes().addAll(elseNodes);

			procedure.getNodes().add(node);

			return object;
		}

		@Override
		public Object caseAstStatementWhile(AstStatementWhile stmtWhile) {
			Location location = Util.getLocation(stmtWhile);
			Procedure procedure = context.getProcedure();

			Expression condition = transformExpression(stmtWhile.getCondition());

			List<Node> nodes = getNodes(stmtWhile.getStatements());

			NodeWhile nodeWhile = IrFactoryImpl.eINSTANCE.createNodeWhile();
			nodeWhile.setJoinNode(IrFactoryImpl.eINSTANCE.createNodeBlock());
			nodeWhile.setLocation(location);
			nodeWhile.setCondition(condition);
			nodeWhile.getNodes().addAll(nodes);

			procedure.getNodes().add(nodeWhile);

			return object;
		}

		/**
		 * Returns a list of CFG nodes from the given list of statements. This
		 * method creates a new block node to hold the statements, transforms
		 * the statements, and transfers the nodes created to a new list that is
		 * the result.
		 * 
		 * @param statements
		 *            a list of statements
		 * @return a list of CFG nodes
		 */
		private List<Node> getNodes(List<AstStatement> statements) {
			List<Node> nodes = context.getProcedure().getNodes();

			int first = nodes.size();
			nodes.add(IrFactoryImpl.eINSTANCE.createNodeBlock());
			transformStatements(statements);
			int last = nodes.size();

			// moves selected CFG nodes from "nodes" list to resultNodes
			List<Node> subList = nodes.subList(first, last);
			List<Node> resultNodes = new ArrayList<Node>(subList);
			subList.clear();

			return resultNodes;
		}

		/**
		 * Transforms a call to a built-in procedure (print or println). Both
		 * are transformed to a call to print, with an additional "\\n"
		 * parameter in the case of println.
		 * 
		 * @param astCall
		 *            an AST call statement
		 */
		private void transformBuiltinProcedure(AstStatementCall astCall) {
			Location location = Util.getLocation(astCall);
			String name = astCall.getProcedure().getName();
			if ("print".equals(name) || "println".equals(name)) {
				Procedure procedure = procedures.get("print");
				if (procedure == null) {
					procedure = IrFactory.eINSTANCE.createProcedure("print",
							location, IrFactory.eINSTANCE.createTypeVoid());
					procedure.setNative(true);
					procedures.put("print", procedure);
				}

				List<AstExpression> astParameters = astCall.getParameters();
				List<Expression> parameters = new ArrayList<Expression>(7);
				if (!astParameters.isEmpty()) {
					AstExpression astExpression = astParameters.get(0);
					new PrintlnTransformer(parameters).doSwitch(astExpression);
				}

				if ("println".equals(name)) {
					parameters.add(IrFactory.eINSTANCE.createExprString("\\n"));
				}

				addInstruction(IrFactory.eINSTANCE.createInstCall(location,
						null, procedure, parameters));
			}
		}

	}

	/**
	 * allows creation of unique names
	 */
	private int blockCount;

	private Context context;

	/**
	 * expression transformer.
	 */
	final private ExpressionTransformer exprTransformer;

	/**
	 * The file in which the actor is defined.
	 */
	private String file;

	/**
	 * a map of global variables (parameters and state variables)
	 */
	private OrderedMap<String, Var> globals;

	private Procedure initialize;

	/**
	 * A map from AST functions to IR procedures.
	 */
	final private Map<AstFunction, Procedure> mapFunctions;

	/**
	 * A map from AST procedures to IR procedures.
	 */
	final private Map<AstProcedure, Procedure> mapProcedures;

	/**
	 * the list of procedures of the IR actor.
	 */
	private OrderedMap<String, Procedure> procedures;

	/**
	 * statement transformer.
	 */
	final private StatementTransformer stmtTransformer;

	/**
	 * Creates a new AST to IR transformation.
	 */
	public AstTransformer() {
		mapFunctions = new HashMap<AstFunction, Procedure>();
		mapProcedures = new HashMap<AstProcedure, Procedure>();

		exprTransformer = new ExpressionTransformer();
		stmtTransformer = new StatementTransformer();

		context = new Context(null, null);

		procedures = new OrderedMap<String, Procedure>();
	}

	/**
	 * Adds the given instruction to the last block of the current procedure.
	 * 
	 * @param instruction
	 *            an instruction
	 */
	private void addInstruction(Instruction instruction) {
		NodeBlock block = context.getProcedure().getLast();
		block.add(instruction);
	}

	/**
	 * Adds a return with the given value at the end of the given procedure.
	 * 
	 * @param procedure
	 *            a procedure
	 * @param value
	 *            an expression, possibly <code>null</code> for procedures that
	 *            do not have a return value
	 */
	public void addReturn(Procedure procedure, Expression value) {
		NodeBlock block = procedure.getLast();
		InstReturn returnInstr = IrFactory.eINSTANCE.createInstReturn(value);
		block.add(returnInstr);
	}

	/**
	 * Clears up context and functions/proceudres maps.
	 */
	public void clear() {
		blockCount = 0;

		mapFunctions.clear();
		mapProcedures.clear();

		exprTransformer.clearTarget();

		context = new Context(null, null);

		procedures = new OrderedMap<String, Procedure>();

		// clear the initialize procedure that may have been created
		initialize = null;
	}

	private void createAssignOrStore(Location location, Var target,
			List<Expression> indexes, Expression value) {
		// special case for list expressions
		if (value.isVarExpr()) {
			Use use = ((ExprVar) value).getUse();
			if (use.getVariable().getType().isList()) {
				return;
			}
		}

		Instruction instruction;
		if (indexes == null || indexes.isEmpty()) {
			Var local = getLocalVariable(target, true);
			instruction = IrFactory.eINSTANCE.createInstAssign(location, local,
					value);
		} else {
			instruction = IrFactory.eINSTANCE.createInstStore(location, target,
					indexes, value);
		}
		addInstruction(instruction);
	}

	/**
	 * Creates a call with the given arguments, and adds spilling code.
	 * 
	 * @param location
	 *            location of the call
	 * @param target
	 *            target (or <code>null</code>)
	 * @param procedure
	 *            procedure being called
	 * @param expressions
	 *            arguments
	 */
	private void createCall(Location location, Var target, Procedure procedure,
			List<AstExpression> expressions) {
		// transform parameters
		List<Expression> parameters = transformExpressions(expressions);

		// stores variables that have been loaded and modified, and are loaded
		// by the procedure
		for (Var global : procedure.getLoadedVariables()) {
			Var local = context.getMapGlobals().get(global);
			if (local != null
					&& context.getSetGlobalsToStore().contains(global)) {
				// variable already loaded somewhere and modified
				ExprVar value = IrFactory.eINSTANCE.createExprVar(local);

				List<Expression> indexes = new ArrayList<Expression>(0);
				InstStore store = IrFactory.eINSTANCE.createInstStore(location,
						global, indexes, value);
				addInstruction(store);
			}
		}

		// add call
		InstCall call = IrFactory.eINSTANCE.createInstCall(location, target,
				procedure, parameters);
		addInstruction(call);

		// loads variables that are stored by the procedure
		for (Var global : procedure.getStoredVariables()) {
			Var local = context.getMapGlobals().get(global);
			if (local == null) {
				// creates a new local variable
				local = context.getProcedure().newTempLocalVariable(file,
						EcoreUtil.copy(global.getType()),
						"local_" + global.getName());
				context.getMapGlobals().put(global, local);
			}

			InstLoad load = IrFactory.eINSTANCE.createInstLoad(local,
					IrFactory.eINSTANCE.createUse(global));
			addInstruction(load);
		}
	}

	/**
	 * Returns the current context of this AST transformer.
	 * 
	 * @return the current context of this AST transformer
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * Returns the value of the initialize attribute (which is set to null when
	 * the method returns).
	 * 
	 * @return the initialize procedure (or <code>null</code>)
	 */
	public Procedure getInitialize() {
		Procedure initialize = this.initialize;

		// adds return inst to initialize if it is not null
		if (initialize != null) {
			addReturn(initialize, null);
		}

		this.initialize = null;
		return initialize;
	}

	/**
	 * Returns the IR mapping of the given variable. If the variable is a
	 * global, returns a local associated with it. The variable is added to the
	 * set of globals to load, and if <code>isStored</code> is <code>true</code>
	 * , the variable is added to the set of variables to store, too.
	 * 
	 * @param var
	 *            an IR variable, possibly global
	 * @param isStored
	 *            <code>true</code> if the variable is stored,
	 *            <code>false</code> otherwise
	 * @return a local IR variable
	 */
	private Var getLocalVariable(Var var, boolean isStored) {
		if (var.isGlobal()) {
			Var local = context.getMapGlobals().get(var);
			if (local == null) {
				local = context.getProcedure()
						.newTempLocalVariable(file,
								EcoreUtil.copy(var.getType()),
								"local_" + var.getName());
				context.getMapGlobals().put(var, local);
			}

			context.getSetGlobalsToLoad().add(var);
			if (isStored) {
				context.getSetGlobalsToStore().add(var);
			}

			return local;
		}

		return var;
	}

	/**
	 * Returns the procedure map.
	 * 
	 * @return the procedure map
	 */
	public OrderedMap<String, Procedure> getProcedures() {
		return procedures;
	}

	/**
	 * Returns the qualified name for the given object.
	 * 
	 * @param obj
	 *            an object
	 * @return the qualified name for the given object
	 */
	private String getQualifiedName(AstVariable variable) {
		EObject cter = variable.eContainer();
		String name = variable.getName();
		if (cter instanceof AstGenerator) {
			name = "generator" + blockCount + "_" + name;
			blockCount++;
		} else if (cter instanceof AstStatementForeach) {
			name = "foreach" + blockCount + "_" + name;
			blockCount++;
		}

		return name;
	}

	/**
	 * Returns <code>true</code> if the given variable needs to be initialized
	 * in an <code>initialize</code> action. This is the case for lists that
	 * have generators, because we do not want to statically evaluate the
	 * generators as this potentially generates many values.
	 * 
	 * @param astVariable
	 *            a state variable
	 * @return <code>true</code> if the given variable needs to be initialized
	 *         in an <code>initialize</code> action
	 * 
	 */
	private boolean isInitializeNeeded(AstVariable astVariable) {
		Type type = astVariable.getIrType();
		AstExpression value = astVariable.getValue();
		if (type.isList() && value != null) {
			// the variable is a List with an initial value
			return new BooleanSwitch() {

				@Override
				public Boolean caseAstGenerator(AstGenerator generator) {
					return true;
				}

			}.doSwitch(value);
		}

		return false;
	}

	/**
	 * Loads the globals that need to be loaded.
	 */
	private void loadGlobals() {
		int i = 0;
		for (Var global : context.getSetGlobalsToLoad()) {
			Var local = context.getMapGlobals().get(global);

			InstLoad load = IrFactory.eINSTANCE.createInstLoad(local,
					IrFactory.eINSTANCE.createUse(global));
			NodeBlock block = context.getProcedure().getFirst();
			block.add(i, load);
			i++;
		}

		context.getSetGlobalsToLoad().clear();
	}

	/**
	 * Returns the current context, and creates a new one.
	 * 
	 * @return the current context
	 */
	public Context newContext(Procedure procedure) {
		Context oldContext = context;
		context = new Context(context, procedure);
		return oldContext;
	}

	/**
	 * Recursively convert a global variable of type List. If the size was not
	 * set, transform the size expression to IR and set the size.
	 * 
	 * @param type
	 *            The IR type of the list.
	 * @param astType
	 *            The AST type of the list.
	 */
	private void recTransformList(Type type, AstType astType) {
		if (type.isList()) {
			AstTypeList astTypeList = (AstTypeList) astType;
			TypeList typeList = (TypeList) type;
			if (typeList.getSizeExpr() == null) {
				// The size is not an integer constant, transform the size
				// expression now.
				Expression newSize = exprTransformer.doSwitch(astTypeList
						.getSize());
				typeList.setSizeExpr(newSize);
			}
			recTransformList(typeList.getType(), astTypeList.getType());
		}
	}

	/**
	 * Loads globals at the beginning of the current procedure, stores them at
	 * the end, and restores the context
	 * 
	 * @param context
	 *            the context returned by {@link #newContext()}
	 */
	public void restoreContext(Context context) {
		loadGlobals();
		storeGlobals();

		this.context = context;
	}

	/**
	 * Sets the field "file" with the given value.
	 * 
	 * @param file
	 *            a file name
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * Sets the map in which global variables should be put.
	 * 
	 * @param globals
	 *            a map
	 */
	public void setGlobalsMap(OrderedMap<String, Var> globals) {
		this.globals = globals;
	}

	/**
	 * Writes back the globals that need to be stored.
	 */
	private void storeGlobals() {
		for (Var global : context.getSetGlobalsToStore()) {
			Var local = context.getMapGlobals().get(global);
			ExprVar value = IrFactory.eINSTANCE.createExprVar(local);
			Location location = global.getLocation();

			List<Expression> indexes = new ArrayList<Expression>(0);
			InstStore store = IrFactory.eINSTANCE.createInstStore(location,
					global, indexes, value);
			addInstruction(store);
		}

		context.getSetGlobalsToStore().clear();
	}

	/**
	 * Transforms the given AST expression to an IR expression. In the process
	 * nodes may be created and added to the current {@link #procedure}, since
	 * many RVC-CAL expressions are expressed with IR statements.
	 * 
	 * @param expression
	 *            an AST expression
	 * @return an IR expression
	 */
	public Expression transformExpression(AstExpression expression) {
		Var target = exprTransformer.target;
		List<Expression> indexes = exprTransformer.indexes;
		Expression result = exprTransformer.doSwitch(expression);
		exprTransformer.target = target;
		exprTransformer.indexes = indexes;
		return result;
	}

	/**
	 * Transforms the given AST expressions to a list of IR expressions. In the
	 * process nodes may be created and added to the current {@link #procedure},
	 * since many RVC-CAL expressions are expressed with IR statements.
	 * 
	 * @param expressions
	 *            a list of AST expressions
	 * @return a list of IR expressions
	 */
	public List<Expression> transformExpressions(List<AstExpression> expressions) {
		int length = expressions.size();
		List<Expression> irExpressions = new ArrayList<Expression>(length);
		for (AstExpression expression : expressions) {
			irExpressions.add(transformExpression(expression));
		}
		return irExpressions;
	}

	/**
	 * Transforms the given AST function to an IR procedure, and adds it to the
	 * IR procedure list {@link #procedures} and to the map
	 * {@link #mapFunctions}.
	 * 
	 * @param astFunction
	 *            an AST function
	 */
	private void transformFunction(AstFunction astFunction) {
		String name = astFunction.getName();
		Location location = Util.getLocation(astFunction);
		Type type = astFunction.getIrType();

		Procedure procedure = IrFactory.eINSTANCE.createProcedure(name,
				location, EcoreUtil.copy(type));
		Context oldContext = newContext(procedure);

		transformParameters(astFunction.getParameters());
		transformLocalVariables(astFunction.getVariables());

		Expression value;
		if (astFunction.isNative()) {
			value = null;
		} else {
			Var target = exprTransformer.target;
			List<Expression> indexes = exprTransformer.indexes;
			exprTransformer.clearTarget();
			value = transformExpression(astFunction.getExpression());
			exprTransformer.setTarget(target, indexes);
		}

		restoreContext(oldContext);
		addReturn(procedure, value);

		if (astFunction.eContainer() == null || astFunction.isNative()) {
			procedure.setNative(true);
		}

		procedures.put(file, location, name, procedure);
		mapFunctions.put(astFunction, procedure);
	}

	/**
	 * Transforms AST state variables to IR state variables. The initial value
	 * of an AST state variable is evaluated to a constant by
	 * {@link #exprEvaluator}.
	 * 
	 * @param stateVariables
	 *            a list of AST state variables
	 * @return an ordered map of IR state variables
	 */
	public Var transformGlobalVariable(AstVariable astVariable) {
		Location location = Util.getLocation(astVariable);
		AstType astType = astVariable.getType();
		Type type = EcoreUtil.copy(astVariable.getIrType());
		if (type.isList()) {
			// Create a null context in order to prevent the expression
			// transformer
			// from adding a local_ prefix to every variable.
			Context oldContext = newContext(null);
			recTransformList(type, astType);
			restoreContext(oldContext);
		}
		String name = astVariable.getName();
		boolean assignable = !astVariable.isConstant();

		// check if the variable needs to be initialized in the "initialize"
		// procedure
		boolean mustInitialize = isInitializeNeeded(astVariable);
		Expression initialValue;
		if (mustInitialize) {
			initialValue = null;
		} else {
			AstExpression value = astVariable.getValue();
			initialValue = (Expression) astVariable.getInitialValue();
			if (initialValue == null && value != null) {
				initialValue = (Expression) new AstExpressionEvaluator(null)
						.evaluate(value);
			}
		}

		// create state variable
		Var variable = IrFactory.eINSTANCE.createVar(location, type, name,
				assignable, initialValue);

		// registers the global variable in the outermost scope
		Scope<AstVariable, Var> top = context.getMapVariables();
		while (top.getParent() != null) {
			top = top.getParent();
		}
		top.put(astVariable, variable);

		// translate and add to initialize
		if (mustInitialize) {
			if (initialize == null) {
				initialize = IrFactory.eINSTANCE.createProcedure("_initialize",
						location, IrFactory.eINSTANCE.createTypeVoid());
			}

			Context oldContext = newContext(initialize);
			context.newScope();

			exprTransformer.setTarget(variable, new ArrayList<Expression>(0));
			Expression expression = transformExpression(astVariable.getValue());
			createAssignOrStore(location, variable, null, expression);
			exprTransformer.clearTarget();

			context.restoreScope();
			restoreContext(oldContext);
		}

		globals.put(file, variable.getLocation(), variable.getName(), variable);

		return variable;
	}

	/**
	 * Transforms the given AST variable to an IR variable that has the name and
	 * type of <code>astVariable</code>. A binding is added to the
	 * {@link #mapVariables} between astVariable and the created local variable.
	 * 
	 * @param astVariable
	 *            an AST variable
	 * @return the IR local variable created
	 */
	public Var transformLocalVariable(AstVariable astVariable) {
		Location location = Util.getLocation(astVariable);

		String name = getQualifiedName(astVariable);

		boolean assignable = !astVariable.isConstant();
		Type type = astVariable.getIrType();

		// create local variable with the given name
		Var local = IrFactory.eINSTANCE.createVar(location,
				EcoreUtil.copy(type), name, assignable, 0);

		AstExpression value = astVariable.getValue();
		if (value != null) {
			exprTransformer.setTarget(local, new ArrayList<Expression>(0));
			Expression expression = transformExpression(value);
			createAssignOrStore(location, local, null, expression);
			exprTransformer.clearTarget();
		}

		context.putVariable(astVariable, local);
		return local;
	}

	/**
	 * Transforms the given list of AST variables to IR variables, and adds them
	 * to the current {@link #procedure}'s local variables list.
	 * 
	 * @param variables
	 *            a list of AST variables
	 */
	public void transformLocalVariables(List<AstVariable> variables) {
		for (AstVariable astVariable : variables) {
			Var local = transformLocalVariable(astVariable);
			context.getProcedure().getLocals()
					.put(file, local.getLocation(), local.getName(), local);
		}
	}

	/**
	 * Transforms the given list of AST parameters to IR variables, and adds
	 * them to the current {@link #procedure}'s parameters list.
	 * 
	 * @param parameters
	 *            a list of AST parameters
	 */
	private void transformParameters(List<AstVariable> parameters) {
		for (AstVariable astParameter : parameters) {
			Var local = transformLocalVariable(astParameter);
			context.getProcedure().getParameters()
					.put(file, local.getLocation(), local.getName(), local);
		}
	}

	/**
	 * Transforms the given AST procedure to an IR procedure, and adds it to the
	 * IR procedure list {@link #procedures} and to the map
	 * {@link #mapProcedures}.
	 * 
	 * @param astProcedure
	 *            an AST procedure
	 */
	private void transformProcedure(AstProcedure astProcedure) {
		String name = astProcedure.getName();
		Location location = Util.getLocation(astProcedure);

		Procedure procedure = IrFactory.eINSTANCE.createProcedure(name,
				location, IrFactory.eINSTANCE.createTypeVoid());
		Context oldContext = newContext(procedure);

		transformParameters(astProcedure.getParameters());
		transformLocalVariables(astProcedure.getVariables());
		transformStatements(astProcedure.getStatements());

		restoreContext(oldContext);
		addReturn(procedure, null);

		if (astProcedure.eContainer() == null || astProcedure.isNative()) {
			procedure.setNative(true);
		}

		procedures.put(file, location, name, procedure);
		mapProcedures.put(astProcedure, procedure);
	}

	/**
	 * Transforms the given AST statement to one or more IR instructions and/or
	 * nodes that are added directly to the current {@link #procedure}.
	 * 
	 * @param statement
	 *            an AST statement
	 */
	private void transformStatement(AstStatement statement) {
		stmtTransformer.doSwitch(statement);
	}

	/**
	 * Transforms the given AST statements to IR instructions and/or nodes that
	 * are added directly to the current {@link #procedure}.
	 * 
	 * @param statements
	 *            a list of AST statements
	 */
	public void transformStatements(List<AstStatement> statements) {
		for (AstStatement statement : statements) {
			transformStatement(statement);
		}
	}

}
