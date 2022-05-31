package io.ytong.stanfordalgorithm.c2w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Helper {
	public String inputFile;
	
	public Helper(String inputFile) {
		this.inputFile = inputFile;
	}
	
	public List<Long> getInputNumbers() {
		List<Long> numbers = new ArrayList<Long>();
		try (
			InputStream inputStream = getFileFromResourceAsStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			BufferedReader reader = new BufferedReader(streamReader)) {
			String line;
			while((line = reader.readLine()) != null) {
				String[] tokens = line.split("\\s+");
				Long number = Long.parseLong(tokens[0]);
				numbers.add(number);
			}
			
		} catch (IOException e) {
	        e.printStackTrace();
	    }
		return numbers;
	}
	
	private InputStream getFileFromResourceAsStream() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(this.inputFile);
		
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found!" + this.inputFile);
		} else {
			return inputStream;
		}
	}
}
