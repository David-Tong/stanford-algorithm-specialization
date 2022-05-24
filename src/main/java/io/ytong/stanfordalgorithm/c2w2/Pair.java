package io.ytong.stanfordalgorithm.c2w2;

public class Pair implements Comparable<Pair> {
	private Integer target;
	private Integer distance;
	
	public Pair(Integer target, Integer distance) {
		this.target = target;
		this.distance = distance;
	}
	
	public int getTarget() {
		return this.target;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	@Override
	public int compareTo(Pair other) {
		return this.distance - other.distance;
	}
	
	public String toString() {
		return "[" + this.target + " : " + this.distance + "]";
	}
}
