package io.ytong.stanfordalgorithm.c1w4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import io.ytong.stanfordalgorithm.c1w4.InputHelper;

public class InputHelperTest {
private InputHelper helper = new InputHelper();
	
	@Test
	public void testGetIntegerArrayFromResourceFile() {
		List<Edge> edges = helper.getEdgeListFromResourceFile("c1w4-assignments.txt");
		Set<String> vertexs = new HashSet<String>();
		for (Edge edge: edges) {
			vertexs.add(edge.getStartVertex());
			vertexs.add(edge.getEndVertex());
		}	
		assertEquals(200, vertexs.size());
	}
}
