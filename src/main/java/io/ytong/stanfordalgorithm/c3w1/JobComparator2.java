package io.ytong.stanfordalgorithm.c3w1;

import java.util.Comparator;

public class JobComparator2 implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		// TODO Auto-generated method stub
		double greedyValue1 = o1.getWeight() * 1.0 / o1.getLength();
		double greedyValue2 = o2.getWeight() * 1.0 / o2.getLength();
		if (greedyValue1 > greedyValue2) {
			return -1;
		} else {
			return 1;
		}
	}

}
