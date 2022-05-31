package io.ytong.stanfordalgorithm.c2w4;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		String inputFile = "c2w4-assignments.txt";
		Helper helper = new Helper(inputFile);
		List<Long> numbers = helper.getInputNumbers();
		
		final int LOWER_BOUND = -10000;
		final int UPPER_BOUND = 10000;
		HashMapSolver solver = new HashMapSolver(LOWER_BOUND, UPPER_BOUND, numbers);
		solver.run();
		System.out.println(solver.getResult());
	}

}
