/**
 * TODO description
 */
public class Graph {
	
	@Override
	public void addEdge(Edge edge) {
		original(edge);
		
		this.edgesByVertices.get(edge.getSource()).add(edge);
	}
}