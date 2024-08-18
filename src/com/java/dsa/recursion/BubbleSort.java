package com.java.dsa.recursion;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
	    int[] arr = {5, 4, 3, 2, 1};
		bubbleSort(arr, arr.length-1, 0);
		System.out.println("Sorted Array is: " + Arrays.toString(arr));
	}
	private static int bubbleSort(int[] arr, int i, int j) {
	    if (i==0) return 0;
	    if (j < i) {
	        if (arr[j] > arr[j+1]) {
	            int temp = arr[j];
	            arr[j] = arr[j+1];
	            arr[j+1] = temp;
	        }
	        return bubbleSort(arr, i, j+1);
	    }
	    return bubbleSort(arr, i-1, 0);
	}
}
