package com.java.dsa.hashing;

import java.util.Arrays;
import java.util.HashMap;
public class TwoSum {
	public static void main(String[] args) {
		// https://www.geeksforgeeks.org/batch/gfg-160-problems/track/hashing-gfg-160/article/NDg0
		int[] arr = {2,6,5,8,11};
		int target = 14;
		System.out.println("The indices at which elements sum up to target is: " + Arrays.toString(twoSum(arr, target)));
		System.out.println("The indices at which elements sum up to target is: " + Arrays.toString(twoSumViaHashing(arr, target)));
		System.out.println(twoSumViaBinarySearch(arr, target));
	}
	private static int[] twoSum(int[] arr, int target) {
	    int[] ans = new int[2];
	    ans[0] = ans[1] = -1;
	    for (int i=0; i<arr.length; i++) {
	        for (int j=i+1; j<arr.length; j++) {
	            if (arr[i] + arr[j] == target) {
	                ans[0] = i;
	                ans[1] = j;
	                return ans;
	            }
	        }
	    }
	    return ans;
	}
	private static int[] twoSumViaHashing(int[] arr, int target) {
	    int[] ans = new int[2];
	    ans[0] = ans[1] = -1;
	    HashMap<Integer, Integer> map = new HashMap<>();
	    for (int i=0; i<arr.length; i++) {
	        int numNeeded = target - arr[i];
	        if (map.containsKey(numNeeded)) {
	            ans[0] = map.get(numNeeded);
	            ans[1] = i;
	        }
	        map.put(arr[i], i);
	    }
	    return ans;
	}
	private static boolean twoSumViaBinarySearch(int[] arr, int target) {
		Arrays.sort(arr);
		for (int i=0; i<arr.length; i++) {
			int complement = target - arr[i];
			if (binarySearch(arr, i+1, arr.length-1, complement)) return true;
		}
		return false;
	}
	static boolean binarySearch(int[] arr, int left, int right, int target) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) return true;
			else if (target > arr[mid]) left = mid + 1;
			else right = mid - 1;
		}
		return false;
	}
}
