package io.ytong.stanfordalgorithm.c4w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TspHelper {
	public class Location {
		private double x;
		private double y;
		
		public Location(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public String toString() {
			return String.format("(%f, %f)", x, y);
		}
	}
	
	private String file;
	private int size = -1;
	private Location[] locations;
	private double[][] distances;
	
	public TspHelper(String file) {
		this.file= file;
		loadFromFile();
	}
	
	public int getSize() {
		return size;
	}
	
	public Location[] getLocations() {
		return locations;
	}
	
	public double[][] getDistances() {
		return distances;
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
						this.distances = new double[this.size][this.size];
						this.locations = new Location[this.size];
					} else {
						double x = Double.parseDouble(tuples[0]);
						double y = Double.parseDouble(tuples[1]);
						this.locations[index - 1] = new Location(x, y);
					}	
					index += 1;
				}		
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		
		if (this.size == -1 || this.locations == null || this.distances == null) {
			throw new NullPointerException();
		}
		
		for (int i=0; i<this.size; i++) {
			for (int j=0; j<this.size; j++) {
				if (i == j) {
					this.distances[i][j] = 0;
				} else {
					this.distances[i][j] = Math.sqrt(
							Math.pow(this.locations[i].x - this.locations[j].x, 2) 
							+ Math.pow(this.locations[i].y - this.locations[j].y, 2)); 
				}
			}
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
