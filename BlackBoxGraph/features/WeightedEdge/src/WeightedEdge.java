

import interfaces.IWeightedEdge;
import interfaces.INode;

public class WeightedEdge implements IWeightedEdge {
	private int weight;
	private INode target;
	private INode source;
	
	public WeightedEdge(INode source, INode target, int weight) {
		this.source = source;
		this.target = target;
		this.weight = weight;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int w) {
		this.weight = w;
	}
	
	public INode getConnected(INode node) {
		if (node.equals(this.target)) {
			return this.source;
		}
		
		if (node.equals(this.source)) {
			return this.target;
		}
		
		return null;
	}
	
	public INode getSource() {
		return this.source;
	}
	
	public INode getTarget() {
		return this.target;
	}
	
	public void setSource(INode source) {
		this.source = source;
	}
	
	public void setTarget(INode target) {
		this.target = target;
	}
}