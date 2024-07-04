package io.ytong.stanfordalgorithm.c3w1;

public class MstMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String graphFile = "c3w1/edges.txt";
		MstHelper mstHelper = new MstHelper(graphFile);
		Graph graph = mstHelper.getGraph();
		
		PrimSolver solver = new PrimSolver(graph);
		solver.run();
		
		System.out.println(String.format("MST value is : %s", solver.getMstValue()));
	}

}
