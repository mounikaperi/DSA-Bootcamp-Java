package com.java.dsa.slidingwindowtwopointers;

import java.util.*;

public class CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        List<Integer> res = countDistinctNaive(arr, k);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
        System.out.println();
        res = countDistinctSlidingWindow(arr, k);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
    static List<Integer> countDistinctNaive(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<=(arr.length-k); i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j=i; j<(i+k); j++) {
                set.add(arr[j]);
            }
            res.add(set.size());
        }
        return res;
    }
    static List<Integer> countDistinctSlidingWindow(int[] arr, int k) {
        //{1, 2, 1, 3, 4, 2, 3}
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i=0; i<k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }
        res.add(freq.size());
        for (int i=k; i<arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            freq.put(arr[i-k], freq.get(arr[i-k])-1);
            if (freq.get(arr[i-k]) == 0) {
                freq.remove(arr[i-k]);
            }
            res.add(freq.size());
        }
        return res;
    }
}
