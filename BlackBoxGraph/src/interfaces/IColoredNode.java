package interfaces;

public interface IColoredNode extends INode{

	public String getColor();

	public void setColor(String color);

	@Override
	public String toString();
}
