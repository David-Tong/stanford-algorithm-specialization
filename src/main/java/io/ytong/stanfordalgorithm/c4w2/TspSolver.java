package io.ytong.stanfordalgorithm.c4w2;

public class TspSolver {
	public static double getMinimumCostOfTsp(int size, double[][] distances) {
		// init dp
		// dp[S][j] - the minimum cost, visit cities of S, and on j for the last stop
		int stateSize = 1 << size;
		double[][] dp = new double[stateSize][size];
		for (int s=0; s<stateSize; s++) {
			for (int j=0; j<size; j++) {
				dp[s][j] = -1;
			}
		}
		dp[1][0] = 0;
		
		// dp transfer
		for (int s=1; s<stateSize; s++) {
			if (s % 10000 == 0) {
				System.out.println(s);
			}
			// current city
			for (int j=0; j<size; j++) {
				if (dp[s][j] == -1) {
					continue;
				}
				// next city
				for (int k=0; k<size; k++) {
					if ((s & (1 << k)) != 0) {
						continue;
					}
					// new state p
					int p = (s | (1 << k));
					if (dp[p][k] == -1) {
						dp[p][k] = dp[s][j] + distances[j][k];
					}
					dp[p][k] = Math.min(dp[p][k], dp[s][j] + distances[j][k]);
				}
			}
		}
		
		// final process
		double ans = Double.MAX_VALUE;
		for (int j=1; j<size; j++) {
			ans = Math.min(ans, dp[stateSize - 1][j] + distances[j][0]);
		}
		
		return ans;
	}

}
