import edge.Edge;
import edge.WeightedEdge;
import node.Node;

/**
 * TODO description
 */
public class Graph {
	public Graph() {
		original();
	}

	public void getAdjacencyMatrix() {
		int[][] matrix = new int[this.numVertices][this.numVertices];
		
		int i = 0;
		for (Node node : this.edgesByVertices.keySet()) {
			for (Edge edge : this.edgesByVertices.get(node)) {
				int j = 0;
				for (Node targetNode : this.edgesByVertices.keySet()) {
					if (targetNode == edge.getTarget()) {
						if (edge instanceof WeightedEdge) {
							matrix[i][j] = ((WeightedEdge)edge).getWeight();
						} else {
							matrix[i][j] = 1;
						}
					}
				}
				j++;
			}
			i++;
		}
		
		System.out.println(matrix);
	}
}