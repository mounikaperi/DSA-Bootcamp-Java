package com.java.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountQuadruplets {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 4;
        System.out.println(countSumNaive(arr, target));
        System.out.println(countSumBetter(arr, target));
        System.out.println(countSumOptimal(arr, target));
    }
    static int countSumNaive(int[] arr, int target) {
        int count = 0;
        for (int i=0; i<arr.length-3; i++) {
            for (int j=i+1; j<arr.length-2; j++) {
                for (int k=j+1; k<arr.length-1; k++) {
                    for (int l=k+1; l<arr.length; l++) {
                        if (arr[i] + arr[j] + arr[k] + arr[l] == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    static int countSumBetter(int[] arr, int target) {
        int count = 0;
        for (int i=0; i<arr.length-3; i++) {
            for (int j=i+1; j<arr.length-2; j++) {
                int remainingSum = target-arr[i]-arr[j];
                count += getPairsCount(arr, j+1, remainingSum);
            }
        }
        return count;
    }
    static int getPairsCount(int[] arr, int index, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i=index; i<arr.length; i++) {
            if (map.containsKey(target-arr[i])) {
                count += map.get(target-arr[i]);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
    static int countSumOptimal(int[] arr, int target) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                int temp = arr[i] + arr[j];
                count += map.getOrDefault(target-temp, 0);
            }
            for (int j=0; j<i; j++) {
                int temp = arr[i] + arr[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return count;
    }
}
