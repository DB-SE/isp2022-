

import interfaces.IEdge;
import interfaces.IGraph;

import abstractClasses.AbstractGraphDecorator;
import interfaces.ILabeledNode;
import interfaces.INode;

public class LabeledGraphDecorator extends AbstractGraphDecorator {

	public LabeledGraphDecorator(IGraph graph) {
		super(graph);
	}


	@Override
	public void addEdge(IEdge edge) {

		INode source = edge.getSource();
		INode target = edge.getTarget();

		if(!(edge.getSource() instanceof ILabeledNode)) {
			source = (ILabeledNode)edge.getSource();
			((ILabeledNode)source).setLabel(source.toString());
		}

		if(!(edge.getTarget() instanceof ILabeledNode)) {
			target = (ILabeledNode)edge.getTarget();
			((ILabeledNode)target).setLabel(target.toString());
		}

		edge.setSource(source);
		edge.setTarget(target);

		this.graph.addEdge(edge);
	}
}
