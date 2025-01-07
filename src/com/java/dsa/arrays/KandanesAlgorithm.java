package com.java.dsa.arrays;

public class KandanesAlgorithm {
    public static void main(String[] args) {
     // https://leetcode.com/problems/maximum-subarray/
      int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
      int sum = findMaxSubArraySumUsingBruteForce(nums);
      System.out.println("BruteForce: The maximum subarray sum is: " + sum);
      sum = findMaxSubArraySumUsingBetterApproach(nums);
      System.out.println("Better Approach: The maximum subarray sum is: " + sum);
      sum = findMaxSubArraySumUsingKandaneAlgorithm(nums);
      System.out.println("Kandane's Algo: The maximum subarray sum is: " + sum);
    }
    private static int findMaxSubArraySumUsingBruteForce(int[] nums) {
      int max = Integer.MIN_VALUE;
      for (int i=0; i<nums.length; i++) {
        for (int j=i; j<nums.length; j++) {
          int sum = 0;
          for (int k=i; k<=j; k++) {
            sum += nums[k];
          }
          max = Math.max(max, sum);
        }
      }
      return max;
    }
    private static int findMaxSubArraySumUsingBetterApproach(int[] nums) {
      int max = Integer.MIN_VALUE;
      for (int i=0; i<nums.length; i++) {
        int sum = 0;
        for (int j=i; j<nums.length; j++) {
          sum += nums[j];
          max = Math.max(max, sum);
        }
      }
      return max;
    }
    private static int findMaxSubArraySumUsingKandaneAlgorithm(int[] nums) {
      int max = Integer.MIN_VALUE;
      int sum = 0;
      for (int i=0; i<nums.length; i++) {
        sum += nums[i];
        if (sum > max) max = sum;
        if (sum < 0) sum = 0;
      }
      return max;
    }
}