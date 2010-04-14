/*
 * Copyright (c) 2010, Ecole Polytechnique F�d�rale de Lausanne 
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
 *   * Neither the name of the Ecole Polytechnique F�d�rale de Lausanne nor the 
 *     names of its contributors may be used to endorse or promote products 
 *     derived from this software without specific prior written permission.
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

package net.sf.orcc.tools.staticanalyzer;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.orcc.network.Connection;
import net.sf.orcc.network.Vertex;

import org.jgrapht.DirectedGraph;

/**
 * Depth First Search algorithm
 * 
 * @author Ghislain Roquier
 * 
 */

public class DFS {

	private static class TimeStamp {

		static int currentTime = 0;
		private int finish;
		private int start;

		public TimeStamp(int discovered, int finished) {
			this.start = discovered;
			this.finish = finished;
		}

		public int getFinished() {
			return finish;
		}

		@SuppressWarnings("unused")
		public int getStarted() {
			return start;
		}

		public void setFinished(int finished) {
			this.finish = finished;
		}
	}

	private class TimeStampComparator implements Comparator<Vertex> {

		private Map<Vertex, TimeStamp> map;

		public TimeStampComparator(Map<Vertex, TimeStamp> map) {
			this.map = map;
		}

		public int compare(Vertex v1, Vertex v2) {
			return map.get(v2).getFinished() - map.get(v1).getFinished();
		}

	}

	private Set<Vertex> defined = new HashSet<Vertex>();

	private DirectedGraph<Vertex, Connection> graph;

	private Map<Vertex, TimeStamp> timeStamps = new HashMap<Vertex, TimeStamp>();

	public DFS(DirectedGraph<Vertex, Connection> graph) {
		this.graph = graph;
	}

	private void dfsVisit(Vertex vertex) {
		defined.add(vertex);
		TimeStamp.currentTime++;
		timeStamps.put(vertex, new TimeStamp(TimeStamp.currentTime, 0));

		for (Connection connection : graph.outgoingEdgesOf(vertex)) {
			Vertex tgtVertex = graph.getEdgeTarget(connection);
			if (!defined.contains(tgtVertex)) {
				dfsVisit(tgtVertex);
			}
		}
		TimeStamp.currentTime++;
		timeStamps.get(vertex).setFinished(TimeStamp.currentTime);
	}

	private Map<Vertex, TimeStamp> getTimestamps() {

		for (Vertex vertex : graph.vertexSet()) {
			if (!defined.contains(vertex)) {
				dfsVisit(vertex);
			}
		}
		return timeStamps;
	}

	public List<Vertex> orderedByFinishingTime() {
		List<Vertex> sorted = new LinkedList<Vertex>(getTimestamps().keySet());
		Collections.sort(sorted, new TimeStampComparator(timeStamps));
		return sorted;
	}

}
