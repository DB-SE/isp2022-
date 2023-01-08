import java.util.ArrayList;
import java.util.List;

import edge.Edge;
import graph.IGraph;
import node.Node;

/**
 * TODO description
 */
public class Graph {
	public Graph() {
		original();
	}
	
	// minGraph needs to be passed by the feature, its ugly i know
	public IGraph MST() {
			
		IGraph graph = new Graph();
		
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
}