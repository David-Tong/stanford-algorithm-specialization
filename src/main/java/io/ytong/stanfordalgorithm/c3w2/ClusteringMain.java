package io.ytong.stanfordalgorithm.c3w2;

import java.util.Arrays;
import java.util.List;

public class ClusteringMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// init
		String clusteringFile = "c3w2/clustering1.txt";
		ClusteringHelper clusteringHelper = new ClusteringHelper(clusteringFile);
		Cost[] costs = clusteringHelper.getCosts();
		int vertexNumber = clusteringHelper.getVertexNumber();
		int[][] costMatrix = clusteringHelper.getCostMatrix();
		
		// sort by cost
		Arrays.sort(costs);
		
		// union find set
		UnionFindSet ufs = new UnionFindSet(vertexNumber);
	
		// clustering
		final int K = 4;
		int index = 0;
		while (ufs.getClusterNumber() > K) {
			Cost cost = costs[index];
			ufs.union(cost.getSource(), cost.getTarget());
			index += 1;
		}
		
		// output
		List<List<Integer>> clusters = ufs.getClusters();
		int miniDistance = Integer.MAX_VALUE;
		
		for (int i=0; i<clusters.size(); i++) {
			for (int j=i+1; j<clusters.size(); j++) {
				for (Integer source : clusters.get(i)) {
					for (Integer target: clusters.get(j)) {
						miniDistance = Math.min(miniDistance, costMatrix[source][target]);
					}
				}
			}
		}
		
		System.out.println(String.format("The maximum spacing of a 4-clustering is %d", miniDistance));
	}

}
