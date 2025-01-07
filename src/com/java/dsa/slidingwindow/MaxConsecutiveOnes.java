package com.java.dsa.slidingwindow;

import java.util.*;

public class MaxConsecutiveOnes {
  public static void main(String[] args) {
    // https://leetcode.com/problems/max-consecutive-ones-iii/
    int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
    int k = 2;
    System.out.println("BruteForce: Max Consecutive one's: " + longestOnes(arr, k)); 
    System.out.println("SlidingWindow: Max Consecutive one's: " + longestOnesUsingSlidingWindow(arr, k));
    System.out.println("SlidingWindow Optimal: Max Consecutive one's: " + longestOnesUsingSlidingWindowOptimal(arr, k)); 
  }
  
  private static int longestOnes(int[] arr, int k) { // O(n^2)
    int maxLength = 0;
    for (int i=0; i<arr.length-1; i++) {
      int numberOfZeros = 0;
      for (int j=i; j<arr.length-1; j++) {
        if (arr[j] == 0) numberOfZeros++;
        if (numberOfZeros <= k) maxLength = Math.max(maxLength, j-i+1);
        else break;
      }
    }
    return maxLength;
  }
  private static int longestOnesUsingSlidingWindow(int[] arr, int k) {
    int maxLength = 0;
    int left = 0;
    int right = 0;
    int numberOfZeros = 0;
    while (right < arr.length) {
      if (arr[right] == 0) numberOfZeros++;
      while (numberOfZeros > k) { 
        // if zeros have crossed k then it can be a longest subarray as we can replace only k number of zeros
        // hence increment the left pointer and decrement the numberOfZeros to count for next subarray
        if (arr[left] == 0) numberOfZeros--;
        left++;
      }
      if (numberOfZeros <= k) maxLength = Math.max(maxLength, right-left+1);
      right++;
    }
    return maxLength;
  }
  private static int longestOnesUsingSlidingWindowOptimal(int[] arr, int k) {
    int left = 0;
    int right = 0;
    int maxLength = 0;
    int numberOfZeros = 0;
    while (right < arr.length) {
      if (arr[right] == 0) numberOfZeros++;
      if (numberOfZeros > k) {
        if (arr[left] == 0) numberOfZeros--;
        left++;
      }
      if (numberOfZeros <= k) maxLength = Math.max(maxLength, right-left+1);
      right++;
    }
    return maxLength;
  }
}