package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edge.Edge;
import node;

public class DirectedGraph implements IGraph {
	private int numVertices;
	private HashMap<Node, List<Edge>> edgesByVertices;
	
	public DirectedGraph() {
		this.edgesByVertices = new HashMap<Node, List<Edge>>();
		this.numVertices = 0;
	}
	
	@Override
	public void addEdge(Edge edge) {
		System.out.println(this.edgesByVertices.get(edge.getSource()));
		if (this.edgesByVertices.get(edge.getSource()) == null) {
			this.edgesByVertices.put(edge.getSource(), new ArrayList<Edge>());
			this.numVertices++;
		}
		
		if (this.edgesByVertices.get(edge.getTarget()) == null) {
			this.edgesByVertices.put(edge.getTarget(), new ArrayList<Edge>());
			this.numVertices++;
		}

		// when visiting either vertex, we have to know that this edge exists
		this.edgesByVertices.get(edge.getSource()).add(edge);
	}
	
	public void DFSTraverse(Node current, HashMap<Node, Boolean> visited) {
		System.out.println("" + current.toString() + " -> ");
		visited.put(current, true);
		List<Edge> edgeList = this.edgesByVertices.get(current);
		for (Edge edge : edgeList) {
			Node connected = edge.getConnected(current);
			if (connected == null) {
				continue;
			}
			
			if (visited.get(connected)) {
				continue;
			}
			this.DFSTraverse(connected, visited);
		}
	}
	
	@Override
	public void DFS(Node start) {
		HashMap<Node, Boolean> visited = new HashMap<Node, Boolean>();
		
		for(Node label : this.edgesByVertices.keySet()) {
			visited.put(label, false);
		}
		
		this.DFSTraverse(start, visited);
	}
	
	public List<Edge> getEdgesAsList() {
		List<Edge> allEdges = new ArrayList<Edge>();
		
		for (Node node : this.edgesByVertices.keySet())
		{
			for(Edge edge : this.edgesByVertices.get(node))
			{
				allEdges.add(edge);
			}
		}
		
		return allEdges;
	}
	
	public DirectedGraph MST() {
		DirectedGraph minGraph = new DirectedGraph();
		
		List<Node> included = new ArrayList<Node>();
			
		List<Edge> allEdges = this.getEdgesAsList();
		
		while(minGraph.getNumVertices() != this.getNumVertices())
		{
			for(Edge edge : allEdges)
			{
				if(included.isEmpty())
				{
					minGraph.addEdge(edge);
					included.add(edge.getSource());
					included.add(edge.getTarget());
				}
				else if(included.contains(edge.getSource()) ^ included.contains(edge.getTarget()))
				{
					minGraph.addEdge(edge);
					if(!included.contains(edge.getSource()))
					{
						included.add(edge.getSource());
					}
					if(!included.contains(edge.getTarget()))
					{
						included.add(edge.getTarget());
					}
				}
			}
		}
		
		return minGraph;
	}

	@Override
	public HashMap<Node, List<Edge>> getEdgesByVertices() {
		return this.edgesByVertices;
	}

	@Override
	public int getNumVertices() {
		return this.numVertices;
	}
}


