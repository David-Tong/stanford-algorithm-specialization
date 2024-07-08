package io.ytong.stanfordalgorithm.c3w2;

import java.util.List;
import java.util.Map;

public class ClusteringBigMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// init
		String clusteringBigFile = "c3w2/clustering_big.txt";
		ClusteringBigHelper clusteringBigHelper = new ClusteringBigHelper(clusteringBigFile);
		Map<String, Integer> vertices = clusteringBigHelper.getVertices();
		int vertexNumber = clusteringBigHelper.getVertexNumber();
		int claimNumber = clusteringBigHelper.getClaimNumber();
		
		// run
		UnionFindSet ufs = new UnionFindSet(claimNumber, vertexNumber);
		EdgeHelper edgeHelper = new EdgeHelper();
		List<Edge> edges = edgeHelper.getEdges(vertices);	
		
		for (Edge edge : edges) {
			ufs.union(edge.getSource(), edge.getTarget());
		}
		
		// report
		int clusterNumber = ufs.getClusterNumber();
		System.out.println(String.format("%d clusters are needed to ensure that no pair of nodes"
				 + "with all but 2 bits in common get split into different clusters", 
				 clusterNumber));
	}

}
