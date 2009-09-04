/*
 * Copyright (c) 2009, IETR/INSA of Rennes
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
package net.sf.orcc.backends.llvm.nodes;

import java.util.List;

import net.sf.orcc.ir.Location;
import net.sf.orcc.ir.expr.AbstractExpr;
import net.sf.orcc.ir.nodes.PhiAssignment;

/**
 * @author J�r�me GORIN
 * 
 */
public class SelectNode extends AbstractLLVMNode{

	private List<PhiAssignment> phis;
	
	private AbstractExpr condition;


	public SelectNode(int id, Location location, AbstractExpr condition, 
						List<PhiAssignment> phis) {
		super(id, location);
		this.condition = condition;
		this.phis = phis;
	}

	@Override
	public void accept(LLVMNodeVisitor visitor, Object... args) {
		visitor.visit(this, args);
	}


	public AbstractExpr getCondition() {
		return condition;
	}

	public List<PhiAssignment> getPhis() {
		return phis;
	}
	
	public void setPhis(List<PhiAssignment> phis) {
		this.phis = phis;
	}
	
}
