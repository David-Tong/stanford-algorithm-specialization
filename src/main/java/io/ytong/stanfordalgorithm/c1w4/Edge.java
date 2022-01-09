package io.ytong.stanfordalgorithm.c1w4;

public class Edge {
	private String startVertex;
	private String endVertex;
	
	public Edge(String startVertex, String endVertex) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
	}

	public String getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(String startVertex) {
		this.startVertex = startVertex;
	}

	public String getEndVertex() {
		return endVertex;
	}

	public void setEndVertex(String endVertex) {
		this.endVertex = endVertex;
	}
	
	public String toString() {
		return String.format("Start Vertex : %s, End Vertex : %s", this.startVertex, this.endVertex);
	}
}
