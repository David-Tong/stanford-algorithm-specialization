package io.ytong.stanfordalgorithm.c3w1;

import java.util.Comparator;

public class JobComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		// TODO Auto-generated method stub
		int greedyValue1 = o1.getWeight() - o1.getLength();
		int greedyValue2 = o2.getWeight() - o2.getLength();
		
		if (greedyValue1 != greedyValue2) {
			return greedyValue2 - greedyValue1; 
		} else {
			return o2.getWeight() - o1.getWeight();
		}
	}

}
