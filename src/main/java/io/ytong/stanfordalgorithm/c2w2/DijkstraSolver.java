package io.ytong.stanfordalgorithm.c2w2;

import java.util.PriorityQueue;

public class DijkstraSolver {
	private final static int MAX_DISTANCE = 1000000;
	
	private Graph graph;
	private int graphSize;
	private int[] shortestDistance;
	private boolean[] visited;
    
	public DijkstraSolver(Graph graph) {
		this.graph = graph;
		this.graphSize = this.graph.getGraphSize();
		this.shortestDistance = new int[graphSize];
		this.visited = new boolean[graphSize];
		for (int i = 0; i < this.graphSize; i++) {
			this.shortestDistance[i] = MAX_DISTANCE;
			this.visited[i] = false;
		}
	}
	
	public void run() {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		Pair source = new Pair(1, 0);
		pq.offer(source);
		shortestDistance[0] = 0;
		while (!pq.isEmpty()) {
			Pair current = pq.poll();
			int target = current.getTarget();
			//int distance = current.getDistance();
			if (visited[target - 1]) {
				continue;
			}
			visited[target - 1] = true;
			for (Pair pair : graph.getAdjacentMatrix().get(target)) {
				int next = pair.getTarget();
				int nextDistance = pair.getDistance();
				if (shortestDistance[next - 1] > shortestDistance[target - 1] + nextDistance &&
						!visited[next - 1]) {
					shortestDistance[next - 1] = shortestDistance[target - 1] + nextDistance;
					Pair newPair = new Pair(next, shortestDistance[target - 1] + nextDistance);
					pq.offer(newPair);
				}
			}
		}
	}
	
	public void getShortestDistance() {
		for (int i = 0; i < graphSize; i++) {
			System.out.println(i + " : " + shortestDistance[i]);
		}
	}
	
	public void reportAnswer() {
		int[] vertices = {7,37,59,82,99,115,133,165,188,197};
		for (int vertex: vertices) {
			System.out.print(shortestDistance[vertex - 1] + ",");
		}
		System.out.println();
	}
}