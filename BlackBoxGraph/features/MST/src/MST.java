import java.util.ArrayList;
import java.util.List;

import interfaces.IEdge;
import interfaces.IGraph;
import interfaces.IMST;
import interfaces.INode;
import interfaces.IWeightedEdge;

public class MST implements IMST {

	@Override
	public IGraph getMST(IGraph graph) {
		IGraph minGraph = graph;
		minGraph.resetGraph();
		
		List<INode> included = new ArrayList<INode>();
			
		List<IEdge> allEdges = graph.getEdgesAsList();
		
		while(minGraph.getNumVertices() != graph.getNumVertices())
		{
			int minWeight = 0;
			IWeightedEdge minEdge = null;
		
			for(IEdge edge : allEdges)
			{
				IWeightedEdge weighted = (IWeightedEdge) edge;
				if(included.isEmpty())
				{
					minGraph.addEdge(weighted);
					included.add(edge.getSource());
					included.add(edge.getTarget());
				}
				else if(included.contains(edge.getSource()) ^ included.contains(edge.getTarget()))
				{
					if(weighted.getWeight() <= minWeight)
					{
						minEdge = weighted;
					}
				}
			}
			
			minGraph.addEdge(minEdge);
			if(!included.contains(minEdge.getSource()))
			{
				included.add(minEdge.getSource());
			}
			if(!included.contains(minEdge.getTarget()))
			{
				included.add(minEdge.getTarget());
			}
		}
		
		return minGraph;
	}

}
