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
package net.sf.orcc.frontend;

import java.util.HashMap;
import java.util.Map;

import net.sf.orcc.OrccException;
import net.sf.orcc.OrccRuntimeException;
import net.sf.orcc.cal.cal.AstActor;
import net.sf.orcc.cal.cal.AstEntity;
import net.sf.orcc.cal.cal.AstUnit;
import net.sf.orcc.ir.Actor;
import net.sf.orcc.ir.Unit;
import net.sf.orcc.ir.Use;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.util.IrUtil;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This class defines an RVC-CAL front-end.
 * 
 * @author Matthieu Wipliez
 * 
 */
public class Frontend {

	private ResourceSet set;

	private IFolder outputFolder;

	private Map<EObject, EObject> mapAstToIr;

	public Frontend(IFolder outputFolder) {
		this.outputFolder = outputFolder;
		mapAstToIr = new HashMap<EObject, EObject>();
		set = new ResourceSetImpl();
	}

	/**
	 * Compiles the given actor which is defined in the given file, and writes
	 * IR to the output folder defined by {@link #setOutputFolder(String)}.
	 * <p>
	 * Note that callers of this method must ensure that the actor has no errors
	 * for it to be properly compiled.
	 * </p>
	 * 
	 * @param file
	 *            name of the file where the actor is defined
	 * @param astActor
	 *            AST of the actor
	 * @throws OrccException
	 */
	public void compile(IFile file, AstEntity entity) {
		try {
			AstActor astActor = entity.getActor();
			if (astActor != null) {
				ActorTransformer transformer = new ActorTransformer();
				Actor actor = transformer.transform(file, astActor);
				mapAstToIr.put(astActor, actor);
				removeDanglingUses(actor);
				IrUtil.serializeActor(set, outputFolder, actor);
			} else {
				UnitTransformer transformer = new UnitTransformer();
				AstUnit astUnit = entity.getUnit();
				Unit unit = transformer.transform(file, astUnit);
				mapAstToIr.put(astUnit, unit);
			}
		} catch (OrccRuntimeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Warning: dirty hack! Removes uses that were created by the front-end but
	 * subsequently ignored.
	 * <p>
	 * These uses are called "dangling" because they cannot be reached from the
	 * top-level container (i.e. actor) through containment relations. Note that
	 * as such, using actor.eAllContents() does NOT return these uses, which is
	 * why this method is implemented as visiting the variables and their uses
	 * rather than by calling the EcoreHelper.getUses method.
	 * </p>
	 * <p>
	 * Removing allows IR actors to be serialized without errors. A long term
	 * solution would probably be to write a cleaner AST to IR translator.
	 * </p>
	 * 
	 * @param actor
	 *            the IR of an actor
	 */
	private void removeDanglingUses(Actor actor) {
		TreeIterator<EObject> it = actor.eAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof Var) {
				Var var = (Var) eObject;
				for (int i = 0; i < var.getUses().size(); i++) {
					Use use = var.getUses().get(i);
					if (!EcoreUtil.isAncestor(actor, use)) {
						use.setVariable(null);
						i--;
					}
				}
			}
		}
	}

}
