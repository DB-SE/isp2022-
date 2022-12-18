

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import interfaces.INode;
import interfaces.IGraph;
import interfaces.IEdge;

public class UndirectedGraph implements IGraph {
	private int numVertices;
	private HashMap<INode, List<IEdge>> EdgesByVertices;
	
	public UndirectedGraph() {
		this.EdgesByVertices = new HashMap<INode, List<IEdge>>();
		this.numVertices = 0;
	}
	
	@Override
	public void addEdge(IEdge IEdge) {
		System.out.println(this.EdgesByVertices.get(IEdge.getSource()));
		if (this.EdgesByVertices.get(IEdge.getSource()) == null) {
			this.EdgesByVertices.put(IEdge.getSource(), new ArrayList<IEdge>());
			this.numVertices++;
		}
		
		if (this.EdgesByVertices.get(IEdge.getTarget()) == null) {
			this.EdgesByVertices.put(IEdge.getTarget(), new ArrayList<IEdge>());
			this.numVertices++;
		}

		// when visiting either vertex, we have to know that this IEdge exists
		this.EdgesByVertices.get(IEdge.getSource()).add(IEdge);
		this.EdgesByVertices.get(IEdge.getTarget()).add(IEdge);
	}
	
	public List<IEdge> getEdgesAsList() {
		List<IEdge> allIEdges = new ArrayList<IEdge>();
		
		for (INode Node : this.EdgesByVertices.keySet())
		{
			for(IEdge IEdge : this.EdgesByVertices.get(Node))
			{
				allIEdges.add(IEdge);
			}
		}
		
		return allIEdges;
	}
	

	@Override
	public HashMap<INode, List<IEdge>> getEdgesByVertices() {
		return this.EdgesByVertices;
	}
	
	@Override
	public int getNumVertices() {
		return this.numVertices;
	}

	@Override
	public void resetGraph() {
		this.EdgesByVertices = new HashMap<INode, List<IEdge>>();
		this.numVertices = 0;
	}
}

