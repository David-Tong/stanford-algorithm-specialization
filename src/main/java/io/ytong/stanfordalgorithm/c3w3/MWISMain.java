package io.ytong.stanfordalgorithm.c3w3;

public class MWISMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// init
		String file = "c3w3/mwis.txt";
		MWISHelper mwisHelper = new MWISHelper(file);
		int[] weights = mwisHelper.getWeights();
		
		// get mwis
		String bits = MWISSolver.findMWIS(weights);
		
		// output
		int[] vertices = {1, 2, 3, 4, 17, 117, 517, 997};
		String ans = "";
		for (int i=0; i<vertices.length; i++) {
			ans += bits.charAt(vertices[i] - 1);
		}
		System.out.println(String.format("The 8-bit string for the vertices 1, 2, 3, 4, 17, 117, 517, and 997 is %s", ans));
	}

}
