package io.ytong.stanfordalgorithm.c1w1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HelperTest {
	private Helper helper = new Helper();
	
	@Test
	public void testStringAdd() {
		assertEquals("46", helper.stringAdd("12", "34"));
		assertEquals("215", helper.stringAdd("123", "92"));
		assertEquals("10000", helper.stringAdd("1", "9999"));
	}

	@Test
	public void testStringMultiply() {
		try {
			assertEquals("198", helper.stringMultiply("9", "22"));
			assertEquals("8991", helper.stringMultiply("9", "999"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
