/**
 * TODO description
 */
public class ColoredNode extends Node {
	private String color;

	public ColoredNode(String color) {
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
}