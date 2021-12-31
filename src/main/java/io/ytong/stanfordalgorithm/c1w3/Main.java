package io.ytong.stanfordalgorithm.c1w3;

//import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		FileReaderHelper helper = new FileReaderHelper();	
		
		// partition strategy for first
		int[] numbers = helper.getIntegerArrayFromResourceFile("c1w3-assignments.txt");
		QuickSortAndCount.PartitionStrategy strategy = QuickSortAndCount.PartitionStrategy.FIRST;
		QuickSortAndCount quickSortAndCount = new QuickSortAndCount(strategy);
		long cmpCount = quickSortAndCount.quickSortAndCountComparisons(numbers);
		
		String caption = "[" + strategy.toString() + "]    ";
		System.out.println(caption + "The total comparison number is " + cmpCount);
		//System.out.println(Arrays.toString(numbers));
		
		// partition strategy for last
		numbers = helper.getIntegerArrayFromResourceFile("c1w3-assignments.txt");
		strategy = QuickSortAndCount.PartitionStrategy.LAST;
		quickSortAndCount = new QuickSortAndCount(strategy);
		cmpCount = quickSortAndCount.quickSortAndCountComparisons(numbers);
		
		caption = "[" + strategy.toString() + "]    ";
		System.out.println(caption + "The total comparison number is " + cmpCount);
		//System.out.println(Arrays.toString(numbers));
		
		// partition strategy for median
		numbers = helper.getIntegerArrayFromResourceFile("c1w3-assignments.txt");
		strategy = QuickSortAndCount.PartitionStrategy.MEDIAN;
		quickSortAndCount = new QuickSortAndCount(strategy);
		cmpCount = quickSortAndCount.quickSortAndCountComparisons(numbers);
				
		caption = "[" + strategy.toString() + "]    ";
		System.out.println(caption + "The total comparison number is " + cmpCount);
		//System.out.println(Arrays.toString(numbers));
	}
}
