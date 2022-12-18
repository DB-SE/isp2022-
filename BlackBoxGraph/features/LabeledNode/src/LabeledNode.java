
import java.util.List;

import interfaces.ILabeledNode;
import interfaces.INode;

public class LabeledNode implements ILabeledNode {

	private String label;
	private List<INode> connectedNodes;

	public LabeledNode(String label) {
		super();
		
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

	public List<INode> getConnectedNodes() {
		return this.connectedNodes;
	}

}
