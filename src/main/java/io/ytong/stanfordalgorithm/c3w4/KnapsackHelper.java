package io.ytong.stanfordalgorithm.c3w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class KnapsackHelper {
	
	private String file;
	private int knapsackSize = -1;
	private int itemSize = -1;
	private Item[] items;
	
	public KnapsackHelper(String file) {
		this.file = file;
		loadFromFile();
	}
	
	public int getKnapsackSize() {
		return this.knapsackSize;
	}
	
	public int getItemSize() {
		return this.itemSize;
	}
	
	public Item[] getItems() {
		return this.items;
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
						this.knapsackSize = Integer.parseInt(tuples[0]);
						this.itemSize = Integer.parseInt(tuples[1]);
						this.items = new Item[itemSize];
					} else {
						Integer value = Integer.parseInt(tuples[0]);
						Integer weight = Integer.parseInt(tuples[1]);
						this.items[index - 1] = new Item(value, weight);
					}	
					index += 1;
				}		
		} catch (IOException e) {
	        e.printStackTrace();
	    }
			
		if (this.knapsackSize == -1 || this.itemSize == -1 || this.items == null) {
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
