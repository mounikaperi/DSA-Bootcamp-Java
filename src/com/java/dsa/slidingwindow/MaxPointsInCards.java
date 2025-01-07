package com.java.dsa.slidingwindow;

import java.util.*;

public class MaxPointsInCards {
  public static void main(String[] args) {
    // https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
    int[] arr = {1,2,3,4,5,6,1};
    int k = 3;
    System.out.println("Maximum score from cards is: " + maxPointsInCards(arr, k));
  }
  private static int maxPointsInCards(int[] arr, int k) {
    int leftSum = 0;
    int rightSum = 0;
    int maxSum = 0;
    // Initially, take all the k elements from the left window and calculate sum
    for (int i=0; i<=(k-1); i++) {
      leftSum += arr[i];
    }
    maxSum = leftSum;
    int rightIndex = arr.length -1;
    // now shrink the left window by (k-1) and take window length as 1 from right and calculate the sum
    // first pass: k-1 is removed from left and 1 place from rightIndex
    // second pass: k-2 is removed from left and 2 places from rightIndex and so on....
    for (int i=(k-1); i>=0; i--) { 
      leftSum -= arr[i];
      rightSum += arr[rightIndex];
      rightIndex--;
      maxSum = Math.max(maxSum, leftSum + rightSum);
    }
    return maxSum;
  }
}