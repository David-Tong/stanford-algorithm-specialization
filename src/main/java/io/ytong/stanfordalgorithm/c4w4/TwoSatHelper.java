package io.ytong.stanfordalgorithm.c4w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSatHelper {
	
	private String file;
	private int size = -1;
	private Map<Integer, List<Integer>> graph = null;

	public TwoSatHelper(String file) {
		this.file = file;
		loadFromFile();
	}
	
	public int getSize() {
		return size;
	}
	
	public Map<Integer, List<Integer>> getGraph() {
		return graph;
	}
	
	
	private void loadFromFile() {
		try (
			InputStream inputStream = getFileFromResourceAsStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			BufferedReader reader = new BufferedReader(streamReader)) {
				String line;
				int index = 0;
				while((line = reader.readLine()) != null) {
					String[] tuples = line.split("\\s+");
					if (index == 0) {
						this.size = Integer.parseInt(tuples[0]);
						this.graph = new HashMap<Integer, List<Integer>>();
					} else {
						// parse A V B
						int A = Integer.parseInt(tuples[0]);
						int B = Integer.parseInt(tuples[1]);
						
						// implication one ^A => B
						if (!graph.containsKey(-1 * A)) {
							graph.put(-1 * A, new ArrayList<Integer>());
						} 
						graph.get(-1 * A).add(B);
						
						// implication two ^B => A
						if (!graph.containsKey(-1 * B)) {
							graph.put(-1 * B, new ArrayList<Integer>());
						}
						graph.get(-1 * B).add(A);
					}	
					index += 1;
				}		
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		
		if (this.size == -1 || this.graph == null) {
			throw new NullPointerException();
		}
	}
	
	private InputStream getFileFromResourceAsStream() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(this.file);
		
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found!" + this.file);
		} else {
			return inputStream;
		}
	}
	
}
