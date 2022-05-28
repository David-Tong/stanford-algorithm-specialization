package io.ytong.stanfordalgorithm.c2w3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSolver {
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	private List<Integer> numbers;
	private List<Integer> medians;
	private int size;
	
	public HeapSolver(List<Integer> numbers) {
		this.maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		this.minHeap = new PriorityQueue<Integer>();
		this.numbers = numbers;
		this.medians = new ArrayList<Integer>();
		this.size = this.numbers.size();	
	}
	
	public void run() {
		for(int i=0; i<size; i++) {
			int current = numbers.get(i);
			if (!minHeap.isEmpty() && current > minHeap.peek()) {
				minHeap.offer(current);
			} else if (!maxHeap.isEmpty() && current <= maxHeap.peek() ) {
				maxHeap.offer(current);
			} else {
				maxHeap.offer(current);
			}
			
			while (maxHeap.size() > minHeap.size() + 1) {
				minHeap.offer(maxHeap.poll());
			}
			
			while (minHeap.size() > maxHeap.size() + 1) {
				maxHeap.offer(minHeap.poll());
			}
			
			int median = 0;
			if (i % 2 == 1) {
				median = maxHeap.peek();
				
			} else {
				if (maxHeap.size() > minHeap.size()) {
					median = maxHeap.peek();
				} else {
					median = minHeap.peek();
				}	
			}
			medians.add(median);
		}
	}
	
	public void printMedians() {	
		int idx = 0;
		for (double median : medians) {
			idx++;
			System.out.print("M" + idx + " : " + median + ", ");
		}
		System.out.println();
	}

	public void printResult() {
		long sum = 0;
		for (int median : medians) {
			sum += median;
		}
		long result = sum % 10000;
		System.out.println(result);
	}
}
