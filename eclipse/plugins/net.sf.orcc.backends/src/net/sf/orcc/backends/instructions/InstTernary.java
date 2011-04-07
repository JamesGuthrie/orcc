/*
 * Copyright (c) 2010-2011, IETR/INSA of Rennes
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
package net.sf.orcc.backends.instructions;

import net.sf.orcc.ir.Def;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.InstSpecific;

/**
 * This interface defines an instruction for a ternary if.
 * 
 * @author Herve Yviquel
 * @model extends="net.sf.orcc.ir.InstSpecific"
 */
public interface InstTernary extends InstSpecific {

	/**
	 * Returns the condition value of this instruction.
	 * 
	 * @return the condition value of this instruction
	 * @model containment="true"
	 */
	Expression getConditionValue();

	/**
	 * Returns the expression of the "false" branch.
	 * 
	 * @return the expression of the "false" branch
	 * @model containment="true"
	 */
	Expression getFalseValue();

	/**
	 * Returns the target of this instruction.
	 * 
	 * @return the target of this instruction
	 * @model containment="true"
	 */
	Def getTarget();

	/**
	 * Returns the expression of the "true" branch.
	 * 
	 * @return the expression of the "true" branch
	 * @model containment="true"
	 */
	Expression getTrueValue();

	/**
	 * Sets the condition value of this instruction.
	 * 
	 * @param value
	 *            the new condition value of this instruction
	 */
	void setConditionValue(Expression value);

	/**
	 * Sets the expression of the "false" branch.
	 * 
	 * @param value
	 *            the expression of the "false" branch
	 */
	void setFalseValue(Expression value);

	/**
	 * Sets the target of this instruction.
	 * 
	 * @param value
	 *            the new the target of this instruction
	 */
	void setTarget(Def value);

	/**
	 * Sets the expression of the "true" branch.
	 * 
	 * @param value
	 *            the expression of the "true" branch
	 */
	void setTrueValue(Expression value);

}
