package net.sf.orcc.backends.c.dal.transform;

import java.util.HashMap;
import java.util.Map;

import net.sf.orcc.df.Action;
import net.sf.orcc.df.Actor;
import net.sf.orcc.df.Network;
import net.sf.orcc.df.util.DfVisitor;
import net.sf.orcc.ir.Def;
import net.sf.orcc.ir.ExprBinary;
import net.sf.orcc.ir.ExprInt;
import net.sf.orcc.ir.ExprVar;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.Use;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.util.AbstractIrVisitor;

/**
 * Rewrites the target of a load instruction to be the same name
 * across all instances of the load.
 *
 * TODO: fix support for complex index types
 *
 * @author James Guthrie
 *
 */
public class LoadRewriter extends DfVisitor<Void> {

	private Map<String, String> oldToNew = new HashMap<String, String>();

	private class ReNamer extends AbstractIrVisitor<String> {

		ReNamer() {
			super(true);
		}

		@Override
		public String caseExpression(Expression expr) {
			System.out.println("unhandled expr: " + expr);
			return "";
		}

		@Override
		public String caseExprVar(ExprVar exprVar) {
			return exprVar.getUse().getVariable().getName();
		}

		@Override
		public String caseExprInt(ExprInt exprInt) {
			return "" + exprInt.getIntValue();
		}

		@Override
		public String caseExprBinary(ExprBinary exprBinary) {
			String join = "";
			String left = doSwitch(exprBinary.getE1());
			String right = doSwitch(exprBinary.getE2());
			join = exprBinary.getOp().toString().toLowerCase();
			return left + "_" + join + "_" + right;
		}
	}

	private class IrVisitor extends AbstractIrVisitor<Void> {
		IrVisitor() {
			super(true);
		}

		@Override
		public Void caseInstLoad(InstLoad load){
			String newName = "local_" + load.getSource().getVariable().getName();
			for (Expression e : load.getIndexes()) {
				newName += "_" + new ReNamer().doSwitch(e);
			}
			Def target = load.getTarget();
			Var variable = target.getVariable();
			String oldName = variable.getName();
			if (!newName.equals(oldName)) {
				if (!oldToNew.containsKey(variable.getName())) {
					oldToNew.put(variable.getName(), newName);
				}
				variable.setName(newName);
				target.setVariable(variable);
				load.setTarget(target);
			}
			return null;
		}

		@Override
		public Void caseVar(Var var) {
			if (oldToNew.containsKey(var.getName())) {
				var.setName(oldToNew.get(var.getName()));
			}
			return null;
		}

		@Override
		public Void caseUse(Use use) {
			doSwitch(use.getVariable());
			return null;
		}

		@Override
		public Void caseExprVar(ExprVar e) {
			doSwitch(e.getUse());
			return null;
		}
	}

	@Override
	public Void caseNetwork(Network network) {
		for (Actor actor : network.getAllActors()) {
			for (Action action : actor.getActions()) {
				IrVisitor irVisitor = new IrVisitor();
				irVisitor.doSwitch(action.getScheduler().getBlocks());
				irVisitor.doSwitch(action.getBody().getBlocks());
			}
		}
		return null;
	}

}
