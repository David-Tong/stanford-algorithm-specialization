package io.ytong.stanfordalgorithm.c1w2;

public class Main {
	public static void main(String[] args) {
		FileReaderHelper helper = new FileReaderHelper();
		MergeSortAndCount mergeSortAndCount = new MergeSortAndCount();
		
		int[] integers = helper.getIntegerArrayFromResourceFile("IntegerArray.txt");
		long ivrCount = mergeSortAndCount.mergeSortAndCountInversions(integers);
		
		System.out.println("The total inversions number is " + ivrCount);
	}
}
