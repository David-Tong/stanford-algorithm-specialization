package io.ytong.standfordalgorithm.c1w2;

public class MergeSortAndCount {
	public long mergeSortAndCountInversions(int[] integers) {
		return mergeSort(integers, 0, integers.length - 1);
	}
	
	private long mergeSort(int[] integers, int left, int right) {
		if (left == right) {
			return 0;
		}
		
		int middle = left + (right - left) / 2;
		long ivrNum = 0;
		
		ivrNum += mergeSort(integers, left, middle);
		ivrNum += mergeSort(integers, middle + 1, right);
		ivrNum += mergeCount(integers, left, right);
	
		return ivrNum;
	}
	
	private long mergeCount(int[] integers, int left, int right) {
		int[] tmp = new int[right - left + 1];
		int middle = left + (right - left) / 2;
		
		int i = left;
		int j = middle + 1;
		int k = 0;
		
		long crossIvr = 0;
		
		while (i <= middle && j <= right) {
			if (integers[i] <= integers[j]) {
				tmp[k++] = integers[i++];
			} else {
				tmp[k++] = integers[j++];
				crossIvr += (middle - i + 1); 
			}
		}
		
		while (i <= middle) {
			tmp[k++] = integers[i++];
		}
		
		while (j <= right) {
			tmp[k++] = integers[j++];
		}
		
		i = left;
		k = 0;
		while (i <= right) {
			integers[i++] = tmp[k++];
		}
 		
		return crossIvr;
	}
}
