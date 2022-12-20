import  java.util.List;
import  interfaces.IGraph;
import  loader.PluginLoader;

public class Main {
	
	public static void main(String[] args) {
		List<IGraph> graphList = PluginLoader.load(IGraph.class);
		for(IGraph graph : graphList) {
			graph.getNumVertices();
		}
	}
	
}
