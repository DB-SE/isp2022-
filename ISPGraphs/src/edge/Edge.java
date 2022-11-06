package edge;

public class Edge<T> {
	private T target;
	private T source;

	public Edge(T source, T target) {
		this.source = source;
		this.target = target;
	}
	
	public T getConnected(T node) {
		if (node.equals(this.target)) {
			return this.source;
		}
		
		if (node.equals(this.source)) {
			return this.target;
		}
		
		return null;
	}
	
	public T getSource() {
		return this.source;
	}
	
	public T getTarget() {
		return this.target;
	}
}
