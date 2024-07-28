package io.ytong.stanfordalgorithm.c4w1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// init
		String file = "c4w1/g1.txt";
		GraphHelper graphHelper = new GraphHelper(file);
		int graphSize = graphHelper.getGraphSize();
		int[][] adjacencyMatrix = graphHelper.getAdjacencyMatrix();
		
		// solve
		int[][] shortestPaths = FloydSolver.calculateShortestPaths(graphSize, adjacencyMatrix);
		if (shortestPaths != null) {
			int shortestPath = getShortestPath(graphSize, shortestPaths);
			System.out.println(shortestPath);
		}
		
		// init
		file = "c4w1/g2.txt";
		graphHelper = new GraphHelper(file);
		graphSize = graphHelper.getGraphSize();
		adjacencyMatrix = graphHelper.getAdjacencyMatrix();
		
		// solve
		shortestPaths = FloydSolver.calculateShortestPaths(graphSize, adjacencyMatrix);
		if (shortestPaths != null) {
			int shortestPath = getShortestPath(graphSize, shortestPaths);
			System.out.println(shortestPath);
		}
		
		// init
		file = "c4w1/g3.txt";
		graphHelper = new GraphHelper(file);
		graphSize = graphHelper.getGraphSize();
		adjacencyMatrix = graphHelper.getAdjacencyMatrix();
		
		// solve
		shortestPaths = FloydSolver.calculateShortestPaths(graphSize, adjacencyMatrix);
		if (shortestPaths != null) {
			int shortestPath = getShortestPath(graphSize, shortestPaths);
			System.out.println(shortestPath);
		}
	}
	
	private static int getShortestPath(int graphSize, int[][] shortestPaths) {
		int shortestPath = Integer.MAX_VALUE;
		for (int i=0; i<graphSize; i++) {
			for (int j=0; j<graphSize; j++) {
				if (i != j) {
					shortestPath = Math.min(shortestPath, shortestPaths[i][j]);
				}
			}
		}
		return shortestPath;
	}

}
