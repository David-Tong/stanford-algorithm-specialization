package io.ytong.stanfordalgorithm.c2w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.ytong.stanfordalgorithm.c2w2.Graph;

public class GraphHelper {
	private String graphFile;
	
	public GraphHelper(String graphFile) {
		this.graphFile = graphFile;
	}
	
	public Graph getGraph() {
		Graph graph = new Graph();
		Map<Integer, List<Pair>> adjacentMatrix = graph.getAdjacentMatrix();
		try (
				InputStream inputStream = getFileFromResourceAsStream();
				InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader)) {
				String line;
				while((line = reader.readLine()) != null) {
					String[] tuples = line.split("\\s+");
					Integer vertex = Integer.parseInt(tuples[0]);
					if (!adjacentMatrix.containsKey(vertex)) {
						adjacentMatrix.put(vertex, new ArrayList<Pair>());
					}
					for (int i=1; i<tuples.length; i++) {
						String[] pairs = tuples[i].split(",");
						Integer target = Integer.parseInt(pairs[0]);
						Integer distance = Integer.parseInt(pairs[1]);
						Pair pair = new Pair(target, distance);
						adjacentMatrix.get(vertex).add(pair);
					}
				}
				
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		return graph;
	}
	
	private InputStream getFileFromResourceAsStream() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(this.graphFile);
		
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found!" + this.graphFile);
		} else {
			return inputStream;
		}
	}
}