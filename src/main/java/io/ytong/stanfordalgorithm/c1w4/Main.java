package io.ytong.stanfordalgorithm.c1w4;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		InputHelper helper = new InputHelper();	
		ArrayList<Edge> edges = (ArrayList<Edge>) helper.getEdgeListFromResourceFile("c1w4-assignments.txt");
		MinCutSolver minCutSolver = new MinCutSolver(edges);
		minCutSolver.getMinCut();
	}
}
