package io.ytong.stanfordalgorithm.c1w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileReaderHelper {
	private int ARRAY_LENGTH = 10000;
	
	public int[] getIntegerArrayFromResourceFile(String fileName) {
		int[] numbers;
		
		InputStream is = getFileFromResourceAsStream(fileName);
		numbers = parseResourceFiletoGetIntegerArray(is);
		
		for (int i=0; i<ARRAY_LENGTH; i++) {
			//System.out.println(integers[i]);
		}
		
		return numbers;
	}

	private InputStream getFileFromResourceAsStream(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(fileName);
		
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found!" + fileName);
		} else {
			return inputStream;
		}
	}
	
	private int[] parseResourceFiletoGetIntegerArray(InputStream is) {
		int[] numbers = new int[ARRAY_LENGTH];
		try (
			InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
			BufferedReader reader = new BufferedReader(streamReader)) {
			String line;
			int count = 0;
			while((line = reader.readLine()) != null) {
				numbers[count] = Integer.parseInt(line);
				count++;
			}
		} catch (IOException e) {
            e.printStackTrace();
        }	
		return numbers;
	}
}
