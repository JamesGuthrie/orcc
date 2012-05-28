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
package net.sf.orcc.df.transform;

import java.util.ArrayList;
import java.util.List;

import net.sf.orcc.df.Actor;
import net.sf.orcc.df.Argument;
import net.sf.orcc.df.Connection;
import net.sf.orcc.df.Instance;
import net.sf.orcc.df.Network;
import net.sf.orcc.df.Port;
import net.sf.orcc.df.util.DfSwitch;
import net.sf.orcc.graph.Edge;
import net.sf.orcc.ir.ExprList;
import net.sf.orcc.ir.Expression;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.Var;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

/**
 * This class defines a transformation that transforms a network into a new
 * network where instances of actors and networks are replaced by new actors and
 * networks where the value of parameters have been appropriately replaced.
 * 
 * @author Matthieu Wipliez
 * @author Hervé Yviquel
 * 
 */
public class Instantiator extends DfSwitch<Void> {

	static String BUFFER_SIZE = Connection.BUFFER_SIZE;

	private int defaultFifoSize;

	/**
	 * Creates a default instantiator, equivalent to
	 * <code>Instantiator(0)</code>.
	 */
	public Instantiator() {
		this(0);
	}

	/**
	 * Creates an instantiator that will replace instances of networks by
	 * instantiated networks.
	 * 
	 * @param defaultFifoSize
	 *            default FIFO size
	 */
	public Instantiator(int defaultFifoSize) {
		this.defaultFifoSize = defaultFifoSize;
	}

	@Override
	public Void caseNetwork(Network network) {
		// copy instances to entities/instances
		List<Instance> instances = new ArrayList<Instance>(
				network.getInstances());
		for (Instance instance : instances) {
			EObject entity = instance.getEntity();
			
			if (entity instanceof Actor) {
				// assigns arguments' values to instance's variables
				for (Argument argument : instance.getArguments()) {
					Expression value = (Expression) new Copier().copy(argument.getValue());
					if(argument.getVariable().getType().isList() && !argument.getValue().isExprList()){
						ExprList exprList = IrFactory.eINSTANCE.createExprList();
						exprList.getValue().add(value);
						value = exprList;
					}
					argument.getVariable().setInitialValue(value);
				}
			} else if (entity instanceof Network) {
				instantiate(network, instance, entity);
			}
		}

		// update FIFO size
		for (Connection connection : network.getConnections()) {
			if (connection.getAttribute(BUFFER_SIZE) == null
					&& defaultFifoSize != 0) {
				connection.setAttribute(BUFFER_SIZE, defaultFifoSize);
			}
		}
		return null;
	}

	private void connect(Copier copier, Instance instance,
			Network instantiatedNetwork) {
		List<Edge> incoming = new ArrayList<Edge>(instance.getIncoming());
		for (Edge edge : incoming) {
			edge.setTarget(instantiatedNetwork);
			Connection connection = (Connection) edge;
			connection.setTargetPort((Port) copier.get(connection
					.getTargetPort()));
		}

		List<Edge> outgoing = new ArrayList<Edge>(instance.getOutgoing());
		for (Edge edge : outgoing) {
			edge.setSource(instantiatedNetwork);
			Connection connection = (Connection) edge;
			connection.setSourcePort((Port) copier.get(connection
					.getSourcePort()));
		}
	}

	private void instantiate(Network network, Instance instance, EObject entity) {
		// copy sub network
		Copier copier = new Copier();
		Network subNetwork = (Network) copier.copy(entity);
		copier.copyReferences();

		// instantiate sub network
		doSwitch(subNetwork);

		// rename sub network
		subNetwork.setName(instance.getName());

		// replace connections of instance
		network.add(subNetwork);
		connect(copier, instance, subNetwork);

		// remove instance
		network.remove(instance);

		// assigns arguments' values to network's variables
		for (Argument argument : instance.getArguments()) {
			Var var = (Var) copier.get(argument.getVariable());
			Expression value = argument.getValue();
			var.setInitialValue(value);
		}
	}

}