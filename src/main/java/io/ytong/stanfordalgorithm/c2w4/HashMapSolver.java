package io.ytong.stanfordalgorithm.c2w4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapSolver {
	
	private int lowerBound;
	private int upperBound;
	private Map<Long, Integer> numbers;
	private Map<Integer, Integer> intervals;
	private int result;
	
	public HashMapSolver(int lowerBound, int upperBound, List<Long> numbers) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.numbers = new HashMap<Long, Integer>();
		for (Long number : numbers) {
			if (this.numbers.containsKey(number)) {
				this.numbers.put(number, this.numbers.get(number) + 1);
			} else {
				this.numbers.put(number, 1);
			}
		}
		this.intervals = new HashMap<Integer, Integer>();
		for (int t=lowerBound; t<=upperBound; t++) {
			this.intervals.put(t, 0);
		}
		this.result = 0;
	}
	
	public void run() {
		int idx = 0;
		for (Long number : numbers.keySet()) {
			for (int t=lowerBound; t<=upperBound; t++) {
				long y = t - number;
				if (numbers.containsKey(y)) {
					if (number == y) {
						if (numbers.get(number) > 1) {
							intervals.put(t, 1);
						}
					} else {
						intervals.put(t, 1);
					}
				}
			}
			
			idx++;
			if (idx % 10000 == 0) {
				System.out.println("idx - " + idx);
			}
		}
	}
	
	public int getResult() {
		result = 0;
		for (Integer interval : intervals.values()) {
			result += interval;
		}
		return result;
	}
	
}
