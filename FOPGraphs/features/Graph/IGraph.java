import java.util.HashMap;
import java.util.List;

public interface IGraph {
	public void addEdge(Edge edge);
	public HashMap<Node, List<Edge>> getEdgesByVertices();
	public List<Edge> getEdgesAsList();
	public int getNumVertices();
	public void Traverse(Node start);
	public IGraph MST();
	public void getAdjacencyMatrix();
}
