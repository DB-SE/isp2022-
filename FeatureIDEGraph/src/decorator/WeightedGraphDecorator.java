package decorator;

import java.util.ArrayList;
import java.util.List;

import edge.Edge;
import edge.WeightedEdge;
import graph.IGraph;
import graph.UndirectedGraph;
import node.Node;

public class WeightedGraphDecorator extends AbstractGraphDecorator {
	public WeightedGraphDecorator(IGraph graph) {
		super(graph);
	}
	
	@Override
	public void addEdge(Edge edge) {
		if (!(edge instanceof WeightedEdge)) {
			this.graph.addEdge(new WeightedEdge(edge.getSource(), edge.getTarget(), 1));
			return;
		}
		this.graph.addEdge(edge);
	}

	@Override
	public IGraph MST() {
		IGraph minGraph = new UndirectedGraph();
		
		List<Node> included = new ArrayList<Node>();
			
		List<Edge> allEdges = this.getEdgesAsList();
		
		while(minGraph.getNumVertices() != this.getNumVertices())
		{
			int minWeight = 0;
			WeightedEdge minEdge = null;
		
			for(Edge edge : allEdges)
			{
				WeightedEdge weighted = (WeightedEdge) edge;
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
