package node;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private List<Node> connectedNodes;

	public Node() {
		this.connectedNodes = new ArrayList<Node>();
	}

	public List<Node> getConnectedNodes() {
		return this.connectedNodes;
	}
}