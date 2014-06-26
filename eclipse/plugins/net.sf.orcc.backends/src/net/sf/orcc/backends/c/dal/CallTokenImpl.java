package net.sf.orcc.backends.c.dal;

import java.util.Collection;

import net.sf.orcc.ir.InstCall;
import net.sf.orcc.ir.Var;

/**
 * Implementation of the Token for instructions of the type InstCall
 *
 * @author James Guthrie
 *
 */
public class CallTokenImpl extends TokenImpl implements Token {

	public CallTokenImpl(InstCall instCall) {
		i = instCall;
	}

	@Override
	public InstCall getInstruction() {
		return (InstCall) i;
	}

	@Override
	public Var getTargetVar() {
		return ((InstCall) i).getTarget().getVariable();
	}

	// TODO: replace functionality of this with toString()?
	private String getIdentifyingString() {
		return getInstruction().getProcedure().getName() + "_" + new Stringifier().doSwitch(getInstruction().getArguments());
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

	@Override
	public boolean in(Collection<Var> vars) {
		String thisName = getInstruction().getTarget().getVariable().getName();
		for (Var v : vars) {
			if (v.getName().equals(thisName)) {
				return true;
			}
		}
		return false;
	}

}
