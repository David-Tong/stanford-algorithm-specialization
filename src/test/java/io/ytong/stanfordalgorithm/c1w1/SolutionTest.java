package io.ytong.stanfordalgorithm.c1w1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SolutionTest {
	private Solution solution = new Solution();
	private Solution2 solution2 = new Solution2();
	
	@Test
	public void testMultiply() {
		try {
			assertEquals("408", solution.multiply("12","34"));
			assertEquals("42685751946", solution.multiply("345698","123477"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMultiply2() {
		assertEquals("408", solution2.multiply("12","34"));
		assertEquals("42435", solution2.multiply("345","123"));
		assertEquals("42685751946", solution2.multiply("345698","123477"));
	}
}
