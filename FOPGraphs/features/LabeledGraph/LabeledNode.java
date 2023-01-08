public class Node {
	private String label;

	public Node(String label) {
		original();
		
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return this.label;
	}
}