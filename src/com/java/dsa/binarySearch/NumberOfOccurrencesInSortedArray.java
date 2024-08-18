package com.java.dsa.binarySearch;
public class NumberOfOccurrencesInSortedArray {
	public static void main(String[] args) {
	    // https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-occurrence
		int[] arr = {1,1,2,2,2,2,3};
        int target = 2;
        System.out.println("Number of occurrences is: " + noOfOccurrences(arr, target));
	}
	private static int noOfOccurrences(int[] arr, int x) {
        int firstOccurrence = searchOccurrence(arr, x, true);
        if (firstOccurrence == -1) return 0;
        int secondOccurrence = searchOccurrence(arr, x, false);
        return (secondOccurrence-firstOccurrence+1);
    }
    private static int searchOccurrence(int[] arr, int target, boolean isFirstOccurrence) {
	    int low = 0;
	    int high = arr.length - 1;
	    int ans = -1;
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        if (target == arr[mid]) {
	            ans = mid;
	            if (isFirstOccurrence) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        } else if (target > arr[mid]) low = mid + 1;
	        else high = mid - 1;
	    }
	    return ans;
	}
}
