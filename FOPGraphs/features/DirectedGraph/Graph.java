/**
 * TODO description
 */
public class Graph {
	
	public void addEdge(Edge edge) {
		orginal(edge);
		
		this.edgesByVertices.get(edge.getSource()).add(edge);
	}
}