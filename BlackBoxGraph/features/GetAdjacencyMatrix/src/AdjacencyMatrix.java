import interfaces.IAdjacencyMatrix;
import interfaces.IEdge;
import interfaces.IGraph;
import interfaces.INode;
import interfaces.IWeightedEdge;

public class AdjacencyMatrix implements IAdjacencyMatrix {

	@Override
	public int[][] getAdjacencyMatrix(IGraph graph) {
		int[][] matrix = new int[graph.getNumVertices()][graph.getNumVertices()];
		
		int i = 0;
		for (INode node : graph.getEdgesByVertices().keySet()) {
			for (IEdge edge : graph.getEdgesByVertices().get(node)) {
				int j = 0;
				for (INode targetNode : graph.getEdgesByVertices().keySet()) {
					if (targetNode == edge.getTarget()) {
						if (edge instanceof IWeightedEdge) {
							matrix[i][j] = ((IWeightedEdge)edge).getWeight();
						} else {
							matrix[i][j] = 1;
						}
					}
				}
				j++;
			}
			i++;
		}
		return matrix;
	}

}
