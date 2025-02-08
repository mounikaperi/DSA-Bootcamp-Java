package com.java.dsa.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(longestSubArraySumNaive(arr, k));
        System.out.println(longestSubArraySum(arr, k));
    }
    static int longestSubArraySumNaive(int[] arr, int k) {
        int result = 0;
        for (int i=0; i<arr.length; i++) {
            int sum = 0;
            for (int j=i; j<arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    int subLength = j-i+1;
                    result = Math.max(result, subLength);
                }
            }
        }
        return result;
    }
    static int longestSubArraySum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int prefixSum = 0;
        for (int i=0; i<arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == k)
                result = i+1;
            else if (map.containsKey(prefixSum-k))
                result = Math.max(result, i-map.get(prefixSum-k));
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);
        }
        return result;
    }
}