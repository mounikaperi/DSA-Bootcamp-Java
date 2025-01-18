package com.java.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class MinDistanceBetweenMinMaxOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 5, 20, 1, 11, 9, 15, 20, 20};
        System.out.println(findMinDistance(arr)); // O(n) TC: O(2): SC -> constant space
        System.out.println(findMinDistance2(arr)); // O(n) TC: O(1): SC
    }
    static int findMinDistance(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // Edge cases:
        if (arr.length == 1 || arr.length == 0) return 0;

        int minElement = Integer.MAX_VALUE, maxElement = -1, minDistance = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > maxElement) maxElement = arr[i];
            if (arr[i] < minElement) minElement = arr[i];
        }
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == minElement) map.put(minElement, i);
            if (arr[i] == maxElement) map.put(maxElement, i);
            if (map.containsKey(minElement) && map.containsKey(maxElement)) // map should contain both min and max element to calculate distance
                minDistance = Math.min(minDistance, Math.abs(map.get(minElement) - map.get(maxElement)));
        }
        // Edge case: if there is no max element for example, [1, 1] only min element is present
        return minDistance == Integer.MAX_VALUE ? 0: minDistance;
    }
    static int findMinDistance2(int[] arr) {
        int minDistance = Integer.MAX_VALUE,
                minElementIndex = -1,
                maxElementIndex = -1,
                minElement = Integer.MAX_VALUE,
                maxElement = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > maxElement) maxElement = arr[i];
            if (arr[i] < minElement) minElement = arr[i];
        }
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == minElement) minElementIndex = i;
            if (arr[i] == maxElement) maxElementIndex = i;
            if (minElementIndex != -1 && maxElementIndex != -1) // that means indexes got updates so find distance
                minDistance = Math.min(minDistance, Math.abs(minElementIndex - maxElementIndex));
        }
        return minDistance == Integer.MAX_VALUE ? 0 : minDistance;
    }
}
