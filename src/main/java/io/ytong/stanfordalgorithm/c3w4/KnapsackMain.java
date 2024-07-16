package io.ytong.stanfordalgorithm.c3w4;

public class KnapsackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// init
		String file = "c3w4/knapsack1.txt";
		KnapsackHelper knapsackHelper = new KnapsackHelper(file);
		int knapsackSize = knapsackHelper.getKnapsackSize();
		Item[] items = knapsackHelper.getItems();
		
		// solve
		long maxValue = KnapsackSolver.getMaxValue(knapsackSize, items);
		
		// output
		System.out.println(String.format("The value of the optimal solution is %d", maxValue));
	}

}
