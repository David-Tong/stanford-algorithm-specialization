package io.ytong.stanfordalgorithm.c3w1;

import java.util.HashMap;
import java.util.Map;

public class Graph {
	private int nodeNumber;
	private Map<Integer, Map<Integer, Integer>> adjacentMatrix;
	
	public Graph(int nodeNumber) {
		this.nodeNumber = nodeNumber;
		this.adjacentMatrix = new HashMap<Integer, Map<Integer, Integer>>();
	}
	
	public int getNodeNumber() {
		return nodeNumber;
	}

	public void setNodeNumber(int nodeNumber) {
		this.nodeNumber = nodeNumber;
	}
	
	public Map<Integer, Map<Integer, Integer>> getAdjacentMatrix() {
		return adjacentMatrix;
	}

	public void setAdjacentMatrix(Map<Integer, Map<Integer, Integer>> adjacentMatrix) {
		this.adjacentMatrix = adjacentMatrix;
	}
	
	public void setCost(int source, int target, int cost) {
		if (!this.adjacentMatrix.containsKey(source)) {
			this.adjacentMatrix.put(source, new HashMap<Integer, Integer>());
		}
		this.adjacentMatrix.get(source).put(target, cost);
	}
}
