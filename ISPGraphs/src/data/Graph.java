package data;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int numVertices;
	private List<List<Edge>> edgesByVertices;
	
	private class Edge {
		private int weight;
		private int targetId;

		public Edge(int target) {
			this.targetId = target;
		}
		
		public int getWeight() {
			return this.weight;
		}
		
		public int getTarget() {
			return this.targetId;
		}
	}
	
	// number of vertices has to be known before adding edges for less spaghetti code
	// alternatively you could just handle a list of edges, but you would always need to search for the current vertex -> inefficient
	public Graph(int numVertices) {
		this.numVertices = numVertices;
		this.edgesByVertices = new ArrayList<List<Edge>>();
		for (int i = 0; i < numVertices; i++) {
			// initialize edge list for each vertex
			this.edgesByVertices.add(new ArrayList<Edge>());
		}
	}

	public void addEdge(int v, int w) {
		// the edge did not follow the rules
		if (v > numVertices || w > numVertices) {
			return;
		}

		// when visiting either vertex, we have to know that this edge exists
		Edge outgoing = new Edge(w);
		Edge incoming = new Edge(v);
		
		this.edgesByVertices.get(v).add(outgoing);
		this.edgesByVertices.get(w).add(incoming);
	}
	
	public void DFSTraverse(int index, boolean[] visited) {
		System.out.println("" + index + " -> ");
		visited[index] = true;
		List<Edge> edgeList = this.edgesByVertices.get(index);
		for (Edge edge : edgeList) {
			if (visited[edge.targetId]) {
				continue;
			}
			this.DFSTraverse(edge.targetId, visited);
		}
	}
	
	public void DFS(int startingIndex) {
		boolean[] visited = new boolean[this.numVertices];
		this.DFSTraverse(startingIndex, visited);
	}
}
