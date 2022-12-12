

import abstractClasses.AbstractGraphDecorator;
import edge.Edge;
import interfaces.IGraph;
import node.ColoredNode;
import node.LabeledNode;
import node.Node;

public class ColoredGraphDecorator extends AbstractGraphDecorator {

	public ColoredGraphDecorator(IGraph graph) {
		super(graph);
	}


	@Override
	public void addEdge(Edge edge) {

		Node source = edge.getSource();
		Node target = edge.getTarget();

		if(!(edge.getSource() instanceof ColoredNode)) {
			source = (ColoredNode)edge.getSource();
			((ColoredNode)source).setColor("white");
		}

		if(!(edge.getTarget() instanceof ColoredNode)) {
			target = (LabeledNode)edge.getTarget();
			((ColoredNode)target).setColor("white");
		}

		Edge coloredEdge = new Edge(source, target);

		this.graph.addEdge(coloredEdge);
	}
}