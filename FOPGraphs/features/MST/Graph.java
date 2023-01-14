import java.util.ArrayList;
import java.util.List;

/**
 * TODO description
 */
public class Graph {
	
	public Graph MST() {
			
		Graph minGraph = new Graph();
		
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
		
		original();
			
		return minGraph;
	}
}