package io.ytong.stanfordalgorithm.c3w1;

public class Cost implements Comparable<Cost> {

	private int node;
	private int cost;
	
	public Cost(int node, int cost) {
		this.setNode(node);
		this.setCost(cost);
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Cost other) {
		// TODO Auto-generated method stub
		return this.cost - other.cost;
	}

}
