package interfaces;


public interface IEdge {
	
	public INode getConnected(INode node);
	
	public INode getSource();
	public void setSource(INode source);
	
	public INode getTarget();
	public void setTarget(INode target);
}
