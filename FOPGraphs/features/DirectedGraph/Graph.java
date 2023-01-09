/**
 * TODO description
 */
public class Graph {
	
	@Override
	public void addEdge(Edge edge) {
		original(edge);
		
		System.out.println(this.edgesByVertices.get(edge.getSource()));
		this.edgesByVertices.get(edge.getSource()).add(edge);
	}
}