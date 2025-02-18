package com.java.dsa.slidingwindowtwopointers;

public class CountSubArraysWithExactlyKDistinctElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int k = 2;
        System.out.println(exactKNaive(arr, k));
        System.out.println(exactKOptimal(arr, k));
    }
    static int exactKNaive(int[] arr, int k) {
        int n = arr.length;
        int result = 0;
        for (int i=0; i<n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=i; j<n; j++) {
                set.add(arr[j]);
                if (set.size() > k) {
                    break;
                }
                if (set.size() == k) {
                    result += 1;
                }
            }
        }
        return result;
    }
    static int exactKOptimal(int[] arr, int k) {
        return exactK(arr, k) - exactK(arr, k-1);
    }
    static int exactK(int[] arr, int k) {
        int n = arr.length, result = 0, left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            if (map.get(arr[right]) == 1) {
                k -= 1;
            }
            while (k < 0) {
                map.put(arr[left], map.get(arr[left]-1));
                if (map.get(arr[left]) == 0) {
                    k += 1;
                }
                left += 1;
            }
            result += (right - left + 1);
            right += 1;
        }
        return result;
    }
}