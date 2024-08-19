package com.java.dsa.sorting;
import java.util.ArrayList;
import java.util.Arrays;
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {4, 1, 3, 9, 7};
		mergeSort(arr, 0, arr.length-1);
		System.out.println("Array after sorting is: " + Arrays.toString(arr));
	}
	private static void mergeSort(int[] arr, int low, int high) {
	    if (low >= high) return;
	    int mid = low + (high - low) / 2;
	    mergeSort(arr, low, mid);
	    mergeSort(arr, mid+1, high);
	    merge(arr, low, mid, high);
	}
	private static void merge(int[] arr, int low, int mid, int high) {
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    int left = low;
	    int right = mid+1;
	    // start from left and right arrays and keep adding the number which is lesser than the other
	    while(left <= mid && right <= high) {
	        if (arr[left] <= arr[right]) {
	            temp.add(arr[left]);
	            left++;
	        } else {
	            temp.add(arr[right]);
	            right++;
	        }
	    }
	    // If elements are still present in left Array
	    while(left <= mid) {
	        temp.add(arr[left]);
	        left++;
	    }
	    while(right <= high) {
	        temp.add(arr[right]);
	        right++;
	    }
	    for (int i=low; i<=high; i++) {
	        arr[i] = temp.get(i-low);
	    }
	}
}
