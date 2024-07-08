package io.ytong.stanfordalgorithm.c3w2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EdgeHelper {
	public List<Edge> getEdges(Map<String, Integer> vertices) {
		List<Edge> edges = new ArrayList<Edge>();
		
		MutationHelper mutationHelper = new MutationHelper();
		for (String vertex : vertices.keySet()) {
			Set<String> mutations = mutationHelper.mutateOneOrTwoBits(vertex);
			for (String mutation : mutations) {
				if (vertices.containsKey(mutation)) {
					Edge edge = new Edge(vertices.get(vertex), vertices.get(mutation));
					edges.add(edge);
				}
			}
		}
		return edges;
	}
}
