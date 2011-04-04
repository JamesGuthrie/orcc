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
package net.sf.orcc.ir;

import java.util.List;

import net.sf.orcc.ir.impl.NodeInterpreter;
import net.sf.orcc.ir.impl.NodeVisitor;

/**
 * This class defines a node in the CFG.
 * 
 * @author Matthieu Wipliez
 * @model abstract="true"
 */
public interface Node extends User {

	/**
	 * Accepts the given node interpreter.
	 * 
	 * @param interpreter
	 *            an interpreter
	 * @param args
	 *            arguments
	 * @return an object
	 */
	public Object accept(NodeInterpreter interpreter, Object... args);

	/**
	 * Accepts the given node visitor.
	 * 
	 * @param visitor
	 *            a visitor
	 * @param args
	 *            arguments
	 */
	public void accept(NodeVisitor visitor);

	/**
	 * Returns the label of this node as an integer.
	 * 
	 * @return the label of this node as an integer
	 */
	public int getLabel();

	/**
	 * Returns the location of this node.
	 * 
	 * @return the location of this node
	 * @model containment="true"
	 */
	public Location getLocation();

	/**
	 * Returns the predecessors of this node in the CFG.
	 * 
	 * @return the predecessors of this node in the CFG
	 */
	public List<Node> getPredecessors();

	/**
	 * Returns the procedure this node belongs to.
	 * 
	 * @return the procedure this node belongs to
	 */
	public Procedure getProcedure();

	/**
	 * Returns the successors of this node in the CFG.
	 * 
	 * @return the successors of this node in the CFG
	 */
	public List<Node> getSuccessors();

	/**
	 * Returns <code>true</code> if this node is a NodeBlock.
	 * 
	 * @return <code>true</code> if this node is a NodeBlock
	 */
	boolean isBlockNode();

	/**
	 * Returns <code>true</code> if this node is an NodeIf.
	 * 
	 * @return <code>true</code> if this node is an NodeIf
	 */
	boolean isIfNode();

	/**
	 * Returns <code>true</code> if this node is a NodeWhile.
	 * 
	 * @return <code>true</code> if this node is a NodeWhile
	 */
	boolean isWhileNode();

	/**
	 * Sets the location of this node.
	 * 
	 * @param location
	 *            the location of this node
	 */
	void setLocation(Location location);

}
