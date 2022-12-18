
import abstractClasses.AbstractGraphDecorator;
import interfaces.IEdge;
import interfaces.IWeightedEdge;
import interfaces.IGraph;

public class WeightedGraphDecorator extends AbstractGraphDecorator {
	public WeightedGraphDecorator(IGraph graph) {
		super(graph);
	}
	
	@Override
	public void addEdge(IEdge edge) {
		if (!(edge instanceof IWeightedEdge)) {
			this.graph.addEdge((IWeightedEdge)edge);
			return;
		}
		this.graph.addEdge(edge);
	}
}
