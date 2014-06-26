package net.sf.orcc.backends.c.dal;

import java.util.Collection;

import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.Var;

/**
 * Implementation of the Token for instructions of the type InstLoad
 *
 * @author James Guthrie
 *
 */
public class LoadTokenImpl extends TokenImpl implements Token {

	public LoadTokenImpl(InstLoad instLoad) {
		this.i = instLoad;
	}

	@Override
	public InstLoad getInstruction() {
		return (InstLoad) i;
	}

	@Override
	public Var getTargetVar() {
		return getInstruction().getTarget().getVariable();
	}

	// TODO: replace functionality of this with toString()?
	protected String getIdentifyingString() {
		String thisName = getInstruction().getSource().getVariable().getName();
		String thisIndexes = new Stringifier().doSwitch(getInstruction().getIndexes());
		return thisName + thisIndexes;
	}

	@Override
	public String toString() {
		return i.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LoadTokenImpl)) {
			return false;
		} else {
			return (this.compareTo((LoadTokenImpl) obj) == 0);
		}
	}

	@Override
	public int hashCode() {
		return this.getIdentifyingString().hashCode();
	}

	@Override
	public boolean isStateToken() {
		if (getInstruction().getSource().getVariable().isGlobal()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isInputToken() {
		if (getInstruction().getSource().getVariable().isGlobal()) {
			return false;
		} else {
			return true;
		}
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
