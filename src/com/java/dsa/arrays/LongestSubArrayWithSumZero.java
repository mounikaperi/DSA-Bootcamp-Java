package com.java.dsa.arrays;

import java.util.*;

public class LongestSubArrayWithSumZero {
    public static void main(String[] args) {
      int[] arr = {9, -3, 3, -1, 6, -5};
      System.out.println("Length of longest subarray BruteForce: " + getLongestSubArrayLengthWithSum0(arr));
      System.out.println("Length of longest subarray Optimal: " + getLongestSubArrayLength(arr));
    }
    private static int getLongestSubArrayLengthWithSum0(int[] arr) {
      int max = 0;
      for (int i=0; i<arr.length; i++) {
        int sum = 0;
        for (int j=i; j<arr.length; j++) {
          sum += arr[j];
          if (sum == 0)
            max = Math.max(max, j-i+1);
        }
      }
      return max;
    }
    private static int getLongestSubArrayLength(int[] arr) {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      int maxLength = 0;
      int sum = 0;
      for (int i=0; i<arr.length; i++) {
        sum += arr[i];
        if (sum == 0) {
          maxLength = i+1;
        } else {
          if (map.get(sum) != null)
            maxLength = Math.max(maxLength, i-map.get(sum));
          else
            map.put(sum, i);
        }
      }
      return maxLength;
    }
}