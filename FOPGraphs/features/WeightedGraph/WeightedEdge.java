/**
 * TODO description
 */
public class Edge {
	private int weight;
	
	public Edge(Node source, Node target, int weight) {
		original(source, target);
		this.weight = weight;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int w) {
		this.weight = w;
	}
}