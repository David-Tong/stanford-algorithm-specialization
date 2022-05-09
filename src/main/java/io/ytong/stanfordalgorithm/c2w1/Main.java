package io.ytong.stanfordalgorithm.c2w1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String graphFile = "c2w1-assignments.txt";
		GraphHelper graphHelper = new GraphHelper(graphFile);	
		Graph graph = graphHelper.getGraph();
		Graph reversedGraph = graphHelper.getReversedGraph();
		
		// run kosaraju algorithm
		KosarajuSolver solver = new KosarajuSolver(graph, reversedGraph);
		solver.run();
		List<List<String>> sccs = solver.getSccs();
		
		// count
		List<Integer> counter = new ArrayList<Integer>();
		for (List<String> scc : sccs) {
			counter.add(scc.size());
		}
		Collections.sort(counter, Collections.reverseOrder());
		
		System.out.println(counter);
	}
}
