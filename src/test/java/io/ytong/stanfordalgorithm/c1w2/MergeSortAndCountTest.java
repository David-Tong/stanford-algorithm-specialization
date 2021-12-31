package io.ytong.stanfordalgorithm.c1w2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import io.ytong.stanfordalgorithm.c1w2.MergeSortAndCount;

public class MergeSortAndCountTest {
	private MergeSortAndCount mergeSortAndCount = new MergeSortAndCount();
	
	@Test
	public void testMergeSortAndCountInversions() {
		int[] integers = {2, 4, 1, 3, 5};
		long ivrCount = mergeSortAndCount.mergeSortAndCountInversions(integers);
		assertEquals(3, ivrCount);
	}
}
