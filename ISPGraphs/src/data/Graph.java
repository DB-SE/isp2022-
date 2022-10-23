package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph<T> {
	private int numVertices;
	private HashMap<String, List<Edge>> edgesByVertices;
	
	private class Edge {
		private int weight;
		private T target;
		private T source;

		public Edge(T source, T target) {
			this.source = source;
			this.target = target;
		}
		
		public int getWeight() {
			return this.weight;
		}
		
		public T getConnected(T node) {
			if (node.equals(this.target)) {
				return this.source;
			}
			
			if (node.equals(this.source)) {
				return this.target;
			}
			
			return null;
		}
	}
	
	public Graph() {
		this.edgesByVertices = new HashMap<String, List<Edge>>();
		this.numVertices = 0;
	}

	// assuming undirected graphs
	// 
	public void addEdge(T v, T w) {
		System.out.println(this.edgesByVertices.get(v.toString()));
		if (this.edgesByVertices.get(v.toString()) == null) {
			this.edgesByVertices.put(v.toString(), new ArrayList<Edge>());
			this.numVertices++;
		}
		
		if (this.edgesByVertices.get(w.toString()) == null) {
			this.edgesByVertices.put(w.toString(), new ArrayList<Edge>());
			this.numVertices++;
		}

		Edge edge = new Edge(v, w);

		// when visiting either vertex, we have to know that this edge exists
		this.edgesByVertices.get(v.toString()).add(edge);
		this.edgesByVertices.get(w.toString()).add(edge);
	}
	
	public void DFSTraverse(T current, HashMap<String, Boolean> visited) {
		System.out.println("" + current.toString() + " -> ");
		visited.put(current.toString(), true);
		List<Edge> edgeList = this.edgesByVertices.get(current.toString());
		for (Edge edge : edgeList) {
			T connected = edge.getConnected(current);
			if (connected == null) {
				continue;
			}
			
			if (visited.get(connected.toString())) {
				continue;
			}
			this.DFSTraverse(connected, visited);
		}
	}
	
	public void DFS(T start) {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		
		for(String label : this.edgesByVertices.keySet()) {
			visited.put(label, false);
		}
		
		this.DFSTraverse(start, visited);
	}
}


