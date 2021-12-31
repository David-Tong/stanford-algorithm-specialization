package io.ytong.stanfordalgorithm.c1w3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class QuickSortAndCountTest {
	private QuickSortAndCount quickSortAndCount = new QuickSortAndCount(
			QuickSortAndCount.PartitionStrategy.FIRST);
	
	@Test
	public void testQuickSortAndCountComparisons() {
		int[] numbers = {2, 4, 1, 3, 5};
		long comparisonCount = quickSortAndCount.quickSortAndCountComparisons(numbers);
		System.out.println(Arrays.toString(numbers));
		assertEquals(6, comparisonCount);
	}
}
