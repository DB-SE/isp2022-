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
		
		public void setWeight(int w) {
			this.weight = w;
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
		edge.weight = 1;

		// when visiting either vertex, we have to know that this edge exists
		this.edgesByVertices.get(v.toString()).add(edge);
		this.edgesByVertices.get(w.toString()).add(edge);
	}
	
	public void addEdge(T v, T w, int weight) {
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
		edge.setWeight(weight);

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
	
	public List<Edge> getAllEdges() {
		List<Edge> allEdges = new ArrayList<Edge>();
		
		for (String node : this.edgesByVertices.keySet())
		{
			for(Edge edge : this.edgesByVertices.get(node))
			{
				allEdges.add(edge);
			}
		}
		
		return allEdges;
	}
	
	public Graph<T> MST() {
		Graph<T> minGraph = new Graph<T>();
		
		List<String> included = new ArrayList<String>();
			
		List<Edge> allEdges = this.getAllEdges();
		
		while(minGraph.numVertices != this.numVertices)
		{
			int minWeight = 0;
			Edge minEdge = null;
		
			for(Edge edge : allEdges)
			{
				if(included.isEmpty())
				{
					minGraph.addEdge(edge.source, edge.target, edge.weight);
					included.add(edge.source.toString());
					included.add(edge.target.toString());
				}
				else if(included.contains(edge.source.toString()) ^ included.contains(edge.target.toString()))
				{
					if(edge.weight <= minWeight)
					{
						minEdge = edge;
					}
				}
			}
			
			minGraph.addEdge(minEdge.source, minEdge.target, minEdge.weight);
			if(!included.contains(minEdge.source.toString()))
			{
				included.add(minEdge.source.toString());
			}
			if(!included.contains(minEdge.target.toString()))
			{
				included.add(minEdge.target.toString());
			}
		}
		
		return minGraph;
	}
}


