

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import interfaces.IEdge;
import interfaces.INode;
import interfaces.IGraph;


public class DirectedGraph implements IGraph {
	private int numVertices;
	private HashMap<INode, List<IEdge>> edgesByVertices;
	
	public DirectedGraph() {
		this.edgesByVertices = new HashMap<INode, List<IEdge>>();
		this.numVertices = 0;
	}
	
	@Override
	public void addEdge(IEdge edge) {
		System.out.println(this.edgesByVertices.get(edge.getSource()));
		if (this.edgesByVertices.get(edge.getSource()) == null) {
			this.edgesByVertices.put(edge.getSource(), new ArrayList<IEdge>());
			this.numVertices++;
		}
		
		if (this.edgesByVertices.get(edge.getTarget()) == null) {
			this.edgesByVertices.put(edge.getTarget(), new ArrayList<IEdge>());
			this.numVertices++;
		}

		// when visiting either vertex, we have to know that this edge exists
		this.edgesByVertices.get(edge.getSource()).add(edge);
	}
	
	public List<IEdge> getEdgesAsList() {
		List<IEdge> allEdges = new ArrayList<IEdge>();
		
		for (INode node : this.edgesByVertices.keySet())
		{
			for(IEdge edge : this.edgesByVertices.get(node))
			{
				allEdges.add(edge);
			}
		}
		
		return allEdges;
	}

	@Override
	public HashMap<INode, List<IEdge>> getEdgesByVertices() {
		return this.edgesByVertices;
	}

	@Override
	public int getNumVertices() {
		return this.numVertices;
	}
	
	@Override
	public void resetGraph() {
		this.edgesByVertices = new HashMap<INode, List<IEdge>>();
		this.numVertices = 0;
	}
}

