package main;

import decorator.LabeledGraphDecorator;
import decorator.WeightedGraphDecorator;
import graph.DirectedGraph;
import graph.IGraph;

public class ISPGraphs {
	public static void main(String[] args) {
		IGraph graph = new WeightedGraphDecorator(new LabeledGraphDecorator(new DirectedGraph()));
	}
}
