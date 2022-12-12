

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import node.Node;
import edge.Edge;
import edge.WeightedEdge;
import interfaces.IGraph;
import interfaces.IAlgorithms;

public class UndirectedGraph implements IGraph, IAlgorithms {
	private int numVertices;
	private HashMap<Node, List<Edge>> EdgesByVertices;
	
	public UndirectedGraph() {
		this.EdgesByVertices = new HashMap<Node, List<Edge>>();
		this.numVertices = 0;
	}
	
	@Override
	public void addEdge(Edge Edge) {
		System.out.println(this.EdgesByVertices.get(Edge.getSource()));
		if (this.EdgesByVertices.get(Edge.getSource()) == null) {
			this.EdgesByVertices.put(Edge.getSource(), new ArrayList<Edge>());
			this.numVertices++;
		}
		
		if (this.EdgesByVertices.get(Edge.getTarget()) == null) {
			this.EdgesByVertices.put(Edge.getTarget(), new ArrayList<Edge>());
			this.numVertices++;
		}

		// when visiting either vertex, we have to know that this Edge exists
		this.EdgesByVertices.get(Edge.getSource()).add(Edge);
		this.EdgesByVertices.get(Edge.getTarget()).add(Edge);
	}
	
	// #if DFS
	public void DFSTraverse(Node current, HashMap<Node, Boolean> visited) {
		System.out.println("" + current.toString() + " -> ");
		visited.put(current, true);
		List<Edge> EdgeList = this.EdgesByVertices.get(current);
		for (Edge Edge : EdgeList) {
			Node connected = Edge.getConnected(current);
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
	public void TraverseDFS(Node start) {
		HashMap<Node, Boolean> visited = new HashMap<Node, Boolean>();
		
		for(Node label : this.EdgesByVertices.keySet()) {
			visited.put(label, false);
		}
		
		this.DFSTraverse(start, visited);
	}
	// #endif
	
	// #if BFS
	public void BFSTraverse(Queue<Node> NodeQueue, HashMap<Node, Boolean> visited) {
		Node front = NodeQueue.remove();
		
		if (front == null) {
			return;
		}
		
		List<Edge> EdgeList = this.EdgesByVertices.get(front);
		for (Edge Edge: EdgeList) {
			Node connected = Edge.getConnected(front);
			if (connected == null) {
				continue;
			}
			
			if (visited.get(connected) == false) {
				visited.put(connected, true);
				NodeQueue.add(connected);
			}
		}
		
		this.BFSTraverse(NodeQueue, visited);
	}
	
	public void TraverseBFS(Node start) {
		HashMap<Node, Boolean> visited = new HashMap<Node, Boolean>();		
		for(Node label : this.EdgesByVertices.keySet()) {
			visited.put(label, false);
		}

		Queue<Node> NodeQueue = new ConcurrentLinkedQueue<Node>();
		NodeQueue.add(start);
				
		this.BFSTraverse(NodeQueue, visited);
	}
	// #endif
	
	public List<Edge> getEdgesAsList() {
		List<Edge> allEdges = new ArrayList<Edge>();
		
		for (Node Node : this.EdgesByVertices.keySet())
		{
			for(Edge Edge : this.EdgesByVertices.get(Node))
			{
				allEdges.add(Edge);
			}
		}
		
		return allEdges;
	}
	
	public UndirectedGraph MST() {
		UndirectedGraph minGraph = new UndirectedGraph();
		
		List<Node> included = new ArrayList<Node>();
			
		List<Edge> allEdges = this.getEdgesAsList();
		
		while(minGraph.getNumVertices() != this.getNumVertices())
		{
			for(Edge Edge : allEdges)
			{
				if(included.isEmpty())
				{
					minGraph.addEdge(Edge);
					included.add(Edge.getSource());
					included.add(Edge.getTarget());
				}
				else if(included.contains(Edge.getSource()) ^ included.contains(Edge.getTarget()))
				{
					minGraph.addEdge(Edge);
					if(!included.contains(Edge.getSource()))
					{
						included.add(Edge.getSource());
					}
					if(!included.contains(Edge.getTarget()))
					{
						included.add(Edge.getTarget());
					}
				}
			}
		}
		
		return minGraph;
	}
	
	@Override
	public void getAdjacencyMatrix() {
		int[][] matrix = new int[this.numVertices][this.numVertices];
		
		int i = 0;
		for (Node Node : this.EdgesByVertices.keySet()) {
			for (Edge Edge : this.EdgesByVertices.get(Node)) {
				int j = 0;
				for (Node targetNode : this.EdgesByVertices.keySet()) {
					if (targetNode == Edge.getTarget()) {
						if (Edge instanceof WeightedEdge) {
							matrix[i][j] = ((WeightedEdge)Edge).getWeight();
						} else {
							matrix[i][j] = 1;
						}
					}
				}
				j++;
			}
			i++;
		}
	}

	@Override
	public HashMap<Node, List<Edge>> getEdgesByVertices() {
		return this.EdgesByVertices;
	}
	
	@Override
	public int getNumVertices() {
		return this.numVertices;
	}
}

