package io.ytong.stanfordalgorithm.c3w3;

public class MWISSolver {
	
	public static String findMWIS(int[] weights) {
		final int L = weights.length; 
	
		// init dp
		long[] dp = new long[L + 1];
		dp[0] = 0;
		dp[1] = weights[0];
		
		String[] is = new String[L + 1];
		is[0] = "";
		is[1] = "1";
		
		// run dp
		for (int i=2; i <= L; i++) {
			// not select
			if (dp[i-1] >= dp[i-2] + weights[i-1]) {
				dp[i] = dp[i-1];
				is[i] = is[i-1] + "0";
			// select
			} else {
				dp[i] = dp[i-2] + weights[i-1];
				is[i] = is[i-2] + "01";
			}
		}
		return is[L];
	}
}
