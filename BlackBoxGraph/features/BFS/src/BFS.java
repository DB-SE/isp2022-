import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import interfaces.IBFS;
import interfaces.IEdge;
import interfaces.IGraph;
import interfaces.INode;

public class BFS implements IBFS {
	
	private void BFSTraverse(IGraph graph, Queue<INode> NodeQueue, HashMap<INode, Boolean> visited) {
		INode front = NodeQueue.remove();
		
		if (front == null) {
			return;
		}
		
		List<IEdge> IEdgeList = graph.getEdgesByVertices().get(front);
		for (IEdge IEdge: IEdgeList) {
			INode connected = IEdge.getConnected(front);
			if (connected == null) {
				continue;
			}
			
			if (visited.get(connected) == false) {
				visited.put(connected, true);
				NodeQueue.add(connected);
			}
		}
		
		this.BFSTraverse(graph, NodeQueue, visited);
	}
	
	public void Traverse(IGraph graph, INode start) {
		HashMap<INode, Boolean> visited = new HashMap<INode, Boolean>();		
		for(INode label : graph.getEdgesByVertices().keySet()) {
			visited.put(label, false);
		}

		Queue<INode> NodeQueue = new ConcurrentLinkedQueue<INode>();
		NodeQueue.add(start);
				
		this.BFSTraverse(graph, NodeQueue, visited);
	}
}
