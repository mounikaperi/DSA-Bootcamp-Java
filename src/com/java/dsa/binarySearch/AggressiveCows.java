package com.java.dsa.binarySearch;

import java.util.Arrays;
public class AggressiveCows {
	public static void main(String[] args) {
	    // https://www.geeksforgeeks.org/problems/aggressive-cows/1
	    // https://www.naukri.com/code360/problems/aggressive-cows_1082559?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse
	    int[] arr = {1, 2, 4, 8, 9};
	    int n = 5;
	    int k = 3;
		System.out.println("The minimum distance between cows is: " + aggressiveCows(arr, n, k));
	}
	private static int aggressiveCows(int[] arr, int n, int k) {
	    Arrays.sort(arr);
	    int low = 1;
	    int high = arr[arr.length-1] - arr[0];
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        if (canCowBePlaced(arr, mid, k)) 
	            low = mid + 1;
	        else 
	            high = mid - 1;
	    }
	    return high;
	}
	private static boolean canCowBePlaced(int[] arr, int distance, int cows) {
	    int countOfCows = 1;
	    int lastCow = arr[0];
	    for (int i = 0; i<arr.length; i++) {
	        if (arr[i] - lastCow >= distance) {
	            lastCow = arr[i];
	            countOfCows++;
	        }
	        if (countOfCows >= cows) 
	            return true;
	    }
	    return false;
	}
}
