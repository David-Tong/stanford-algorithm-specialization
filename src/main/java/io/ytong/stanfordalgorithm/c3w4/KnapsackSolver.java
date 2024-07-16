package io.ytong.stanfordalgorithm.c3w4;

public class KnapsackSolver {
	public static long getMaxValue(int knapsackSize, Item[] items) {
		// init dp
		final int M = items.length + 1;
		final int N = knapsackSize + 1;
		long[][] dp = new long[M][N];
		
		// run dp
		for (int i=1; i<M; i++) {
			for (int j=1; j<N; j++) {
				dp[i][j] = dp[i-1][j];
				int weight = items[i-1].getWeight();
				int value = items[i-1].getValue();
				if (j - weight >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight] + value);
				}
			}
		}
		return dp[M-1][N-1];
	}

}
