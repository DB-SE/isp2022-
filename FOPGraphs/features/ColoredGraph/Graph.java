/**
 * TODO description
 */
public class Graph {

	public void addEdge(Edge edge) {

		Node source = edge.getSource();
		Node target = edge.getTarget();
	
		if(!(edge.getSource() instanceof ColoredNode)) {
			source = new ColoredNode("white");
		}
	
		if(!(edge.getTarget() instanceof ColoredNode)) {
			target = new ColoredNode("white");
		}
	
		Edge coloredEdge = new Edge(source, target);
	
		original(coloredEdge);
		System.out.println(this.edgesByVertices.get(coloredEdge.getSource()));
	}
}