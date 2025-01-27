package com.java.dsa.twopointers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class IndexesOfSubArraySum {
    public static void main(String[] args) {
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int target = 23;
        ArrayList<Integer> res = subarraySumNaive(arr, target);
        for (int ele : res)
            System.out.print(ele + " ");
        res = subarraySumSlidingWindow1(arr, target);
        for (int ele : res)
            System.out.print(ele + " ");
        res = subarraySumSlidingWindow2(arr, target);
        for (int ele : res)
            System.out.print(ele + " ");
        res = subarraySumHashingPrefixSum(arr, target);
        for (int ele : res)
            System.out.print(ele + " ");
    }
    static ArrayList<Integer> subarraySumNaive(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            int sumSoFar = 0;
            for (int j=i; j<arr.length; j++) {
                sumSoFar += arr[j];
                if (sumSoFar == target) {
                    result.add(i+1);
                    result.add(j+1);
                    return result;
                }
            }
        }
        result.add(-1);
        return result;
    }
    static ArrayList<Integer> subarraySumSlidingWindow1(int[] arr, int target) {
        // int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = left + 1;
        int sumSoFar = arr[left];
        if (sumSoFar == target) {
            // edge case: if first element itself is equal to target then return
            result.add(left+1);
            result.add(left+1);
            return result;
        }
        while (sumSoFar < target) {
            sumSoFar += arr[right];
            if (sumSoFar == target) {
                result.add(left+1);
                result.add(right+1);
                return result;
            }
            if (sumSoFar > target) {
                left++; // adjust sliding window
                right=left+1;
                sumSoFar = arr[left]; // reset the sum
            } else {
                right++;
            }
        }
        result.add(-1);
        return result;
    }
    static ArrayList<Integer> subarraySumSlidingWindow2(int[] arr, int target) {
        /*
        Start with an empty window
        add elements to the window while the current sum is less than sum
        if the sum is greater than target, remove elements from the start of the current window
        if current sum becomes same as target, return the result
         */
        int left=0, right=0;
        ArrayList<Integer> result = new ArrayList<>();
        int sumSoFar = 0;
        for (int i=0; i<arr.length; i++) {
            sumSoFar += arr[i];
            if (sumSoFar >= target) {
                right = i;
                while (sumSoFar > target && left < right) {
                    sumSoFar -= arr[left];
                    left++;
                }
                if (sumSoFar == target) {
                    result.add(left+1);
                    result.add(right+1);
                    return result;
                }
            }
        }
        result.add(-1);
        return result;
    }
    static ArrayList<Integer> subarraySumHashingPrefixSum(int[] arr, int target) {
        int sumSoFar = 0, left = 0, right = -1;
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            sumSoFar += arr[i];
            if (sumSoFar - target == 0) {
                left = 0;
                right = i;
                break;
            }
            if (map.containsKey(sumSoFar-target)) {
                // if hashmap already has the value, means we already have subarray with target so stop
                left = map.get(sumSoFar-target)+1;
                right = i;
                break;
            }
            map.put(sumSoFar, i);
        }
        if (right == -1) {
            result.add(-1);
            return result;
        }
        result.add(left+1);
        result.add(right+1);
        return result;
    }
}
