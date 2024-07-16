package io.ytong.stanfordalgorithm.c3w4;

import java.util.HashMap;
import java.util.Map;

public class KnapsackBigSolver {
	public static long getMaxValue(int knapsackSize, Item[] items) {
		// init dp
		final int L = items.length;
		Map<Integer, Long> dp = new HashMap<Integer, Long>();
		dp.put(0, 0L);
		
		// solve
		for (int i=0; i<L; i++) {
			Map<Integer, Long> newDp = new HashMap<Integer, Long>();
			for (int key : dp.keySet()) {
				// not select
				if (newDp.containsKey(key)) {
					if (newDp.get(key) < dp.get(key)) {
						newDp.put(key, dp.get(key));
					}
				} else {
					newDp.put(key, dp.get(key));
				}
				
				// select
				int newKey = key + items[i].getWeight();
				long newValue = dp.get(key) + items[i].getValue();
				if (newKey <= knapsackSize) {
					if (newDp.containsKey(newKey)) {
						if (newDp.get(newKey) < newValue) {
							newDp.put(newKey, newValue);
						}
					} else {
						newDp.put(newKey, newValue);
					}
				}
			}
			dp = newDp;
		}
		
		// report
		long maxValue = 0;
		for (int key : dp.keySet()) {	
			maxValue = Math.max(maxValue, dp.get(key));
		}
		
		return maxValue;
	}

}
