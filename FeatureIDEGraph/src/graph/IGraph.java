package graph;

import java.util.HashMap;
import java.util.List;

import edge.Edge;
import node.Node;

public interface IGraph {
	public void addEdge(Edge edge);
	public void Traverse(Node start);
	public IGraph MST();
	public HashMap<Node, List<Edge>> getEdgesByVertices();
	public List<Edge> getEdgesAsList();
	public int getNumVertices();
	public void getAdjacencyMatrix();
}
