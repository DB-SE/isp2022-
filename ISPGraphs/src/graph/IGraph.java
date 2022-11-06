package graph;

import java.util.HashMap;
import java.util.List;

import edge.Edge;

public interface IGraph<T> {
	public void addEdge(Edge<T> edge);
	public void DFS(T start);
	public IGraph<T> MST();
	public HashMap<String, List<Edge<T>>> getEdgesByVertices();
	public List<Edge<T>> getEdgesAsList();
	public int getNumVertices();
}
