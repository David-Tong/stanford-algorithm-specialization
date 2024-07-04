package io.ytong.stanfordalgorithm.c3w1;

import java.util.Map;
import java.util.PriorityQueue;

public class PrimSolver {
	private Graph graph;
	private long mstValue;
	
	public PrimSolver(Graph graph) {
		this.graph = graph;
		this.mstValue = 0;
	}
	
	public void run() {
		PriorityQueue<Cost> pq = new PriorityQueue<Cost>();
		boolean[] visited = new boolean[this.graph.getNodeNumber() + 1];
		
		// start from node 1, since Prim's algorithm apply to arbitrary node.
		Cost cost = new Cost(1, 0);
		pq.offer(cost);
		while (!pq.isEmpty()) {
			Cost curr = pq.poll();
			int node = curr.getNode();
			if (visited[node]) {
				continue;
			}
			visited[node] = true;
			this.mstValue += curr.getCost();
			
			// update
			Map<Integer, Integer> targets = this.graph.getAdjacentMatrix().get(curr.getNode());
			for (Integer target : targets.keySet()) {
				Cost next = new Cost(target, targets.get(target));
				pq.offer(next);
			}
		}
	}

	public long getMstValue() {
		return mstValue;
	}
}
