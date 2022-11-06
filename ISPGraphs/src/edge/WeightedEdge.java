package edge;

public class WeightedEdge<T> extends Edge<T> {
	private int weight;
	
	public WeightedEdge(T source, T target, int weight) {
		super(source, target);
		this.weight = weight;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public void setWeight(int w) {
		this.weight = w;
	}
}
