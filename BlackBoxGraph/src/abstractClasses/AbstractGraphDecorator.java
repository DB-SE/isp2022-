package abstractClasses;

import java.util.HashMap;
import java.util.List;

import edge.Edge;
import interfaces.IGraph;
import interfaces.IAlgorithms;
import node.Node;

public abstract class AbstractGraphDecorator implements IGraph, IAlgorithms {
	
	protected IGraph graph;
	protected IAlgorithms algo;
	
	public AbstractGraphDecorator(IGraph graph) {
		this.graph = graph;
	}

	@Override
	public void addEdge(Edge edge) {
		this.graph.addEdge(edge);
	}

	@Override
	public void TraverseDFS(Node start) {
		this.algo.TraverseDFS(start);
	}
	
	@Override
	public void TraverseBFS(Node start) {
		this.algo.TraverseBFS(start);
	}

	@Override
	public IGraph MST() {
		return this.graph.MST();
	}
	

	@Override
	public HashMap<Node, List<Edge>> getEdgesByVertices() {
		// TODO Auto-generated method stub
		return this.graph.getEdgesByVertices();
	}

	@Override
	public List<Edge> getEdgesAsList() {
		// TODO Auto-generated method stub
		return this.graph.getEdgesAsList();
	}
	
	@Override
	public void getAdjacencyMatrix() {
		this.graph.getAdjacencyMatrix();
	}

	@Override
	public int getNumVertices() {
		// TODO Auto-generated method stub
		return this.graph.getNumVertices();
	}
}

