
import interfaces.IEdge;
import interfaces.INode;

public class Edge implements IEdge {
	private INode target;
	private INode source;

	public Edge(INode source, INode target) {
		this.source = source;
		this.target = target;
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