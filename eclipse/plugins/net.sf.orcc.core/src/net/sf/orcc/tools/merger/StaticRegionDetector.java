/*
 * Copyright (c) 2010, EPFL
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
 *   * Neither the name of the EPFL nor the names of its contributors may be used 
 *     to endorse or promote products derived from this software without specific 
 *     prior written permission.
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

package net.sf.orcc.tools.merger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.sf.orcc.OrccException;
import net.sf.orcc.ir.Actor;
import net.sf.orcc.ir.IrFactory;
import net.sf.orcc.ir.Port;
import net.sf.orcc.moc.MoC;
import net.sf.orcc.network.Connection;
import net.sf.orcc.network.Instance;
import net.sf.orcc.network.Network;
import net.sf.orcc.network.Vertex;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.graph.DirectedMultigraph;

/**
 * This class detects statically schedulable regions of the graph. A region
 * cannot be a subset of another region and intersections of regions are
 * potentially non-empty. the network is assumed acyclic. The network classifier
 * is assumed to be computed first.
 * 
 * @author Ghislain Roquier
 * 
 */
public class StaticRegionDetector {

	private Set<Vertex> discovered = new HashSet<Vertex>();
	private Set<Vertex> finished = new HashSet<Vertex>();

	private Set<Set<Vertex>> staticRegionSet;

	private DirectedGraph<Vertex, Connection> graph;

	public StaticRegionDetector(Network network) {

		graph = network.getGraph();
	}

	private boolean checkCycles(DirectedGraph<Vertex, Connection> graph,
			List<Vertex> vertices) {

		boolean ret = true;

		int inIndex = 0;
		int outIndex = 0;

		DirectedGraph<Vertex, Connection> clusteredGraph = new DirectedMultigraph<Vertex, Connection>(
				Connection.class);

		for (Vertex vertex : graph.vertexSet()) {
			clusteredGraph.addVertex(vertex);
		}
		for (Connection connection : graph.edgeSet()) {
			clusteredGraph.addEdge(graph.getEdgeSource(connection),
					graph.getEdgeTarget(connection), connection);
		}

		Actor cluster = IrFactory.eINSTANCE.createActor();
		cluster.setName("cluster");

		Instance inst = new Instance(cluster.getName(), cluster.getName());
		inst.setContents(cluster);
		Vertex clusterVertex = new Vertex(inst);

		clusteredGraph.addVertex(clusterVertex);

		for (Connection edge : graph.edgeSet()) {
			Vertex srcVertex = graph.getEdgeSource(edge);
			Vertex tgtVertex = graph.getEdgeTarget(edge);

			if (!vertices.contains(srcVertex) && vertices.contains(tgtVertex)) {

				Port tgtPort = IrFactory.eINSTANCE.createPort(edge.getTarget());
				tgtPort.setName("input_" + outIndex++);
				cluster.getInputs().add(tgtPort);
				Connection incoming = new Connection(edge.getSource(), tgtPort,
						edge.getAttributes());
				clusteredGraph.addEdge(srcVertex, clusterVertex, incoming);
			} else if (vertices.contains(srcVertex)
					&& !vertices.contains(tgtVertex)) {

				Port srcPort = IrFactory.eINSTANCE.createPort(edge.getSource());
				srcPort.setName("output_" + inIndex++);
				cluster.getOutputs().add(srcPort);
				Connection outgoing = new Connection(srcPort, edge.getTarget(),
						edge.getAttributes());
				clusteredGraph.addEdge(clusterVertex, tgtVertex, outgoing);
			}
		}

		clusteredGraph.removeAllVertices(vertices);

		List<Set<Vertex>> sccs = new StrongConnectivityInspector<Vertex, Connection>(
				clusteredGraph).stronglyConnectedSets();

		for (Set<Vertex> scc : sccs) {
			if (scc.size() > 1) {
				if (scc.remove(clusterVertex)) {
					for (Vertex v : scc) {
						MoC clasz = v.getInstance().getMoC();
						if (!clasz.isCSDF()) {
							ret = false;
						}
					}
				}
			}
		}
		return ret;
	}

	/**
	 * DFS
	 * 
	 * @throws OrccException
	 * 
	 */
	private void staticRegionAnalysis(DirectedGraph<Vertex, Connection> graph,
			Vertex vertex, List<Vertex> vertices) {

		LinkedList<Vertex> stack = new LinkedList<Vertex>(Arrays.asList(vertex));

		while (!stack.isEmpty()) {
			Vertex v = stack.pop();
			MoC clasz = v.getInstance().getMoC();
			if (clasz.isCSDF()) {
				if (!discovered.contains(v)) {
					discovered.add(v);
					if (vertices != null) {
						vertices.add(v);
					}
					stack.push(v);
					finished.add(v);
					for (Connection edge : graph.outgoingEdgesOf(v)) {
						Vertex tgtVertex = graph.getEdgeTarget(edge);
						clasz = tgtVertex.getInstance().getMoC();
						if (!discovered.contains(tgtVertex) && clasz.isCSDF()) {
							if (vertices != null) {
								List<Vertex> l = new LinkedList<Vertex>(
										vertices);
								l.add(tgtVertex);
								if (checkCycles(graph, l)) {
									stack.push(tgtVertex);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Detects the static regions of the network. The detection is done by
	 * traversing the graph
	 * 
	 * 
	 */
	public Set<Set<Vertex>> staticRegionSets() {

		staticRegionSet = new HashSet<Set<Vertex>>();
		List<List<Vertex>> staticRegionList = new ArrayList<List<Vertex>>();

		// 1) orders vertices according to finishing time.
		discovered = new HashSet<Vertex>();
		finished = new HashSet<Vertex>();

		List<Vertex> vertices = new TopologicalSorter(graph).topologicalSort();
		for (Vertex vertex : vertices) {
			MoC clasz = vertex.getInstance().getMoC();
			if (!discovered.contains(vertex) && clasz.isCSDF()) {
				List<Vertex> set = new LinkedList<Vertex>();
				staticRegionList.add(set);
				staticRegionAnalysis(graph, vertex, set);
			}
		}

		for (List<Vertex> list1 : staticRegionList) {
			if (list1.size() > 1) {
				Set<Vertex> set1 = new HashSet<Vertex>(list1);
				staticRegionSet.add(set1);
			}
		}

		return staticRegionSet;
	}
}
