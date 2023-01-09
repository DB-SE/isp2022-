import java.util.HashMap;

/**
 * TODO description
 */
public class Graph {
	
	public void DFSTraverse(Node current, HashMap<Node, Boolean> visited) {
		System.out.println("" + current.toString() + " -> ");
		visited.put(current, true);
		List<Edge> edgeList = this.edgesByVertices.get(current);
		for (Edge edge : edgeList) {
			Node connected = edge.getConnected(current);
			if (connected == null) {
				continue;
			}
				
			if (visited.get(connected)) {
				continue;
			}
			this.DFSTraverse(connected, visited);
		}
	}
	
	public void Traverse(Node start) {
		original(start);
		HashMap<Node, Boolean> visited = new HashMap<Node, Boolean>();
		for(Node label : this.edgesByVertices.keySet()) {
			visited.put(label, false);
		}
		
		this.DFSTraverse(start, visited);
	
	}
}