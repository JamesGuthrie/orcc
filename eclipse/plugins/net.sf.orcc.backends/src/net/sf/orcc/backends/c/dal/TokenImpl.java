package net.sf.orcc.backends.c.dal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.sf.orcc.OrccRuntimeException;
import net.sf.orcc.ir.Arg;
import net.sf.orcc.ir.ArgByRef;
import net.sf.orcc.ir.ArgByVal;
import net.sf.orcc.ir.ExprBinary;
import net.sf.orcc.ir.ExprInt;
import net.sf.orcc.ir.ExprVar;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.InstCall;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.util.AbstractIrVisitor;

public abstract class TokenImpl implements Token, Comparable<Token> {

	protected Instruction i;

	private class GetVars extends AbstractIrVisitor<Collection<Var>> {

		private Set<Var> vars;

		public GetVars() {
			super(true);
			vars = new HashSet<Var>();
		}

		@Override
		public Collection<Var> caseExpression(Expression expr) {
			throw new OrccRuntimeException("Unhandled expression type: " + expr.getClass());
		}

		@Override
		public Collection<Var> caseExprInt(ExprInt exprInt) {
			return new HashSet<Var>();
		}

		@Override
		public Collection<Var> caseExprBinary(ExprBinary exprBinary) {
			vars.addAll(doSwitch(exprBinary.getE1()));
			vars.addAll(doSwitch(exprBinary.getE2()));
			return new HashSet<Var>(vars);
		}

		@Override
		public Collection<Var> caseArgByVal(ArgByVal arg) {
			return doSwitch(arg.getValue());
		}

		@Override
		public Collection<Var> caseArgByRef(ArgByRef arg) {
			vars.add(arg.getUse().getVariable());
			return new HashSet<Var>(vars);
		}

		@Override
		public Collection<Var> caseInstLoad(InstLoad instLoad) {
			for (Expression e : instLoad.getIndexes()) {
				vars.addAll(doSwitch(e));
			}
			return new HashSet<Var>(vars);
		}

		@Override
		public Collection<Var> caseInstCall(InstCall instCall) {
			for (Arg a : instCall.getArguments()) {
				vars.addAll(doSwitch(a));
			}
			return new HashSet<Var>(vars);
		}

		@Override
		public Collection<Var> caseExprVar(ExprVar exprVar) {
			vars.add(exprVar.getUse().getVariable());
			return new HashSet<Var>(vars);
		}
	}

	@Override
	public Collection<Var> dependencies() {
		GetVars getVars = new GetVars();
		Collection<Var> result = getVars.doSwitch(i);
		return result;
	}

	@Override
	public boolean depsFulfilledBy(Collection<Var> fulfillingVars) {
		Collection<Var> deps = dependencies();
		Iterator<Var> iter = deps.iterator();
		while (iter.hasNext()) {
			Var dep = iter.next();
			if (dep.isGlobal()) {
				// If the dep has global scope it's not a true dep
				iter.remove();
			} else {
				// If it has local scope, and is contained in fulfullingVars, remove
				for (Var v : fulfillingVars) {
					if (dep.getName().equals(v.getName())) {
						iter.remove();
						break;
					}
				}
			}
		}
		// If all dependencies are fulfilled, deps is empty
		if (deps.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Token o) {
		// If an interdependency exists, use that as parameter for comparison
		Collection<Var> thisDeps, otherDeps;
		thisDeps = dependencies();
		otherDeps = o.dependencies();
		if (o.in(thisDeps)) {
			return 1;
		} else if (this.in(otherDeps)) {
			return -1;
		}
		int diff = thisDeps.size() - otherDeps.size();
		if (diff == 0) {
			return this.toString().compareTo(o.toString());
		} else {
			return diff;
		}
	}
}
