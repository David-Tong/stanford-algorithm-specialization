package io.ytong.stanfordalgorithm.c3w4;

public class KnapsackBigMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// init
		String file = "c3w4/knapsack_big.txt";
		KnapsackHelper knapsackHelper = new KnapsackHelper(file);
		int knapsackSize = knapsackHelper.getKnapsackSize();
		Item[] items = knapsackHelper.getItems();
		
		// solve
		long maxValue = KnapsackBigSolver.getMaxValue(knapsackSize, items);

		// output
		System.out.println(String.format("The value of the optimal solution is %d", maxValue));
	}

}
