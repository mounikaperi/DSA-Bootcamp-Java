package com.java.dsa.arrays;

import java.util.Arrays;

public class ConcatenationOfTwoArrays {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println("Concatenated Arrays bruteForce1 Approach: " + Arrays.toString(concatenateArraysBruteForce1(nums)));
        System.out.println("Concatenated Arrays bruteForce2 Approach: " + Arrays.toString(concatenateArraysBruteForce2(nums)));
    }
    static int[] concatenateArraysBruteForce1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n*2];
        for (int i=0; i<n; i++) {
            result[i] = nums[i];
            result[i+n] = nums[i];
        }
        return result;
    }
    static int[] concatenateArraysBruteForce2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n*2];
        System.arraycopy(nums, 0, result, 0, n);
        System.arraycopy(nums, 0, result, n, n);
        return result;
    }
}
