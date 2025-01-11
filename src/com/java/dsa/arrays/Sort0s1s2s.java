package com.java.dsa.arrays;

import java.util.Arrays;
import java.util.ArrayList;
public class Sort0s1s2s {
	public static void main(String[] args) {
		int n = 6;
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] {0,2,1,2,0,1}));
		System.out.println("Before sorting:");
		for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
		sortArray(arr, n);
		System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
		int[] arr1 = { 0, 1, 2, 0, 1, 2 };
		sortArray1(arr1);
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
	private static void sortArray(ArrayList<Integer> arr, int n) {
		// DutchNationalFlagAlgorithm

		/*
		The problem is similar to "Segregate 0s and 1s in an array". The idea is to sort the array of size n using three pointers: lo = 0, mid = 0 and hi = n - 1 such that the array is divided into three parts -

		arr[0] to arr[lo - 1]: This part will have all the zeros.
		arr[lo] to arr[mid - 1]: This part will have all the ones.
		arr[hi + 1] to arr[n - 1]: This part will have all the twos.
		Here, lo indicates the position where next 0 should be placed, mid is used to traverse through the array and hi indicates the position where next 2 should be placed.

		Traverse over the array till mid <= hi, according to the value of arr[mid] we can have three cases:

		arr[mid] = 0, then swap arr[lo] and arr[mid] and increment lo by 1 because all the zeros are till index lo - 1 and move to the next element so increment mid by 1.
		arr[mid] = 1, then move to the next element so increment mid by 1.
		arr[mid] = 2, then swap arr[mid] and arr[hi] and decrement hi by 1 because all the twos are from index hi + 1 to n - 1. Now, we don't move to the next element because the element which is now at index mid can be a 0 and therefore needs to be checked again.
		 */
	    int low = 0; 
	    int high = n-1;
	    int mid = 0;
	    while (mid <= high) {
	        if (arr.get(mid) == 0) {
	            swap(arr, low, mid);
	            low++;
	            mid++;
	        } else if (arr.get(mid)==1){
	            mid++;
	        } else {
	            swap(arr, mid, high);
	            high--;
	        }
	    }
	}
	private static void swap(ArrayList<Integer> arr, int start, int end) {
	    int temp = arr.get(start);
	    arr.set(start, arr.get(end));
	    arr.set(end, temp);
	}
	private static void sortArray1(int[] arr) {
		int n = arr.length;
		int c0=0, c1=0, c2=0;
		for (int i=0; i<n; i++) {
			if (arr[i] == 0) c0 +=1;
			else if (arr[i] == 1) c1 +=1;
			else c2+=1;
		}
		int index=0;
		for (int i=0; i<c0; i++) arr[index++] = 0;
		for (int i=0; i<c1; i++) arr[index++] = 1;
		for (int i=0; i<c2; i++) arr[index++] = 2;
	}
}
