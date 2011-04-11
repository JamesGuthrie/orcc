/*
 * Copyright (c) 2011, IETR/INSA of Rennes
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
package net.sf.orcc.ir.util;

import java.util.Map;

import net.sf.orcc.ir.Actor;
import net.sf.orcc.ir.IrPackage;
import net.sf.orcc.ir.Port;
import net.sf.orcc.ir.Procedure;
import net.sf.orcc.ir.Var;
import net.sf.orcc.ir.impl.ActorImpl;
import net.sf.orcc.ir.impl.ProcedureImpl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

/**
 * This class defines an adapter that maintains a map of variables from a list
 * of variables.
 * 
 * @author Matthieu Wipliez
 * 
 */
public class MapAdapter implements Adapter {

	private Notifier target;

	@Override
	public Notifier getTarget() {
		return target;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return (type == Actor.class || type == Procedure.class);
	}

	@Override
	public void notifyChanged(Notification notification) {
		Map<String, Integer> map;
		String name;
		Object object = notification.getEventType() == Notification.ADD ? notification
				.getNewValue() : notification.getOldValue();

		if (notification.getFeature() == IrPackage.eINSTANCE
				.getProcedure_Locals()) {
			map = ((ProcedureImpl) target).getLocalsMap();
			name = ((Var) object).getIndexedName();
		} else if (notification.getFeature() == IrPackage.eINSTANCE
				.getProcedure_Parameters()) {
			map = ((ProcedureImpl) target).getParametersMap();
			name = ((Var) object).getIndexedName();
		} else if (notification.getFeature() == IrPackage.eINSTANCE
				.getActor_Inputs()) {
			map = ((ActorImpl) target).getInputsMap();
			name = ((Port) object).getName();
		} else if (notification.getFeature() == IrPackage.eINSTANCE
				.getActor_Outputs()) {
			map = ((ActorImpl) target).getOutputsMap();
			name = ((Port) object).getName();
		} else if (notification.getFeature() == IrPackage.eINSTANCE
				.getActor_Parameters()) {
			map = ((ActorImpl) target).getParametersMap();
			name = ((Var) object).getName();
		} else if (notification.getFeature() == IrPackage.eINSTANCE
				.getActor_Procs()) {
			map = ((ActorImpl) target).getProceduresMap();
			name = ((Procedure) object).getName();
		} else if (notification.getFeature() == IrPackage.eINSTANCE
				.getActor_StateVars()) {
			map = ((ActorImpl) target).getStateVariablesMap();
			name = ((Var) object).getName();
		} else {
			return;
		}

		if (notification.getEventType() == Notification.ADD) {
			map.put(name, notification.getPosition());
		} else if (notification.getEventType() == Notification.REMOVE) {
			map.remove(name);
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
		this.target = newTarget;
	}

}
