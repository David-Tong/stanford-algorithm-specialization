package io.ytong.stanfordalgorithm.c3w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MWISHelper {
	
	private String file;
	private int vertexNumber;
	private int[] weights;
	
	public MWISHelper(String file) {
		this.file = file;
		loadFromFile();
	}
	
	public int[] getWeights() {
		return this.weights;
	}

	public int getVertexNumber() {
		return this.vertexNumber;
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
						this.weights = new int[vertexNumber];
					} else {
						Integer weight = Integer.parseInt(tuples[0]);
						this.weights[index - 1] = weight;
					}	
					index += 1;
				}		
		} catch (IOException e) {
	        e.printStackTrace();
	    }
			
		if (this.weights == null) {
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
