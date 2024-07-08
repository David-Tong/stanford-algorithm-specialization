package io.ytong.stanfordalgorithm.c3w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ClusteringHelper {
	private String clusteringFile;
	private int vertexNumber;
	private Cost[] costs;
	private int[][] costMatrix;
	
	public ClusteringHelper(String clusteringFile) {
		this.clusteringFile = clusteringFile;
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
						this.vertexNumber = Integer.parseInt(tuples[0]);
						int costNumber = (vertexNumber * (vertexNumber - 1)) / 2;
						this.costs = new Cost[costNumber];
						this.costMatrix = new int[vertexNumber][vertexNumber];
					} else {
						Integer source = Integer.parseInt(tuples[0]);
						Integer target = Integer.parseInt(tuples[1]);
						Integer cost = Integer.parseInt(tuples[2]);
						this.costs[index - 1] = new Cost(source - 1, target - 1, cost);
						this.costMatrix[source - 1][target - 1] = cost;
						this.costMatrix[target - 1][source - 1] = cost;
					}	
					index += 1;
				}		
		} catch (IOException e) {
	        e.printStackTrace();
	    }
			
		if (this.costs == null || this.costMatrix == null) {
			throw new NullPointerException();
		}
	}
	
	private InputStream getFileFromResourceAsStream() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(this.clusteringFile);
		
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found!" + this.clusteringFile);
		} else {
			return inputStream;
		}
	}
	
	public int getVertexNumber() {
		return this.vertexNumber;
	}
	
	public Cost[] getCosts() {
		return this.costs;
	}
	
	public int[][] getCostMatrix() {
		return this.costMatrix;
	}
}
