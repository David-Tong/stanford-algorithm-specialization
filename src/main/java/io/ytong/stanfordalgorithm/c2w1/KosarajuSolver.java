package io.ytong.stanfordalgorithm.c2w1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KosarajuSolver {
	private Graph graph;
	private Graph reversedGraph;
	private Set<String> visited;
	private List<String> sequences;
	private List<List<String>> sccs;
	
	public KosarajuSolver(Graph graph, Graph reversedGraph) {
		this.graph = graph;
		this.reversedGraph = reversedGraph;
		this.visited = new HashSet<String>();
		this.sequences = new ArrayList<String>();
		this.sccs = new ArrayList<List<String>>();
	}
	
	public void run() {
		// do DFS
		for (String vertex : graph.getAdjacentMatrix().keySet()) {
			if (!visited.contains(vertex)) {
				doDFS(vertex);
			}
		}
		
		// do reverse DFS
		visited.clear();
		for (int i = sequences.size() - 1; i >= 0; i--) {
			String vertex = sequences.get(i);
			if (!visited.contains(vertex)) {
				List<String> scc = new ArrayList<String>();
				doReversedDFS(vertex, scc);
				sccs.add(scc);
			}
		}	
	}
	
	public List<List<String>> getSccs() {
		return sccs;
	}
	
	private void doDFS(String vertex) {
		visited.add(vertex);
		if (graph.getAdjacentMatrix().get(vertex) != null) {
			for (String neighbor : graph.getAdjacentMatrix().get(vertex)) {
				if (!visited.contains(neighbor)) {
					doDFS(neighbor);
				}
				sequences.add(vertex);
			}
		}
	}
	
	private void doReversedDFS(String vertex, List<String> scc) {
		visited.add(vertex);
		scc.add(vertex);
		if (reversedGraph.getAdjacentMatrix().get(vertex) != null) {
			for (String neighbor : reversedGraph.getAdjacentMatrix().get(vertex)) {
				if (!visited.contains(neighbor)) {
					doReversedDFS(neighbor, scc);
				}
			}	
		}
	}
}
