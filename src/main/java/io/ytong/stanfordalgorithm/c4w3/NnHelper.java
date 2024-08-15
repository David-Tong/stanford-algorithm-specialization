package io.ytong.stanfordalgorithm.c4w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class NnHelper {
	
	public class Location {
		private double x;
		private double y;
		
		public Location(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double getDistance(Location other) {
			return Math.sqrt((this.x - other.x) * (this.x - other.x)
					+ (this.y - other.y) * (this.y - other.y));
		}
		
		public String toString() {
			return String.format("(%f, %f)", x, y);
		}
	}
	
	private String file;
	private int size = -1;
	private Location[] locations;

	public NnHelper(String file) {
		this.file = file;
		loadFromFile();
	}
	
	public int getSize() {
		return size;
	}
	
	public Location[] getLocations() {
		return locations;
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
						this.locations = new Location[this.size];
					} else {
						double x = Double.parseDouble(tuples[1]);
						double y = Double.parseDouble(tuples[2]);
						this.locations[index - 1] = new Location(x, y);
					}	
					index += 1;
				}		
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		
		if (this.size == -1 || this.locations == null) {
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
