package io.ytong.stanfordalgorithm.c4w4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KosarajuSolver {
	
	private Map<Integer, List<Integer>> graph;
	
	public KosarajuSolver(Map<Integer, List<Integer>> graph) {
		this.graph = graph;
	}
	
	public boolean checkSatisfiability() {
		// 1. DFS 
		// get the post orders
		Set<Integer> visited = new HashSet<Integer>();
		Deque<Integer> postOrder = new ArrayDeque<Integer>();
		for (int vertex : graph.keySet()) {
			if (!visited.contains(vertex)) {
				dfs(graph, vertex, visited, postOrder);
			}
		}
		// System.out.println(postOrder);
		
		// 2. Reverse the graph
		Map<Integer, List<Integer>> reversedGraph = reverseGraph();
		
		// 3. DFS again
		// get the strong connected components 
		// verify if exists A -> -A to check satisfiability
		visited = new HashSet<Integer>();
		while (!postOrder.isEmpty()) {
			Integer vertex = postOrder.pollLast();
			if (!visited.contains(vertex)) {
				Deque<Integer> scc = new ArrayDeque<Integer>();
				dfs(reversedGraph, vertex, visited, scc);
				for(int A : scc) {
					if (scc.contains(-1 * A)) {
						// System.out.println("Not Satisfiable " + A);
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	private void dfs(Map<Integer, List<Integer>> graph, int vertex, 
			Set<Integer> visited, Deque<Integer> postOrder) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.addLast(vertex);
		Set<Integer> visitedOnce = new HashSet<Integer>();
		
		while (!stack.isEmpty()) {
			vertex = stack.peekLast();
			// get post order
			if (!visitedOnce.contains(vertex)) {
				visited.add(vertex);
				if (graph.containsKey(vertex)) {
					for (Integer vertex2 : graph.get(vertex)) {
						if (!visited.contains(vertex2)) {
							stack.addLast(vertex2);
						}
					}
				}
				visitedOnce.add(vertex);
			} else {
				postOrder.addLast(vertex);
				stack.pollLast();
			}
		}	
	}
	
	private Map<Integer, List<Integer>> reverseGraph() {
		Map<Integer, List<Integer>> reversedGraph = new HashMap<Integer, List<Integer>>();
		for (Integer A : graph.keySet()) {
			for (Integer B : graph.get(A)) {
				if (!reversedGraph.containsKey(B)) {
					reversedGraph.put(B, new ArrayList<Integer>());
				}
				reversedGraph.get(B).add(A);
			}
		}
		return reversedGraph;
	}

}
