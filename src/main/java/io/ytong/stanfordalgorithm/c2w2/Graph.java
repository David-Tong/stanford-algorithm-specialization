package io.ytong.stanfordalgorithm.c2w2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private Map<Integer, List<Pair>> adjacentMatrix;
	
	public Graph() {
		this.adjacentMatrix = new HashMap<Integer, List<Pair>>();
	}

	public Map<Integer, List<Pair>> getAdjacentMatrix() {
		return adjacentMatrix;
	}
	
	public int getGraphSize() {
		return this.adjacentMatrix.keySet().size();
	}
	
	public String toString() {
		String toString = "";
		for (Integer vertex: adjacentMatrix.keySet()) {
			String vertexLine = "[" + vertex + " : ";
			for (Pair pair : adjacentMatrix.get(vertex)) {
				vertexLine += pair.toString() +  ", ";
			}
			vertexLine += "] \n";
			toString += vertexLine;
		}
		return toString;
	}
}
