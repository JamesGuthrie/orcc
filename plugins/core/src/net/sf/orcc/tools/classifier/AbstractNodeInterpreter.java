/*
 * Copyright (c) 2009-2010, IETR/INSA of Rennes
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
package net.sf.orcc.tools.classifier;

import java.lang.reflect.Array;

import net.sf.orcc.OrccRuntimeException;
import net.sf.orcc.interpreter.NodeInterpreter;
import net.sf.orcc.ir.Action;
import net.sf.orcc.ir.CFGNode;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.LocalVariable;
import net.sf.orcc.ir.Variable;
import net.sf.orcc.ir.instructions.HasTokens;
import net.sf.orcc.ir.instructions.Load;
import net.sf.orcc.ir.instructions.Peek;
import net.sf.orcc.ir.instructions.Read;
import net.sf.orcc.ir.instructions.Store;
import net.sf.orcc.ir.instructions.Write;
import net.sf.orcc.ir.nodes.IfNode;
import net.sf.orcc.ir.nodes.WhileNode;

/**
 * This class defines an abstract node/instruction interpreter. It refines the
 * existing interpreter by not relying on anything that is data-dependent.
 * 
 * @author Matthieu Wipliez
 * 
 */
public class AbstractNodeInterpreter extends NodeInterpreter {

	private Action action;

	private ConfigurationAnalyzer analyzer;

	private boolean portRead;

	private boolean schedulableMode;

	/**
	 * Creates a new abstract node interpreter that uses
	 * {@link AbstractExpressionEvaluator} to evaluate expressions.
	 */
	public AbstractNodeInterpreter() {
		super();
		exprInterpreter = new AbstractExpressionEvaluator();
	}

	/**
	 * Creates a new abstract node interpreter that uses the given configuration
	 * analyzer.
	 * 
	 * @param analyzer
	 *            a configuration analyzer
	 */
	public AbstractNodeInterpreter(ConfigurationAnalyzer analyzer) {
		this();
		this.analyzer = analyzer;
	}

	/**
	 * Sets the configuration action that should be executed.
	 * 
	 * @param action
	 *            an action
	 */
	public void setAction(Action action) {
		this.action = action;
	}

	/**
	 * Sets schedulable mode. When in schedulable mode, evaluations of null
	 * expressions is forbidden.
	 * 
	 * @param schedulableMode
	 */
	public void setSchedulableMode(boolean schedulableMode) {
		this.schedulableMode = schedulableMode;
		((AbstractExpressionEvaluator) exprInterpreter)
				.setSchedulableMode(schedulableMode);
	}

	@Override
	public void visit(HasTokens instr, Object... args) {
		instr.getTarget().setValue(true);
	}

	@Override
	public void visit(IfNode node, Object... args) {
		// Interpret first expression ("if" condition)
		Object condition = node.getValue().accept(exprInterpreter);

		if (condition instanceof Boolean) {
			if ((Boolean) condition) {
				for (CFGNode subNode : node.getThenNodes()) {
					subNode.accept(this, args);
				}
			} else {
				for (CFGNode subNode : node.getElseNodes()) {
					subNode.accept(this, args);
				}
			}
		} else if (schedulableMode) {
			// only throw exception in schedulable mode
			throw new OrccRuntimeException("null condition");
		}

		node.getJoinNode().accept(this, args);
	}

	@Override
	public void visit(Load instr, Object... args) {
		LocalVariable target = instr.getTarget();
		Variable source = instr.getSource().getVariable();
		if (instr.getIndexes().isEmpty()) {
			target.setValue(source.getValue());
		} else {
			Object obj = source.getValue();
			for (Expression index : instr.getIndexes()) {
				Integer lastIndex = (Integer) index.accept(exprInterpreter);
				if (obj != null && lastIndex != null) {
					obj = Array.get(obj, lastIndex);
				} else {
					obj = null;
				}
			}
			target.setValue(obj);
		}
	}

	@Override
	public void visit(Peek peek, Object... args) {
		if (peek.getPort().equals(analyzer.getConfigurationPort()) && !portRead) {
			int value = analyzer.getConfigurationValue(action);
			Object[] target = (Object[]) peek.getTarget().getValue();
			target[0] = value;
			portRead = true;
		}
	}

	@Override
	public void visit(Read read, Object... args) {
		if (read.getPort().equals(analyzer.getConfigurationPort())) {
			int value = analyzer.getConfigurationValue(action);
			Object[] target = (Object[]) read.getTarget().getValue();
			target[0] = value;
		}

		read.getPort().increaseTokenConsumption(read.getNumTokens());
	}

	@Override
	public void visit(Store instr, Object... args) {
		Variable variable = instr.getTarget().getVariable();
		if (instr.getIndexes().isEmpty()) {
			variable.setValue(instr.getValue().accept(exprInterpreter));
		} else {
			Object obj = variable.getValue();
			Object objPrev = obj;
			Integer lastIndex = 0;
			for (Expression index : instr.getIndexes()) {
				objPrev = obj;
				lastIndex = (Integer) index.accept(exprInterpreter);
				if (objPrev != null && lastIndex != null) {
					obj = Array.get(objPrev, lastIndex);
				}
			}

			if (objPrev != null && lastIndex != null) {
				Array.set(objPrev, lastIndex, instr.getValue().accept(
						exprInterpreter));
			}
		}
	}

	@Override
	public void visit(WhileNode node, Object... args) {
		// Interpret first expression ("while" condition)
		Object condition = node.getValue().accept(exprInterpreter);

		if (condition instanceof Boolean) {
			while ((Boolean) condition) {
				for (CFGNode subNode : node.getNodes()) {
					subNode.accept(this, args);
				}

				// Interpret next value of "while" condition
				condition = node.getValue().accept(exprInterpreter);
				if (!(condition instanceof Boolean) && schedulableMode) {
					// only throw exception in schedulable mode
					throw new OrccRuntimeException("null condition");
				}
			}
		} else if (schedulableMode) {
			// only throw exception in schedulable mode
			throw new OrccRuntimeException("null condition");
		}

		node.getJoinNode().accept(this, args);
	}

	@Override
	public void visit(Write write, Object... args) {
		write.getPort().increaseTokenProduction(write.getNumTokens());
	}

}
