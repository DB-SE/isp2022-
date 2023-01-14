import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
	
	private int numVertices;
	private HashMap<Node, List<Edge>> edgesByVertices;
	
	public Graph() {
		this.edgesByVertices = new HashMap<Node, List<Edge>>();
		this.numVertices = 0;
	}

	public void addEdge(Edge edge) {
		if (this.edgesByVertices.get(edge.getSource()) == null) {
			this.edgesByVertices.put(edge.getSource(), new ArrayList<Edge>());
			this.numVertices++;
		}
				
		if (this.edgesByVertices.get(edge.getTarget()) == null) {
			this.edgesByVertices.put(edge.getTarget(), new ArrayList<Edge>());
			this.numVertices++;
		}
	}
	
	public HashMap<Node, List<Edge>> getEdgesByVertices() {
		return this.edgesByVertices;
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

	public int getNumVertices() {
		return this.numVertices;
	}
	
	public void Traverse(Node start) {
	}
	
	public IGraph MST() {
		return null;
	}
	
	public void getAdjacencyMatrix() {
	}
	
	public static void main(String[] args) {
		
		Node node = new Node();
		Node connected = new Node();
		Edge edge = new Edge(node, connected);
		
		Graph graph = new Graph();
		
		graph.addEdge(edge);
		
		graph.Traverse(graph.getEdgesAsList().get(0).getSource());
	}
}
