package net.sf.orcc.backends.c.dal;

import net.sf.orcc.OrccRuntimeException;
import net.sf.orcc.ir.Arg;
import net.sf.orcc.ir.ArgByRef;
import net.sf.orcc.ir.ArgByVal;
import net.sf.orcc.ir.ExprVar;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.InstCall;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.Var;

/**
 * Implementation of the Token for instructions of the type InstCall
 *
 * @author James Guthrie
 *
 */
public class CallTokenImpl implements Token{

	private InstCall i;

	public CallTokenImpl(InstCall instCall) {
		i = instCall;
	}

	@Override
	public boolean usesGlobal() {
		for (Arg a : ((InstCall) i).getArguments()) {
			if (a instanceof ArgByVal) {
				Expression e = ((ArgByVal) a).getValue();
				if (e instanceof ExprVar) {
					if (((ExprVar) e).getUse().getVariable().isGlobal()) {
						return true;
					}
				} else {
					throw new OrccRuntimeException("Unexpected Expression: " + e.getClass());
				}
			} else if (a instanceof ArgByRef) {
				if (((ArgByRef) a).getUse().getVariable().isGlobal()) {
					return true;
				}
			} else {
				throw new OrccRuntimeException("Unexpected Arg subclass: " + a.getClass());
			}
			return true;
		}
		return false;
	}

	@Override
	public Instruction getInstruction() {
		return i;
	}

	@Override
	public Var getTargetVar() {
		return ((InstCall) i).getTarget().getVariable();
	}

	@Override
	public int compareTo(Token o) {
		Instruction otherInst = o.getInstruction();
		if (otherInst instanceof InstLoad) {
			return 1;
		} else {
			return this.getIdentifyingString().compareTo(((CallTokenImpl) o).getIdentifyingString());
		}
	}

	private String getIdentifyingString() {
		return i.getProcedure().getName() + "_" + new Stringifier().doSwitch(i.getArguments());
	}

	@Override
	public String toString() {
		return i.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CallTokenImpl)) {
			return false;
		} else {
			return (this.compareTo((CallTokenImpl) obj) == 0);
		}
	}

	@Override
	public int hashCode() {
		return this.getIdentifyingString().hashCode();
	}
}
