package io.ytong.stanfordalgorithm.c1w1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
	private Solution solution = new Solution();
	
	@Test
	public void testMultiply() {
		try {
			assertEquals("408", solution.multiply("12","34"));
			assertEquals("42685751946", solution.multiply("345698","123477"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
