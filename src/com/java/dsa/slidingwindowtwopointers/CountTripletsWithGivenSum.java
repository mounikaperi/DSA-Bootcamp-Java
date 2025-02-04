package com.java.dsa.slidingwindowtwopointers;

import java.util.HashMap;
import java.util.Map;

public class CountTripletsWithGivenSum {
     /*
     Given a sorted array arr[] and a target value,
     the task is to count triplets (i, j, k) of valid indices,
     such that arr[i] + arr[j] + arr[k] = target and i < j < k.
      */
     public static void main(String[] args) {
         int[] arr = {-3, -1, -1, 0, 1, 2};
         int target = -2;

         System.out.println(countTripletsNaive(arr, target));
         System.out.println(countTripletsHashMap(arr, target));
         System.out.println(countTripletsTwoPointers(arr, target));
     }
     static int countTripletsNaive(int[] arr, int target) {
        int count = 0;
        for (int i=0; i<arr.length-2; i++) {
            for (int j=i+1; j<arr.length-1; j++) {
                for (int k=j+1; k<arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        count++;
                    }
                }
            }
        }
        return count;
     }
     static int countTripletsHashMap(int[] arr, int target) {
         int count = 0;
         for (int i=0; i<arr.length-2; i++) {
             int remainingSum = target-arr[i];
             count += getPairsCount(arr, i+1, remainingSum);
         }
         return count;
     }
     static int getPairsCount(int[] arr, int index, int target) {
         int count = 0;
         Map<Integer, Integer> map = new HashMap<>();
         for (int i=index; i<arr.length; i++) {
             int remainingSum = target - arr[i];
             if (map.containsKey(remainingSum)) {
                 count += map.get(remainingSum);
             }
             map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
         }
         return count;
     }
     static int countTripletsTwoPointers(int[] arr, int target) {
         int count = 0;
         for (int i=0; i<arr.length-2; i++) {
             int left = i+1, right = arr.length-1;
             while (left < right) {
                 int sum = arr[i] + arr[left] + arr[right];
                 if (sum > target) right--;
                 else if (sum < target) left++;
                 else {
                     int count1=0, count2=0, element1=arr[left], element2=arr[right];
                     while (left <= right && element1 == arr[left]) {
                         left++;
                         count1++;
                     }
                     while (left <= right && element2 == arr[right]) {
                         right--;
                         count2++;
                     }
                     if (element1 == element2)
                         count += (count1 * (count1 - 1) / 2);
                     else
                         count += (count1 * count2);
                 }
             }
         }
         return count;
     }
}
