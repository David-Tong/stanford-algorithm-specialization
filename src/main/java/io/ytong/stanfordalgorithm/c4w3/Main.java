package io.ytong.stanfordalgorithm.c4w3;

import io.ytong.stanfordalgorithm.c4w3.NnHelper.Location;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "c4w3/nn.txt";
		NnHelper nnHelper = new NnHelper(file);
		int size = nnHelper.getSize();
		Location[] locations = nnHelper.getLocations();
		
		// solve
		double minimumCost = NnSolver.getNearestNeighborHeuristicCost(size, locations);
		System.out.println(String.format("The cost of the traveling salesman tour computed by the nearest neighbor heuristic for this instance : %f", minimumCost));
	}

}
