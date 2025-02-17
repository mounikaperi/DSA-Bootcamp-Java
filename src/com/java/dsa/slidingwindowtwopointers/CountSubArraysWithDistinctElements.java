package com.java.dsa.slidingwindowtwopointers;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithDistinctElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 3, 3, 4, 2, 1};
        int k = 2;
        System.out.println(atMostKNaive(arr, k));
        System.out.println(atMostK(arr, k));
    }
    static int atMostKNaive(int[] arr, int k) {
        int n = arr.length;
        int result = 0;
        for (int i=0; i<n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=i; j<n; j++) {
                set.add(arr[j]);
                if (set.size() > k) {
                    break;
                }
                result += 1;
            }
        }
        return result;
    }
    static int atMostK(int[] arr, int k) {
        int n = arr.length;
        int result = 0, left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0)+1);
            if (map.get(arr[right]) == 1) {
                // If this is a new element in the window, decrement k by 1
                k -= 1;
            }
            while (k < 0) {
                map.put(arr[left], map.get(arr[left])-1);
                if (map.get(arr[left]) == 0) {
                    k += 1;
                }
                left += 1; // Increment window size
            }
            result += (right - left + 1);
            right += 1;
        }
        return result;
    }
}