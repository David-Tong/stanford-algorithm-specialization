package io.ytong.stanfordalgorithm.c2w2;

import io.ytong.stanfordalgorithm.c2w2.Graph;
import io.ytong.stanfordalgorithm.c2w2.GraphHelper;

public class Main {
	public static void main(String[] args) {
		String graphFile = "c2w2-assignments.txt";
		GraphHelper graphHelper = new GraphHelper(graphFile);	
		Graph graph = graphHelper.getGraph();
		
		DijkstraSolver solver = new DijkstraSolver(graph);
		solver.run();
		//solver.getShortestDistance();		
		solver.reportAnswer();
	}
}
