package io.ytong.standfordalgorithm.c1w2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class FileReaderHelperTest {
	private FileReaderHelper helper = new FileReaderHelper();
	
	@Test
	public void testGetIntegerArrayFromResourceFile() {
		int[] integers = helper.getIntegerArrayFromResourceFile("IntegerArray.txt");
		assertEquals(100000, integers.length);
	}
}
