import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Graph {
	
	public void BFSTraverse(Queue<Node> nodeQueue, HashMap<Node, Boolean> visited) {
		Node front = nodeQueue.remove();
		
		if (front == null) {
			return;
		}
		
		System.out.println(this.edgesByVertices.get(front));
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
		
		Queue<Node> nodeQueue = new ConcurrentLinkedQueue<Node>();
		nodeQueue.add(start);
		
		this.BFSTraverse(nodeQueue, visited);
	}
}