package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edge.Edge;

public class DirectedGraph<T> implements IGraph<T> {
	private int numVertices;
	private HashMap<String, List<Edge<T>>> edgesByVertices;
	
	public DirectedGraph() {
		this.edgesByVertices = new HashMap<String, List<Edge<T>>>();
		this.numVertices = 0;
	}
	
	@Override
	public void addEdge(Edge<T> edge) {
		System.out.println(this.edgesByVertices.get(edge.getSource().toString()));
		if (this.edgesByVertices.get(edge.getSource().toString()) == null) {
			this.edgesByVertices.put(edge.getSource().toString(), new ArrayList<Edge<T>>());
			this.numVertices++;
		}
		
		if (this.edgesByVertices.get(edge.getTarget().toString()) == null) {
			this.edgesByVertices.put(edge.getTarget().toString(), new ArrayList<Edge<T>>());
			this.numVertices++;
		}

		// when visiting either vertex, we have to know that this edge exists
		this.edgesByVertices.get(edge.getSource().toString()).add(edge);
	}
	
	public void DFSTraverse(T current, HashMap<String, Boolean> visited) {
		System.out.println("" + current.toString() + " -> ");
		visited.put(current.toString(), true);
		List<Edge<T>> edgeList = this.edgesByVertices.get(current.toString());
		for (Edge<T> edge : edgeList) {
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
	
	@Override
	public void DFS(T start) {
		HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
		
		for(String label : this.edgesByVertices.keySet()) {
			visited.put(label, false);
		}
		
		this.DFSTraverse(start, visited);
	}
	
	public List<Edge<T>> getEdgesAsList() {
		List<Edge<T>> allEdges = new ArrayList<Edge<T>>();
		
		for (String node : this.edgesByVertices.keySet())
		{
			for(Edge<T> edge : this.edgesByVertices.get(node))
			{
				allEdges.add(edge);
			}
		}
		
		return allEdges;
	}
	
	public DirectedGraph<T> MST() {
		DirectedGraph<T> minGraph = new DirectedGraph<T>();
		
		List<String> included = new ArrayList<String>();
			
		List<Edge<T>> allEdges = this.getEdgesAsList();
		
		while(minGraph.getNumVertices() != this.getNumVertices())
		{
			for(Edge<T> edge : allEdges)
			{
				if(included.isEmpty())
				{
					minGraph.addEdge(edge);
					included.add(edge.getSource().toString());
					included.add(edge.getTarget().toString());
				}
				else if(included.contains(edge.getSource().toString()) ^ included.contains(edge.getTarget().toString()))
				{
					minGraph.addEdge(edge);
					if(!included.contains(edge.getSource().toString()))
					{
						included.add(edge.getSource().toString());
					}
					if(!included.contains(edge.getTarget().toString()))
					{
						included.add(edge.getTarget().toString());
					}
				}
			}
		}
		
		return minGraph;
	}

	@Override
	public HashMap<String, List<Edge<T>>> getEdgesByVertices() {
		return this.edgesByVertices;
	}

	@Override
	public int getNumVertices() {
		return this.numVertices;
	}
}
