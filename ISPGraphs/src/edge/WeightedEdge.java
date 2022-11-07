package edge;

import node;

public class WeightedEdge extends Edge {
	private int weight;
	
	public WeightedEdge(Node source, Node target, int weight) {
		super(source, target);
		this.weight = weight;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int w) {
		this.weight = w;
	}
}
