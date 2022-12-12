package edge;

import node.Node;

public class Edge {
	private Node target;
	private Node source;

	public Edge(Node source, Node target) {
		this.source = source;
		this.target = target;
	}
	
	public Node getConnected(Node node) {
		if (node.equals(this.target)) {
			return this.source;
		}
		
		if (node.equals(this.source)) {
			return this.target;
		}
		
		return null;
	}
	
	public Node getSource() {
		return this.source;
	}
	
	public Node getTarget() {
		return this.target;
	}
}
