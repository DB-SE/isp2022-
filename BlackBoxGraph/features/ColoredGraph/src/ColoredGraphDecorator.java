

import abstractClasses.AbstractGraphDecorator;
import interfaces.IColoredNode;
import interfaces.IEdge;
import interfaces.IGraph;
import interfaces.ILabeledNode;
import interfaces.INode;

public class ColoredGraphDecorator extends AbstractGraphDecorator {

	public ColoredGraphDecorator(IGraph graph) {
		super(graph);
	}


	@Override
	public void addEdge(IEdge edge) {

		INode source = edge.getSource();
		INode target = edge.getTarget();

		if(!(edge.getSource() instanceof IColoredNode)) {
			source = (IColoredNode)edge.getSource();
			((IColoredNode)source).setColor("white");
		}

		if(!(edge.getTarget() instanceof IColoredNode)) {
			target = (ILabeledNode)edge.getTarget();
			((IColoredNode)target).setColor("white");
		}
		
		edge.setSource(source);
		edge.setTarget(target);

		this.graph.addEdge(edge);
	}
}