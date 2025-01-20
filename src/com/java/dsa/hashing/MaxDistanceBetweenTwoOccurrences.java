package com.java.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxDistanceBetweenTwoOccurrences {
    static int maxDistanceUsingHashing(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(arr[i])) {
                result = Math.max(result, i - map.get(arr[i]));
            } else {
                map.put(arr[i], i);
            }
        }
        return result;
    }
    static int maxDistance(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // check if two elements are equal
                if (arr[i] == arr[j]) {
                    // calculate the distance and update res
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 1};
        System.out.println(maxDistanceUsingHashing(arr));
        System.out.println(maxDistance(arr));
    }
}
