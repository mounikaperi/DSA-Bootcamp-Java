package com.java.dsa.arrays;

import java.util.Arrays;

public class RunningSumOf1D {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println("Sum of previous elements of array: " + Arrays.toString(sumOf1D(nums)));
    }
    static int[] sumOf1D(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
