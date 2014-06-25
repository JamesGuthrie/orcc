package net.sf.orcc.backends.c.dal;

import net.sf.orcc.ir.Instruction;
import net.sf.orcc.ir.Var;

/**
 * Defines an input token to be evaluated as part of the actor constraints
 *
 * @author James Guthrie
 *
 */
public interface Token extends Comparable<Token>{

	public Instruction getInstruction();

	public Var getTargetVar();

	public boolean isStateToken();

	public boolean isInputToken();

}
