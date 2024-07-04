package io.ytong.stanfordalgorithm.c3w1;

public class Job {
	private int weight;
	private int length;
	
	public Job(int weight, int length) {
		this.setWeight(weight);
		this.setLength(length);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
