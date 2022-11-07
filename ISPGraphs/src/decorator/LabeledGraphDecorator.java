package decorator;

import edge.Edge;
import graph.IGraph;
import node.LabeledNode;
import node.Node;

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
			((LabeledNode)source).setLabel(source.toString());
		}

		if(!(edge.getTarget() instanceof LabeledNode)) {
			target = (LabeledNode)edge.getTarget();
			((LabeledNode)target).setLabel(target.toString());
		}

		Edge labeledEdge = new Edge(source, target);

		this.graph.addEdge(labeledEdge);
	}
}
