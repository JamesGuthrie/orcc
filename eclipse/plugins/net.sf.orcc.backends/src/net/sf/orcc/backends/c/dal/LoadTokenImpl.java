package net.sf.orcc.backends.c.dal;

import java.util.List;

import net.sf.orcc.ir.ExprInt;
import net.sf.orcc.ir.Expression;
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
	public boolean usesGlobal() {
		return i.getSource().getVariable().isGlobal();
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
			InstLoad otherLoad = (InstLoad) otherInst;
		    List<Expression> uIndexes = this.i.getIndexes();
		    List<Expression> vIndexes = otherLoad.getIndexes();
		    boolean flag = true;
			for (Expression e : uIndexes) {
				boolean iflag = false;
				for (Expression f : vIndexes) {
					if (e instanceof ExprInt && f instanceof ExprInt) {
						if (((ExprInt) e).getIntValue() == ((ExprInt) f).getIntValue()) {
							iflag = true;
						}
					}
				}
				if (iflag == false) {
					flag = false;
				}
			}
			String uName = this.i.getSource().getVariable().getName();
			String vName = otherLoad.getSource().getVariable().getName();
			if (uName.equals(vName) && flag == true) {
				return 0;
			} else {
			    return uName.concat(uIndexes.toString()).compareTo(vName.concat(vIndexes.toString()));
			}
		}
	}

	@Override
	public String toString() {
		return i.toString();
	}
}
