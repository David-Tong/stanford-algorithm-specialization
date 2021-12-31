package io.ytong.stanfordalgorithm.c1w2;

public class MergeSortAndCount {
	public long mergeSortAndCountInversions(int[] numbers) {
		return mergeSort(numbers, 0, numbers.length - 1);
	}
	
	private long mergeSort(int[] numbers, int left, int right) {
		if (left == right) {
			return 0;
		}
		
		int middle = left + (right - left) / 2;
		long ivrNum = 0;
		
		ivrNum += mergeSort(numbers, left, middle);
		ivrNum += mergeSort(numbers, middle + 1, right);
		ivrNum += mergeCount(numbers, left, right);
	
		return ivrNum;
	}
	
	private long mergeCount(int[] numbers, int left, int right) {
		int[] tmp = new int[right - left + 1];
		int middle = left + (right - left) / 2;
		
		int i = left;
		int j = middle + 1;
		int k = 0;
		
		long crossIvr = 0;
		
		while (i <= middle && j <= right) {
			if (numbers[i] <= numbers[j]) {
				tmp[k++] = numbers[i++];
			} else {
				tmp[k++] = numbers[j++];
				crossIvr += (middle - i + 1); 
			}
		}
		
		while (i <= middle) {
			tmp[k++] = numbers[i++];
		}
		
		while (j <= right) {
			tmp[k++] = numbers[j++];
		}
		
		i = left;
		k = 0;
		while (i <= right) {
			numbers[i++] = tmp[k++];
		}
 		
		return crossIvr;
	}
}
