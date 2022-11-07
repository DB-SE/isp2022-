package graph;

import java.util.List;

import edge.Edge;

public class LabeledNode extends Node {

	private string label;

	public LabeledNode(string label) {
		super();
		
		this.label = label;
	}

	public string getLabel() {
		return this.label;
	}

}