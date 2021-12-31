package io.ytong.stanfordalgorithm.c1w2;

public class Main {
	public static void main(String[] args) {
		FileReaderHelper helper = new FileReaderHelper();
		MergeSortAndCount mergeSortAndCount = new MergeSortAndCount();
		
		int[] numbers = helper.getIntegerArrayFromResourceFile("c1w2-assignments.txt");
		long ivrCount = mergeSortAndCount.mergeSortAndCountInversions(numbers);
		
		System.out.println("The total inversions number is " + ivrCount);
	}
}
