package com.java.dsa.slidingwindowtwopointers;

import java.util.Set;
import java.util.HashSet;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int target = 13;
        System.out.println(hasTripletSumNaive(arr, target));
        System.out.println(hasTripletSumUsingSet(arr, target));
        System.out.println(hasTripletSum(arr, target));
    }
    static boolean hasTripletSumNaive(int[] arr, int target) {
        int n = arr.length;
        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static boolean hasTripletSumUsingSet(int[] arr, int target) {
        int n = arr.length;
        for (int i=0; i<n-2; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j=i+1; j<n-1; j++) {
                int requiredSum = target - (arr[i] + arr[j]);
                if (set.contains(requiredSum)) {
                    return true;
                }
                set.add(arr[j]);
            }
        }
        return false;
    }
    static boolean hasTripletSum(int[] arr, int target) {
        int n = arr.length;
        for (int i=0; i<n-2; i++) {
            int requiredSum = target - arr[i];
            int left = i+1, right = n-1;
            while (left < right) {
                if (arr[left] + arr[right] == requiredSum)
                    return true;
                if (arr[left] + arr[right] < requiredSum)
                    left++;
                else if (arr[left] + arr[right] > requiredSum)
                    right--;
            }
        }
        return false;
    }
}