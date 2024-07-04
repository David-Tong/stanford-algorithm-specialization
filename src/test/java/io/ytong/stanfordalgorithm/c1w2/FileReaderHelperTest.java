package io.ytong.stanfordalgorithm.c1w2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FileReaderHelperTest {
	private FileReaderHelper helper = new FileReaderHelper();
	
	@Test
	public void testGetIntegerArrayFromResourceFile() {
		int[] numbers = helper.getIntegerArrayFromResourceFile("c1w2-assignments.txt");
		assertEquals(100000, numbers.length);
	}
}
