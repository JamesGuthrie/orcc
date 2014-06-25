package net.sf.orcc.backends.c.dal;

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

	@Override
	public boolean isStateToken() {
		return true;
	}

	@Override
	public boolean isInputToken() {
		return false;
	}
}
