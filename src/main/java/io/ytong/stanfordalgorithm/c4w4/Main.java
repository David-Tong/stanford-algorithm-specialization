package io.ytong.stanfordalgorithm.c4w4;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] files = {"2sat1.txt", "2sat2.txt", "2sat3.txt", "2sat4.txt", "2sat5.txt", "2sat6.txt"};
		//String[] files = {"input_beaunus_10_20.txt", "input_beaunus_11_40.txt"};
		
		for (String file : files) {
			// System.out.println(file);
			
			// init
			file = "c4w4/" + file;
			TwoSatHelper twoSatHelper = new TwoSatHelper(file);
			Map<Integer, List<Integer>> graph = twoSatHelper.getGraph();
		
			// check satisfiability
			KosarajuSolver kosarajuSolver = new KosarajuSolver(graph);
			boolean isSatisfiability = kosarajuSolver.checkSatisfiability();
			System.out.println(file + " satisfiability is " + isSatisfiability);
		}
	}

}
