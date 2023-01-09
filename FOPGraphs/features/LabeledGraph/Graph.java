/**
 * TODO description
 */
public class Graph {
	
	public void addEdge(Edge edge) {

		Node source = edge.getSource();
		Node target = edge.getTarget();

		if(!(edge.getSource() instanceof LabeledNode)) {
			source = new LabeledNode(source.toString());
		}

		if(!(edge.getTarget() instanceof LabeledNode)) {
			target = new LabeledNode(target.toString());
		}
	
		Edge labeledEdge = new Edge(source, target);
	
		original(labeledEdge);
	}
}