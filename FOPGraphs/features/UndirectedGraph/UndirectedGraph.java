import edge.Edge;

public class Graph {
	public Graph() {
		original();
	}
	
	public void addEdge(Edge edge) {
		original(edge);
		
		this.edgesByVertices.get(edge.getSource()).add(edge);
		this.edgesByVertices.get(edge.getTarget()).add(edge);
	}
}