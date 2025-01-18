package com.java.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithXor {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int k = 6;

        System.out.println(subarrayXor(arr, k));
        System.out.println(subarrayXorOptimal(arr, k));
    }
    static int subarrayXor(int[] arr, int k) {
        int res = 0;

        // Pick starting point i of subarrays
        for (int i = 0; i < arr.length; i++) {
            int prefXOR = 0;

            // Pick ending point j of subarray for each i
            for (int j = i; j < arr.length; j++) {
                // calculate prefXOR for subarray arr[i ... j]
                prefXOR = prefXOR ^ arr[j];

                // If prefXOR is equal to given value, increase res by 1
                if (prefXOR == k)
                    res++;
            }
        }
        return res;
    }
    static int subarrayXorOptimal(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int prefXor = 0;
        for (int value: arr) {
            prefXor ^= value;
            count += map.getOrDefault(prefXor^k, 0);
            if (prefXor == k) count++;
            map.put(prefXor, map.getOrDefault(prefXor, 0) + 1);
        }
        return count;
    }
}
