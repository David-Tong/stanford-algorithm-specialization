package io.ytong.stanfordalgorithm.c4w2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// init
		String file = "c4w2/tsp.txt";
		TspHelper tspHelper = new TspHelper(file);
		int size = tspHelper.getSize();
		double[][] distances = tspHelper.getDistances();
		
		// solve
		double minimumCost = TspSolver.getMinimumCostOfTsp(size, distances);
		System.out.println(String.format("The minimum cost of a traveling salesman tour for this instance : %f", minimumCost));
	}
}
