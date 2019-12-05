package com.revature.sort;

public class MergeSort {
	
	// O(n log n) comparison-based sorting algorithm
	// **** Divide and Conquer ****
	// find middle --> split into left and right parts --> RECURSIVELY SPLIT!
	// merge back together

	public static void sort(int[] arr) {
		
		int n = arr.length;
		if(n < 2) {
			return;
		}
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		
		// pop l
		for(int i=0; i<mid; i++) {
			left[i] = arr[i];
		}
		// pop r
		for(int i=0; i<right.length; i++) {
			right[i] = arr[n/2 + i];
		}
		
		sort(left);
		sort(right);
		//invoke private merge method
		merge(arr, left, right);
	}
	
	private static void merge(int[] arr, int[] left, int[] right) {
		
		int i = 0;
		int j = 0;
		int n = arr.length;
		
		for(int k=0; k<n; k++) {
			
			if  (i >= left.length) {
				arr[k] = right[j++];
			} else if (j >= right.length || left[i] <= right[j]) {
				arr[k] = left[i++]; 
			} else {
				arr[k] = right[j++];
			}
		}
	}
}
