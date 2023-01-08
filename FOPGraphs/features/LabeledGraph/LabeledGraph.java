/**
 * TODO description
 */
public class Graph {
	public Graph() {
		original(graph);
	}
	
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
	
		original(labeledEdge);
	}
}