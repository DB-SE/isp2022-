package decorator;

import java.util.HashMap;
import java.util.List;

import edge.Edge;
import graph.IGraph;

public abstract class AbstractGraphDecorator<T> implements IGraph<T> {
	
	protected IGraph<T> graph;
	
	public AbstractGraphDecorator(IGraph<T> graph) {
		this.graph = graph;
	}

	@Override
	public void addEdge(Edge<T> edge) {
		this.graph.addEdge(edge);
	}

	@Override
	public void DFS(T start) {
		this.graph.DFS(start);
	}

	@Override
	public IGraph<T> MST() {
		return this.graph.MST();
	}
	

	@Override
	public HashMap<String, List<Edge<T>>> getEdgesByVertices() {
		// TODO Auto-generated method stub
		return this.graph.getEdgesByVertices();
	}

	@Override
	public List<Edge<T>> getEdgesAsList() {
		// TODO Auto-generated method stub
		return this.graph.getEdgesAsList();
	}

	@Override
	public int getNumVertices() {
		// TODO Auto-generated method stub
		return this.graph.getNumVertices();
	}
}
