import java.util.HashMap;

import node.Node;

public class Graph {
	public Graph() {
		original();
	}
	
	public void BFSTraverse(Queue<Node> nodeQueue, HashMap<Node, Boolean> visited) {
		Node front = nodeQueue.remove();
		
		if (front == null) {
			return;
		}
			
		List<Edge> edgeList = this.edgesByVertices.get(front);
		for (Edge edge: edgeList) {
			Node connected = edge.getConnected(front);
			if (connected == null) {
				continue;
			}
				
			if (visited.get(connected) == false) {
				visited.put(connected, true);
				nodeQueue.add(connected);
			}
		}
			
		this.BFSTraverse(nodeQueue, visited);
	}
	
	public void Traverse(Node start) {
		HashMap<Node, Boolean> visited = new HashMap<Node, Boolean>();
		for(Node label : this.edgesByVertices.keySet()) {
			visited.put(label, false);
		}
		
		this.BFSTraverse(start, null);
	}
}