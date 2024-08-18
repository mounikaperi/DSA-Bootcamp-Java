package com.java.dsa.binarySearch;
public class kthMissingNumber {
    public static void main(String[] args) {
        // https://leetcode.com/problems/kth-missing-positive-number/description/
        int[] arr = {2,3,4,7,11};
        int target = 5;
        System.out.println(target +"th missing number is: " + kthMissingNumber(arr, target));
    }
    private static int kthMissingNumber(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingCount = arr[mid] - (mid + 1);
            if (missingCount > target) low = mid + 1;
            else high = mid - 1;
        }
        return low + target;
    }       
}

