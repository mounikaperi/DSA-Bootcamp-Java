package com.java.dsa.arrays;

import java.util.*;

public class CountSubArraySumEqualsK {
  public static void main(String[] args) {
    int[] arr = {3, 1, 2, 4};
    int k = 6;
    int cnt = findAllSubarraysWithGivenSum(arr, k);
    cnt = findAllSubarraysBetterApproach(arr, k);
    cnt = findAllSubarraysOptimal(arr, k);
    System.out.println("The number of subarrays is: " + cnt);
  }
  private static int findAllSubarraysWithGivenSum(int[] arr, int target) {
    int n = arr.length;
    int count = 0;
    for (int i=0; i<n; i++) {
      for (int j=i; j<n; j++) {
        int sum = 0;
        for (int k=i; k<=j; k++) {
          sum += arr[k];
        }
        if (sum == target) count++;
      }
    }
    return count;
  }
  private static int findAllSubarraysBetterApproach(int[] arr, int target) {
    int n = arr.length;
    int count = 0;
    for (int i=0; i<n; i++) {
      int sum = 0;
      for (int j=i; j<n; j++) {
        sum += arr[j];
        if (sum == target) count++;
      }
    }
    return count;
  }
  private static int findAllSubarraysOptimal(int[] arr, int target) {
    int n = arr.length;
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0, count = 0;
    map.put(0, 1);
    for (int i=0; i<n; i++) {
      sum += arr[i];
      int remove = sum - target;
      count += map.getOrDefault(remove, 0);
      map.put(sum, map.getOrDefault(sum , 0) + 1);
    }
    return count;
  }
  private static int findSubArraysCount(int[] arr, int k) {
    /*
        Use HashMap to store the prefix sum(sum calculated so far) of the array
        For each index i, check if (currSum-k) is present in the map
            If present, it indicates, the presence of a subarray ending at i with given sum k
            Hence, increment the count with count of (currSum-k) stored in the map

            If not present, add the currSum and respective count + 1 to map
        */
    /*
      arr[] = [10, 2, -2, -20, 10]
      1. Initialize an empty hashmap to store frequency of prefix sum values
      2. Add the current element arr[0] to the prefix sum. Check if currSum-k exists in map or not
         10 - (-10) = 20 does not exist in map- donot add to the result
      3. Add the current prefix sum and its frequency to the hashmap -> 10, 1
      4. Add the current element arr[1] to the prefix sum.
         12 - (-10) = 22 does not exist in the map - donot add to the result
      5. Add the current prefix sum and its frequency to the hashmap -> 10+2 -> 12, 1
      6. Add the current element arr[2] to the prefix sum. 10 - (-10) = 20 doesnot exist donot update the result
      7. Add the current prefix sum and its frequency to the hashmap -> 10+2-2 -> 10 update count to 2
      8. arr[3] = -10 - (-10) = 0 not present dnt update
      9. 10+(-20) = -10 add in map put frequency as 1
      10. 0 - (-10) = 10 present update freq
     */
    Map<Integer, Integer> prefixSum = new HashMap<>();
    int result = 0;
    int currSum = 0;
    for (int i=0; i<arr.length; i++) {
      currSum += arr[i];
      if (currSum == k) result++;
      if (prefixSum.containsKey(currSum-k))
          result += prefixSum.get(currSum-k);
      prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
    }
    return result;
  }
}