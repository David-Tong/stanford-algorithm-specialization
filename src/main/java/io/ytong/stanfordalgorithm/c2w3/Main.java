package io.ytong.stanfordalgorithm.c2w3;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		String inputFile = "c2w3-assignments.txt";
		//String inputFile = "test.txt";
		Helper helper = new Helper(inputFile);
		List<Integer> numbers = helper.getInputNumbers();
		
		HeapSolver solver = new HeapSolver(numbers);
		solver.run();
		solver.printMedians();
		solver.printResult();
	}
}
