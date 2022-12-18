package interfaces;

import java.util.HashMap;
import java.util.List;


public interface IGraph {
	public void addEdge(IEdge edge);
	public HashMap<INode, List<IEdge>> getEdgesByVertices();
	public List<IEdge> getEdgesAsList();
	public int getNumVertices();
	public void resetGraph();
}