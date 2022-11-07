package node;

import java.util.List;

public class LabeledNode extends Node {

	private String label;

	public LabeledNode(String label) {
		super();
		
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public String setLabel(label) {
		this.label = label;
	}

	@override
	public String toString() {
		return this.label;
	}
}