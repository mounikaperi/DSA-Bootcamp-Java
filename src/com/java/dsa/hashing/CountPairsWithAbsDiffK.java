package com.java.dsa.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountPairsWithAbsDiffK {
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 4, 5};
        int k = 3;

        System.out.println(countPairsNaive(arr, k));
        System.out.println(countPairsExpected(arr, k));
        System.out.println(countPairsOptimal(arr, k));
    }
    static int countPairsNaive(int[] arr, int k) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (Math.abs(arr[i]-arr[j]) == k)
                    count++;
            }
        }
        return count;
    }
    static int countPairsExpected(int[] arr, int k) {
        /*
            Sort the array
            Use two pointer technique, i, j, pointing at beginning of array
            arr[j]-arr[i] < target increment j pointer
            arr[j]-arr[i] > target increment i pointer
            arr[j]-arr[i] = target count the pair
        */
        int n = arr.length;
        int count = 0;
        Arrays.sort(arr);
        int i=0, j=0;
        while (j < n) {
            if (arr[j]-arr[i] < k) j++;
            else if (arr[j]-arr[i] > k) i++;
            else {
                int element1 = arr[i], element2 = arr[j];
                int count1 = 0, count2 = 0;
                while (j<n && arr[j] == element2) {
                    j++;
                    count2++;
                }
                while (i<n && arr[i] == element1) {
                    i++;
                    count1++;
                }
                if (element1 == element2)
                    count += (count1 * (count1 - 1) / 2);
                else
                    count += (count1 * count2);
            }
        }
        return count;
    }
    static int countPairsOptimal(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            // arr[i]-arr[j] = k => arr[j] = arr[i]+k
            // arr[j]-arr[i] = k => arr[j] = arr[i]-k
            if (map.containsKey(arr[i]+k)) count += map.get(arr[i]+k);
            if (map.containsKey(arr[i]-k)) count += map.get(arr[i]-k);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}
