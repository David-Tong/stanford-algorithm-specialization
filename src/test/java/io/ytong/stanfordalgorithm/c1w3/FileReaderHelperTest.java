package io.ytong.stanfordalgorithm.c1w3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FileReaderHelperTest {
	private FileReaderHelper helper = new FileReaderHelper();
	
	@Test
	public void testGetIntegerArrayFromResourceFile() {
		int[] numbers = helper.getIntegerArrayFromResourceFile("c1w3-assignments.txt");
		assertEquals(10000, numbers.length);
	}
}
