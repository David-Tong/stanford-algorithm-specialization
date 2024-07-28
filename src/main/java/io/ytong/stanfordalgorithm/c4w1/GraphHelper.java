package io.ytong.stanfordalgorithm.c4w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GraphHelper {
	
	private String file;
	private int graphSize = -1;
	private int[][] adjacencyMatrix;
	
	public GraphHelper(String file) {
		this.file = file;
		loadFromFile();
	}

	public int getGraphSize() {
		return graphSize;
	}

	public void setGraphSize(int graphSize) {
		this.graphSize = graphSize;
	}

	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
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
						this.graphSize = Integer.parseInt(tuples[0]);
						this.adjacencyMatrix = new int[this.graphSize][this.graphSize];
						// initialize adjacencyMatrix
						for (int i=0; i<this.graphSize; i++) {
							for (int j=0; j<this.graphSize; j++) {
								if (i != j) {
									this.adjacencyMatrix[i][j] = Integer.MAX_VALUE;
								}
							}
						}
					} else {
						Integer to = Integer.parseInt(tuples[0]);
						Integer from = Integer.parseInt(tuples[1]);
						Integer weight = Integer.parseInt(tuples[2]);
						this.adjacencyMatrix[from - 1][to - 1] = weight;
					}	
					index += 1;
				}		
		} catch (IOException e) {
	        e.printStackTrace();
	    }
			
		if (this.graphSize == -1 || this.adjacencyMatrix == null) {
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
