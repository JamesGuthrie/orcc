/*
 * Copyright (c) 2011, IRISA
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
 *   * Neither the name of the IRISA nor the names of its
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
package net.sf.orcc.backends.transformations;

import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.NodeIf;
import net.sf.orcc.ir.NodeWhile;
import net.sf.orcc.ir.util.AbstractActorVisitor;

/**
 * Remove empty node from if and while node.
 * 
 * @author Herve Yviquel
 * @author Jerome Gorin
 */
public class EmptyNodeRemover extends AbstractActorVisitor<Object> {

	@Override
	public Object caseNodeIf(NodeIf nodeIf) {
		if (nodeIf.getThenNodes().isEmpty()) {
			nodeIf.getThenNodes().add(IrFactory.eINSTANCE.createNodeBlock());
		}
		
		if (nodeIf.getElseNodes().isEmpty()) {
			nodeIf.getElseNodes().add(IrFactory.eINSTANCE.createNodeBlock());
		}
		super.caseNodeIf(nodeIf);
		return null;
	}
	
	@Override
	public Object caseNodeWhile(NodeWhile nodeWhile) {
		if (nodeWhile.getNodes().isEmpty()) {
			nodeWhile.getNodes().add(IrFactory.eINSTANCE.createNodeBlock());
		}
		
		super.caseNodeWhile(nodeWhile);
		
		return null;
	}

}
