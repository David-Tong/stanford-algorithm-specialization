package io.ytong.stanfordalgorithm.c2w1;

import java.util.HashMap;
import java.util.List;

public class Graph {
	private HashMap<String, List<String>> adjacentMatrix = new HashMap<String, List<String>>();

	public HashMap<String, List<String>> getAdjacentMatrix() {
		return adjacentMatrix;
	}
}
