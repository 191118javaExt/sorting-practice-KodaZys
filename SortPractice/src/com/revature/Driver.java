package com.revature;

import java.util.Arrays;
import java.util.Random;

import com.revature.sort.BubbleSort;
import com.revature.sort.MergeSort;

public class Driver {
	
	private static final int AMOUNT = 1000;

	public static void main(String[] args) {
		int[] arr = new int[AMOUNT];
		
		Random r = new Random(System.currentTimeMillis());
		for(int i = 0; i < AMOUNT; i++) {
			arr[i] = r.nextInt(AMOUNT);
		}
		
		int[] arr2 = Arrays.copyOf(arr, AMOUNT);
		
		long t1 = System.nanoTime();
		BubbleSort.sort(arr);
		long t2 = System.nanoTime();
		
		long bubblesort = t2 - t1;

		
		t1 = System.nanoTime();
		MergeSort.sort(arr2);
		t2 = System.nanoTime();
		
		long mergesort = t2 - t1;
		
		if(Arrays.equals(arr, arr2)) {
			System.out.println("It took bubblesort algorithm " + bubblesort + " ns to sort");
			System.out.println("It took mergesort algorithm " + mergesort + " ns to sort");
		} else {
			System.out.println("Arrays are not the same.");
		}
	}
}
