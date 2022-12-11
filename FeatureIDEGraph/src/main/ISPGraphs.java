package main;

import edge.Edge;
// #if LabeledGraph 
//@import decorator.LabeledGraphDecorator;
// #endif
//#if DirectedGraph
import graph.DirectedGraph;
//#endif

// #if UndirectedGraph
//@import graph.UndirectedGraph;
// #endif
// #if WeightedGraph
//@import decorator.WeightedGraphDecorator;
// #endif
// #if ColoredGraph 
//@import decorator.ColoredGraphDecorator;
// #endif
import graph.IGraph;
import node.Node;

public class ISPGraphs {
	public static void main(String[] args) {
		IGraph graph;
		
		Node node = new Node();
		Node connected = new Node();
		Edge edge = new Edge(node, connected);
		
		// #if DirectedGraph
		graph = new DirectedGraph();
		// #endif
		// #if UndirectedGraph
//@		graph = new UndirectedGraph();
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
		
		graph.addEdge(edge);
		
		graph.Traverse(node);
	}
}
