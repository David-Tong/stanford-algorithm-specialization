package io.ytong.stanfordalgorithm.c4w1;

public class FloydSolver {
	public static int[][] calculateShortestPaths(int graphSize, int[][] adjacencyMatrix) {
		// init dp
		// dp[i][j] - shortest path between vertex i and j
		int[][] dp = new int[graphSize][graphSize];
		for (int i=0; i<graphSize; i++) {
			for (int j=0; j<graphSize; j++) {
				dp[i][j] = adjacencyMatrix[i][j];
			}
		}
		
		// dp transfer
		for (int n=0; n<graphSize; n++) {
			for (int i=0; i<graphSize; i++) {
				for (int j=0; j<graphSize; j++) {
					if (dp[i][n] != Integer.MAX_VALUE && dp[n][j] != Integer.MAX_VALUE) {
						if (dp[i][j] > dp[i][n] + dp[n][j]) {
							dp[i][j] = dp[i][n] + dp[n][j];
						}
					}
				}
			}
		}
		
		// check whether it exists negative weight cycle
		for (int n=0; n<graphSize; n++) {
			if (dp[n][n] < 0) {
				System.out.println("Negative weight cycle does exist.");
				return null;
			}
		}
		
		return dp;
	}
}
