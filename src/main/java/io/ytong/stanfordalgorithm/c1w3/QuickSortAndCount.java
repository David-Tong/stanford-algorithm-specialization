package io.ytong.stanfordalgorithm.c1w3;

public class QuickSortAndCount {
	
	private PartitionStrategy strategy;
	
	public enum PartitionStrategy {
		FIRST,
		LAST,
		MEDIAN,
	}

	public QuickSortAndCount(PartitionStrategy strategy) {
		this.strategy = strategy;
	}
	
	public long quickSortAndCountComparisons(int[] numbers) {
		return quickSort(numbers, 0, numbers.length - 1);
	}
	
	private long quickSort(int[] numbers, int left, int right) {
		if (left >= right) {
			return 0;
		} else {
			long count = right - left;
			int pvtIndex = partition(numbers, left, right);
			count += quickSort(numbers, left, pvtIndex - 1);
			count += quickSort(numbers, pvtIndex + 1, right);
			return count;
		}
	}
	
	private int partition(int[] numbers, int left, int right) {
		if (this.strategy == PartitionStrategy.FIRST) {
			
		} else if (this.strategy == PartitionStrategy.LAST) {
			swapNumbers(numbers, left, right);
		} else if (this.strategy == PartitionStrategy.MEDIAN) {
			int middle = left + (right - left) / 2;
			int median = findMedian(numbers, left, right, middle);
			swapNumbers(numbers, left, median);
		}
		
		int pivot = numbers[left];
		int i = left + 1;
		int j = left + 1;
		while (i <= right) {
			if (numbers[i] > pivot) {
				i++;
			} else {
				swapNumbers(numbers, i, j);
				i++;
				j++;
			}
		}
		swapNumbers(numbers, left, j - 1);
		return j - 1;
	}

	private void swapNumbers(int[] numbers, int i, int j) {
		int tmp = 0;
		tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
	
	private int findMedian(int[] numbers, int left, int right, int middle) {
		if (numbers[left] < numbers[middle]) {
			if (numbers[middle] < numbers[right]) {
				return middle;
			} else if (numbers[left] < numbers[right]){
				return right;
			} else {
				return left;
			}
		} else {
			if (numbers[left] < numbers[right]) {
				return left;
			} else if (numbers[right] > numbers[middle]) {
				return right;
			} else {
				return middle;
			}
		}
	}
}
