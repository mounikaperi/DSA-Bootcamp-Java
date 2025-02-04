package com.java.dsa.slidingwindowtwopointers;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {-1, 1, 5, 5, 7};
        int target = 6;

        System.out.println(countPairsNaive(arr, target));
        System.out.println(countPairsHashMap(arr, target));
        System.out.println(countPairsTwoPointers(arr, target));
    }
    static int countPairsNaive(int[] arr, int target) {
        int countPairs = 0;
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length;j++) {
                if (arr[i] + arr[j] == target) {
                    countPairs++;
                }
            }
        }
        return countPairs;
    }
    static int countPairsHashMap(int[] arr, int target) {
        int countPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(target-arr[i])) {
                countPairs += map.get(target-arr[i]);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return countPairs;
    }
    static int countPairsTwoPointers(int[] arr, int target) {
        int left = 0, right = arr.length-1, countPairs = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                int count1=0, count2=0, element1=arr[left], element2=arr[right];
                while (left<=right && element1 == arr[left]) {
                    left++;
                    count1++;
                }
                while (left<=right && element2 == arr[right]) {
                    right--;
                    count2++;
                }
                if (element1 == element2) {
                    countPairs += (count1 * (count1-1)/2);
                } else {
                    countPairs += (count1 * count2);
                }
            }
        }
        return countPairs;
    }
}
