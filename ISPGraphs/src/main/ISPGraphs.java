package main;

import data.Graph;

public class ISPGraphs {
	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<Integer>();
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 9);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		
		graph.addEdge(4, 6);
		
		graph.addEdge(5, 6);
		graph.addEdge(5, 8);
		graph.addEdge(5, 9);
		
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		
		graph.addEdge(7, 8);
		graph.addEdge(7, 9);
		
		graph.addEdge(8, 9);
		
		graph.DFS(5);
	}
}
