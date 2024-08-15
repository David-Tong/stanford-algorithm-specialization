package io.ytong.stanfordalgorithm.c4w3;

import io.ytong.stanfordalgorithm.c4w3.NnHelper.Location;

public class NnSolver {
	
	public static double getNearestNeighborHeuristicCost(int size, Location[] locations) {
		// pre-process
		boolean[] visited = new boolean[size];
		int currCity = 0;
		int visitedCity = 1;
		visited[currCity] = true;
		double cost = 0.0;
		
		// process
		while (visitedCity < size) {
			int nextCity = -1;
			double miniDistance = Double.MAX_VALUE;
			for (int otherCity=0; otherCity<size; otherCity++) {
				if (!visited[otherCity]) {
					double distance = locations[currCity].getDistance(locations[otherCity]);
					if (distance < miniDistance) {
						nextCity = otherCity;
						miniDistance = distance;
					}
				}
			}
			visited[nextCity] = true;
			currCity = nextCity;
			cost += miniDistance;
			visitedCity++;
		}
		
		cost += locations[currCity].getDistance(locations[0]);
		return cost;
	}
	
}
