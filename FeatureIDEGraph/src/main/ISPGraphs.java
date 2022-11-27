package main;

// #if LabeledGraph 
//@import decorator.LabeledGraphDecorator;
// #endif
//#if DirectedGraph
//@import graph.DirectedGraph;
//#endif

// #if UndirectedGraph
import graph.UndirectedGraph;
// #endif
// #if WeightedGraph
//@import decorator.WeightedGraphDecorator;
// #endif
// #if ColoredGraph 
//@import decorator.ColoredGraphDecorator;
// #endif
import graph.IGraph;

public class ISPGraphs {
	public static void main(String[] args) {
		IGraph graph;
		
		// #if DirectedGraph
//@		graph = new DirectedGraph();
		// #endif
		// #if UndirectedGraph
		graph = new UndirectedGraph();
		// #endif
		// #if LabeledGraph
//@		graph = new LabeledGraphDecorator(graph);
		// #endif
		// #if ColoredGraph
//@		graph = new ColoredGraphDecorator(graph);
		// #endif		
		// #if WeightedGraph
//@		graph = new WeightedGraphDecorator(graph);
		// #endif
	}
}
