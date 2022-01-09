package io.ytong.stanfordalgorithm.c1w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class InputHelper {
	public List<Edge> getEdgeListFromResourceFile(String fileName) {		
		InputStream is = getFileFromResourceAsStream(fileName);
		List<Edge> edges = parseResourceFiletoGetEdgeList(is);	
		return edges;
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
	
	private List<Edge> parseResourceFiletoGetEdgeList(InputStream is) {
		List<Edge> edges = new ArrayList<Edge>();
		try (
			InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
			BufferedReader reader = new BufferedReader(streamReader)) {
			String line;
			while((line = reader.readLine()) != null) {
				String[] points = line.split("\t");
				for (int index=1; index < points.length; index++) {
					edges.add(new Edge(points[0], points[index]));	
				}
			}
		} catch (IOException e) {
            e.printStackTrace();
        }	
		return edges;
	}
}
