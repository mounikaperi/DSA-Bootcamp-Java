package com.java.dsa.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountPairs {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, -1, 5 };
        int target = 6;
        System.out.println(countPairs(arr, target));
        System.out.println(countPairsBetter(arr, target));
        System.out.println(countPairsHashing(arr, target));
    }
    static int countPairs(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (arr[i] + arr[j] == target) count++;
            }
        }
        return count;
    }
    static int countPairsBetter(int[] arr, int target) {
        Arrays.sort(arr);
        int count =0, start = 0, end = arr.length-1;
        while (start < end) {
            if ((arr[start] + arr[end]) < target) start++;
            else if ((arr[start] + arr[end]) > target) end--;
            else {
                int count1 = 0, count2 = 0;
                int element1 = arr[start], element2 = arr[end];
                while (start <= end && arr[start] == element1) {
                    start++;
                    count1++;
                }
                while(start <= end && arr[end] == element2) {
                    end--;
                    count2++;
                }
                if (element1 == element2) count += (count1 * (count1-1))/2;
                else count += (count1*count2);
            }
        }
        return count;
    }
    static int countPairsHashing(int[] arr, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            if (freq.containsKey(target-arr[i])) count += freq.get(target-arr[i]);
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}
