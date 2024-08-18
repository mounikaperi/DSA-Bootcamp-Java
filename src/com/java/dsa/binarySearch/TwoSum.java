package com.java.dsa.binarySearch;
public class TwoSum {
    public static void main(String[] args) {
        // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
        int[] arr = {2, 7, 11, 15}; // one index based array
        int target = 9;
        int[] indices = twoSum(arr, target);
        System.out.println("The numbers that add up to target " +target+ " is: " + indices[0] + " and " + indices[1]);
    }
    private static int[] twoSum(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int total = arr[low] + arr[high];
            if (total == target) return new int[] {low+1, high+1};
            else if (target > total) low++;
            else high--;
        }
        return new int[] {-1, -1};
    }
}

