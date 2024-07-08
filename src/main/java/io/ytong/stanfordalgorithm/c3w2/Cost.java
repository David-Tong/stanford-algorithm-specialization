package io.ytong.stanfordalgorithm.c3w2;

public class Cost implements Comparable<Cost> {
	private int source;
	private int target;
	private int cost;
	
	public Cost(int source, int target, int cost) {
		this.source = source;
		this.target = target;
		this.cost = cost;
	}
	
	public int getSource() {
		return source;
	}
	
	public void setSource(int source) {
		this.source = source;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
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
	
	public String toString() {
		return String.format("Source : %s, target : %s, cost : %s",
				this.source, this.target, this.cost);
	}
}
