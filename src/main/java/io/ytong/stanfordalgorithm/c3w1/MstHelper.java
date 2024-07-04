package io.ytong.stanfordalgorithm.c3w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MstHelper {
	private String graphFile;
	
	public MstHelper(String graphFile) {
		this.graphFile = graphFile;
	}
	
	public Graph getGraph() {
		Graph graph = null;
		try (
			InputStream inputStream = getFileFromResourceAsStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			BufferedReader reader = new BufferedReader(streamReader)) {
				String line;
				int index = 0;
				while((line = reader.readLine()) != null) {
					String[] tuples = line.split("\\s+");
					if (index == 0) {
						Integer nodeNumber = Integer.parseInt(tuples[0]);
						graph = new Graph(nodeNumber);
					} else {
						Integer source = Integer.parseInt(tuples[0]);
						Integer target = Integer.parseInt(tuples[1]);
						Integer cost = Integer.parseInt(tuples[2]);
						graph.setCost(source, target, cost);
						graph.setCost(target, source, cost);
					}
					index += 1;
				}		
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		
		if (graph == null) {
			throw new NullPointerException();
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
