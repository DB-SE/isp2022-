package abstractClasses;

import java.util.HashMap;
import java.util.List;

import interfaces.IEdge;
import interfaces.IGraph;
import interfaces.INode;

public abstract class AbstractGraphDecorator implements IGraph {
	
	protected IGraph graph;
	
	public AbstractGraphDecorator(IGraph graph) {
		this.graph = graph;
	}

	@Override
	public void addEdge(IEdge edge) {
		this.graph.addEdge(edge);
	}
	

	@Override
	public HashMap<INode, List<IEdge>> getEdgesByVertices() {
		return this.graph.getEdgesByVertices();
	}

	@Override
	public List<IEdge> getEdgesAsList() {
		return this.graph.getEdgesAsList();
	}

	@Override
	public int getNumVertices() {
		return this.graph.getNumVertices();
	}
	
	@Override
	public void resetGraph() {
		this.graph.resetGraph();
	}
}

