/*
 * Copyright (c) 2009-2011, Ecole Polytechnique Fédérale de Lausanne, IRISA
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
 *   * Neither the name of the Ecole Polytechnique Fédérale de Lausanne, IRISA nor the names of its
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

package net.sf.orcc.backends.xlim.transformations;

import java.util.List;

import net.sf.orcc.ir.Actor;
import net.sf.orcc.ir.ExprBinary;
import net.sf.orcc.ir.ExprUnary;
import net.sf.orcc.ir.Param;
import net.sf.orcc.ir.Pattern;
import net.sf.orcc.ir.Port;
import net.sf.orcc.ir.Procedure;
import net.sf.orcc.ir.Type;
import net.sf.orcc.ir.TypeInt;
import net.sf.orcc.ir.TypeList;
import net.sf.orcc.ir.TypeUint;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.util.AbstractActorVisitor;

/**
 * This class defines a transformation that does not permit bitSize bigger than
 * 32. It also adds a bit for unsigned expressions.
 * 
 * @author Herve Yviquel
 * @author Endri Bezati
 * 
 */

public class ThirtyTwoBitCaster extends AbstractActorVisitor<Object> {

	public ThirtyTwoBitCaster() {
		super(true);
	}

	@Override
	public Object caseActor(Actor actor) {
		checkVariables(actor.getParameters());
		checkVariables(actor.getStateVars());
		checkPorts(actor.getInputs());
		checkPorts(actor.getOutputs());

		return super.caseActor(actor);
	}

	@Override
	public Object caseExprBinary(ExprBinary expr) {
		checkType(expr.getType());
		return super.caseExprBinary(expr);
	}

	@Override
	public Object caseExprUnary(ExprUnary expr) {
		checkType(expr.getType());
		return super.caseExprUnary(expr);
	}

	@Override
	public Object casePattern(Pattern pattern) {
		for (Var var : pattern.getVariables()) {
			if (!pattern.getPort(var).isNative()) {
				checkType(var.getType());
			}
		}
		return null;
	}

	@Override
	public Object caseProcedure(Procedure procedure) {
		checkParameters(procedure.getParameters());
		checkVariables(procedure.getLocals());
		checkType(procedure.getReturnType());
		return super.caseProcedure(procedure);
	}

	private void checkParameters(List<Param> parameters) {
		for (Param param : parameters) {
			Var var = param.getVariable();
			checkType(var.getType());
		}
	}

	private void checkPorts(List<Port> ports) {
		for (Port port : ports) {
			if (!port.isNative()) {
				checkType(port.getType());
			}
		}
	}

	private void checkType(Type type) {
		checkType(type, 0);
	}

	private void checkType(Type type, int newSize) {
		int size;
		if (type.isInt()) {
			TypeInt intType = (TypeInt) type;
			if (newSize > 0) {
				size = newSize;
			} else {
				size = getIntSize(intType.getSize());
			}
			intType.setSize(size);
		} else if (type.isUint()) {
			TypeUint uintType = (TypeUint) type;
			if (newSize > 0) {
				size = newSize;
			} else {
				size = getIntSize(uintType.getSize()) + 1;
				if (size > 32) {
					size = 32;
				}
			}
			uintType.setSize(size);
		} else if (type.isList()) {
			TypeList listType = (TypeList) type;
			checkType(listType.getType(), newSize);
		}
	}

	private void checkVariables(List<Var> vars) {
		for (Var var : vars) {
			checkType(var.getType());
		}
	}

	private int getIntSize(int size) {
		if (size > 32) {
			return 32;
		} else {
			return size;
		}
	}

}