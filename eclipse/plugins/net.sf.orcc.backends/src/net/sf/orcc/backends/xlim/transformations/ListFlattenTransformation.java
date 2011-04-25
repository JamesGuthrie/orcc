/*
 * Copyright (c) 2010, IETR/INSA of Rennes
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
package net.sf.orcc.backends.xlim.transformations;

import java.util.ArrayList;
import java.util.List;

import net.sf.orcc.backends.instructions.InstAssignIndex;
import net.sf.orcc.backends.instructions.InstructionsFactory;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.InstAssign;
import net.sf.orcc.ir.InstLoad;
import net.sf.orcc.ir.InstStore;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.NodeBlock;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.util.AbstractActorVisitor;
import net.sf.orcc.ir.util.EcoreHelper;

/**
 * This class defines an actor transformation that transforms declarations and
 * uses of multi-dimensional lists to declarations and uses of lists with a
 * single dimension.
 * 
 * @author Matthieu Wipliez
 * @author Nicolas Siret
 * @author Herve Yviquel
 * 
 */
public class ListFlattenTransformation extends AbstractActorVisitor<Object> {

	/**
	 * Prints the indexes of an NDim array.
	 */
	private void printAssignment(NodeBlock currentBlock,
			List<Expression> indexes) {
		List<Expression> listIndex = new ArrayList<Expression>(indexes.size());

		// returns the load or store, and has the effect that instructions will
		// be inserted before it
		itInstruction.previous();

		for (Expression expr : new ArrayList<Expression>(indexes)) {
			Var indexVar = procedure.newTempLocalVariable(
					IrFactory.eINSTANCE.createTypeInt(), "index");
			listIndex.add(IrFactory.eINSTANCE.createExprVar(indexVar));

			// add the assign instruction for each index
			InstAssign assign = IrFactory.eINSTANCE.createInstAssign(indexVar,
					expr);
			currentBlock.add(indexInst, assign);
			indexInst++;
		}

		// creates the variable that will hold the concatenation of indexes
		Var indexVar = procedure.newTempLocalVariable(
				IrFactory.eINSTANCE.createTypeInt(), "concat_index");

		// sets indexVar as memory index
		EcoreHelper.delete(indexes);
		indexes.add(IrFactory.eINSTANCE.createExprVar(indexVar));

		// add a special assign instruction that assigns the index variable the
		// concatenation of index expressions
		InstAssignIndex assignIndex = InstructionsFactory.eINSTANCE
				.createInstAssignIndex(indexVar, listIndex,
						IrFactory.eINSTANCE.createTypeInt());
		currentBlock.add(indexInst, assignIndex);
		indexInst++;
	}

	@Override
	public Object caseInstLoad(InstLoad load) {
		List<Expression> indexes = load.getIndexes();

		if (!indexes.isEmpty()) {
			printAssignment(
					EcoreHelper.getContainerOfType(load, NodeBlock.class),
					indexes);
		}

		return null;
	}

	@Override
	public Object caseInstStore(InstStore store) {
		List<Expression> indexes = store.getIndexes();

		if (!indexes.isEmpty()) {
			printAssignment(
					EcoreHelper.getContainerOfType(store, NodeBlock.class),
					indexes);
		}

		return null;
	}

}
