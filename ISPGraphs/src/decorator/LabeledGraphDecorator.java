package decorator;

import edge.Edge;
import edge.WeightedEdge;
import graph.IGraph;

public class LabeledGraphDecorator extends AbstractGraphDecorator {

	public LabeledGraphDecorator(IGraph graph) {
		super(graph);
	}


	@Override
	public void addEdge(Edge edge) {

		Node source = edge.getSource();
		Node target = edge.getTarget();

		if(!(edge.getSource() instanceof LabeledNode)) {
			source = (LabeledNode)edge.getSource();
			source.setLabel(Node.toString());
		}

		if(!(edge.getTarget() instanceof LabeledNode)) {
			target = (LabeledNode)edge.getTarget();
			target.setLabel(Node.toString());
		}

		Edge labeledEdge = new Edge(source, target);

		this.graph.addEdge(labeledEdge);
	}
}
