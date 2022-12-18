package interfaces;

public interface ILabeledNode extends INode{

	public String getLabel();

	public void setLabel(String label);

	@Override
	public String toString();
}
