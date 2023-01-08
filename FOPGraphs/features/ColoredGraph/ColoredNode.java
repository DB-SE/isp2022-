/**
 * TODO description
 */
public class Node {
	private String color;

	public Node(String color) {
		original();
		
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