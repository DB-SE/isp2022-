package decorator;

import edge.Edge;
import edge.WeightedEdge;
import graph.IGraph;

public class LabeledGraphDecorator<T> extends AbstractGraphDecorator<T> {

	public LabeledGraphDecorator(IGraph<T> graph) {
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
}
