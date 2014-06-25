package net.sf.orcc.backends.c.dal;

import net.sf.orcc.ir.InstCall;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.Var;

/**
 * Implementation of the Token for instructions of the type InstLoad
 *
 * @author James Guthrie
 *
 */
public class LoadTokenImpl implements Token, Comparable<Token> {

	protected InstLoad i;

	public LoadTokenImpl(InstLoad instLoad) {
		this.i = instLoad;
	}

	@Override
	public Instruction getInstruction() {
		return i;
	}

	@Override
	public Var getTargetVar() {
		return i.getTarget().getVariable();
	}

	@Override
	public int compareTo(Token o) {
		Instruction otherInst = o.getInstruction();
		if (otherInst instanceof InstCall) {
			return -1;
		} else {
			return this.getIdentifyingString().compareTo(((LoadTokenImpl) o).getIdentifyingString());
		}
	}

	protected String getIdentifyingString() {
		String thisName = this.i.getSource().getVariable().getName();
		String thisIndexes = new Stringifier().doSwitch(this.i.getIndexes());
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
		if (this.i.getSource().getVariable().isGlobal()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isInputToken() {
		if (this.i.getSource().getVariable().isGlobal()) {
			return false;
		} else {
			return true;
		}
	}
}
