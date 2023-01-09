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
	
		if(!(edge.getSource() instanceof ColoredNode)) {
			source = (ColoredNode)edge.getSource();
			((ColoredNode)source).setColor("white");
		}
	
		if(!(edge.getTarget() instanceof ColoredNode)) {
			target = (LabeledNode)edge.getTarget();
			((ColoredNode)target).setColor("white");
		}
	
		Edge coloredEdge = new Edge(source, target);
	
		original(coloredEdge);
	}
}