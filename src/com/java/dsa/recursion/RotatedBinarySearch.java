package com.java.dsa.recursion;
import java.util.ArrayList;
public class RotatedBinarySearch {
    static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
	    int[] arr = {7, 8, 9, 10, 1, 2, 3};
	    int target = 1;
	    int index = rotatedBinarySearch(arr, target, 0, arr.length-1);
	    System.out.println("Element found at the index: " + index);
	}
	private static int rotatedBinarySearch(int[] arr, int target, int low, int high) {
	    if (low > high) return -1;
	    int mid = low + (high - low) / 2;
	    if (arr[mid] == target) return mid;
	    if (arr[low] <= arr[mid]) {
	        if (target >= arr[low] && target <= arr[mid]) 
	            return rotatedBinarySearch(arr, target, low, mid-1);
	        else 
	            return rotatedBinarySearch(arr, target, mid+1, high);
	    }
	    if (target >= arr[mid] && target <= arr[high])
	        return rotatedBinarySearch(arr, target, mid+1, high);
	    return rotatedBinarySearch(arr, target, low, mid-1);
	}
}
