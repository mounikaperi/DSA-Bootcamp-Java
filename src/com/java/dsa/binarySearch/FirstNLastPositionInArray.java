package com.java.dsa.binarySearch;
public class FirstNLastPositionInArray {
	public static void main(String[] args) {
		// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
		int[] arr = {5,7,7,8,8,10};
	        int target = 8;
	        int[] searchRange = searchRange(arr, target);
	        System.out.println("First Occurrence is: " + searchRange[0] + " Last Occurrence is: " + searchRange[1]);
	}
	private static int[] searchRange(int[] arr, int target) {
	    int ans[] = {-1, -1};
	    int firstOccurrence = searchOccurrence(arr, target, true);
	    if (firstOccurrence == -1) return ans;
	    ans[0] = firstOccurrence; 
	    ans[1] = searchOccurrence(arr, target, false);
	    return ans;
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
