package decorator;

import java.util.ArrayList;
import java.util.List;

import edge.Edge;
import edge.WeightedEdge;
import graph.IGraph;
import graph.UndirectedGraph;

public class WeightedGraphDecorator<T> extends AbstractGraphDecorator<T> {
	public WeightedGraphDecorator(IGraph<T> graph) {
		super(graph);
	}
	
	@Override
	public void addEdge(Edge<T> edge) {
		if (edge instanceof WeightedEdge<T>) {
			this.graph.addEdge(new WeightedEdge<T>(edge.getSource(), edge.getTarget(), 1));
			return;
		}
		this.graph.addEdge(edge);
	}

	@Override
	public IGraph<T> MST() {
		IGraph<T> minGraph = new UndirectedGraph<T>();
		
		List<String> included = new ArrayList<String>();
			
		List<Edge<T>> allEdges = this.getEdgesAsList();
		
		while(minGraph.getNumVertices() != this.getNumVertices())
		{
			int minWeight = 0;
			WeightedEdge<T> minEdge = null;
		
			for(Edge<T> edge : allEdges)
			{
				WeightedEdge<T> weighted = (WeightedEdge<T>) edge;
				if(included.isEmpty())
				{
					minGraph.addEdge(weighted);
					included.add(edge.getSource().toString());
					included.add(edge.getTarget().toString());
				}
				else if(included.contains(edge.getSource().toString()) ^ included.contains(edge.getTarget().toString()))
				{
					if(weighted.getWeight() <= minWeight)
					{
						minEdge = weighted;
					}
				}
			}
			
			minGraph.addEdge(minEdge);
			if(!included.contains(minEdge.getSource().toString()))
			{
				included.add(minEdge.getSource().toString());
			}
			if(!included.contains(minEdge.getTarget().toString()))
			{
				included.add(minEdge.getTarget().toString());
			}
		}
		
		return minGraph;
	}
}
