package com.java.dsa.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEqualNumberOf0s1s {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 1, 1};
        System.out.println(maxLengthNaive(arr));
        System.out.println(maxLength(arr));
    }
    static int maxLengthNaive(int[] arr) {
        /*
        A simple approach is to generate all possible subarrays and check whether
        the subarray has equal number of 0s and 1s or not. To make this process
        easy we find cumulative sum of the subarrays taking 0s as -1 and 1s as +1.
        If the cumulative sum is equal to 0 for any subarray then update the
        current maximum length with the maximum of length of current subarray and
        its own value.
         */
        int result = 0;
        for (int i=0; i<arr.length; i++) {
            int sum = 0;
            for (int j=i; j<arr.length; j++) {
                sum += (arr[j] == 0) ? -1: 1;
                if (sum == 0)
                    result = Math.max(result, j-i+1);
            }
        }
        return result;
    }
    static int maxLength(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, result = 0;
        for (int i=0; i<arr.length; i++) {
            prefixSum += (arr[i] == 0) ? -1: 1;
            if (prefixSum == 0)
                result = i+1;
            if (map.containsKey(prefixSum))
                result = Math.max(result, i-map.get(prefixSum));
            else
                map.put(prefixSum, i);
        }
        return result;
    }
}
