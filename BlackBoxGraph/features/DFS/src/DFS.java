import java.util.HashMap;
import java.util.List;

import interfaces.IDFS;
import interfaces.IEdge;
import interfaces.IGraph;
import interfaces.INode;

public class DFS implements IDFS {

	private void DFSTraverse(IGraph graph, INode current, HashMap<INode, Boolean> visited) {
		System.out.println("" + current.toString() + " -> ");
		visited.put(current, true);
		List<IEdge> IEdgeList = graph.getEdgesByVertices().get(current);
		for (IEdge IEdge : IEdgeList) {
			INode connected = IEdge.getConnected(current);
			if (connected == null) {
				continue;
			}
			
			if (visited.get(connected)) {
				continue;
			}
			this.DFSTraverse(graph, connected, visited);
		}
	}
	
	@Override
	public void Traverse(IGraph graph, INode start) {
		HashMap<INode, Boolean> visited = new HashMap<INode, Boolean>();
		
		for(INode label : graph.getEdgesByVertices().keySet()) {
			visited.put(label, false);
		}
		
		this.DFSTraverse(graph, start, visited);
	}
}
