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
            }
            map.put(arr[i], i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 1};
        System.out.println(maxDistanceUsingHashing(arr));
    }
}
