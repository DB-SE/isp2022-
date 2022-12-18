import java.util.List;

import interfaces.IColoredNode;
import interfaces.INode;

public class ColoredNode implements IColoredNode {

	private String color;
	private List<INode> connectedNodes;

	public ColoredNode(String color) {
		super();
		
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		
		return "Label: " + super.toString() + " color: " + this.color;
	}
	
	public List<INode> getConnectedNodes() {
		return this.connectedNodes;
	}

}
