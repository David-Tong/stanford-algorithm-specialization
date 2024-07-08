package io.ytong.stanfordalgorithm.c3w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ClusteringBigHelper {
	private String clusteringBigFile;
	private int claimNumber;
	private int vertexNumber;
	private Map<String, Integer> vertices;
	
	public ClusteringBigHelper(String clusteringBigFile) {
		this.clusteringBigFile = clusteringBigFile;
		this.vertices = new HashMap<String, Integer>();
		loadFromFile();
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
						this.claimNumber = Integer.parseInt(tuples[0]);
					} else {
						String vertex = String.join("", tuples);
						this.vertices.put(vertex, index - 1);
					}	
					index += 1;
				}		
				this.vertexNumber = this.vertices.size();
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		
		if (this.vertices == null) {
			throw new NullPointerException();
		}
	}
	
	public Map<String, Integer> getVertices(){
		return this.vertices;
	}
	
	public int getVertexNumber() {
		return this.vertexNumber;
	}
	
	public int getClaimNumber() {
		return this.claimNumber;
	}
	
	private InputStream getFileFromResourceAsStream() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(this.clusteringBigFile);
		
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found!" + this.clusteringBigFile);
		} else {
			return inputStream;
		}
	}
}
