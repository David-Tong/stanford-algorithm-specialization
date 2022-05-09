package io.ytong.stanfordalgorithm.c2w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphHelper {
	private String graphFile;
	
	public GraphHelper(String graphFile) {
		this.graphFile = graphFile;
	}
	
	public Graph getGraph() {
		Graph graph = new Graph();
		HashMap<String, List<String>> adjacentMatrix = graph.getAdjacentMatrix();
		try (
				InputStream inputStream = getFileFromResourceAsStream();
				InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader)) {
				String line;
				while((line = reader.readLine()) != null) {
					String[] vertices = line.split(" ");
					if (!adjacentMatrix.containsKey(vertices[0])) {
						adjacentMatrix.put(vertices[0], new ArrayList<String>());
					}
					adjacentMatrix.get(vertices[0]).add(vertices[1]);
				}
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		return graph;
	}
	
	public Graph getReversedGraph() {
		Graph graph = new Graph();
		HashMap<String, List<String>> adjacentMatrix = graph.getAdjacentMatrix();
		try (
				InputStream inputStream = getFileFromResourceAsStream();
				InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader)) {
				String line;
				while((line = reader.readLine()) != null) {
					String[] vertices = line.split(" ");
					if (!adjacentMatrix.containsKey(vertices[1])) {
						adjacentMatrix.put(vertices[1], new ArrayList<String>());
					}
					adjacentMatrix.get(vertices[1]).add(vertices[0]);
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
