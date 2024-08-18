package com.java.dsa.arrays;

import java.util.*;

class RunningSumOf1D {
    public static void main(String[] args) {
        // https://leetcode.com/problems/running-sum-of-1d-array/description/
        int[] arr = {1, 2, 3, 4};
        System.out.println("Smaller elements in array for each element: " + Arrays.toString(runningSum(arr)));
    }
    public static int[] runningSum(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
