package com.java.dsa.slidingwindowtwopointers;

public class MinRemovalsForTargetSum {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 3, 2};
        int k = 5;
        System.out.println(minRemovals(arr, k));
    }
    static int minRemovalsRecursion(int[] arr, int k) {
        int result = minRemovalsRec(arr, k, 0, arr.length-1, 0);
        return result == Integer.MAX_VALUE ? -1: result;
    }
    static int minRemovalsRec(int[] arr, int k, int left, int right, int count) {
        if (k == 0) return count;
        if (left > right) return Integer.MAX_VALUE;
        int l = minRemovalsRec(arr, k-arr[left], left+1, right, count+1);
        int r = minRemovalsRec(arr, k-arr[right], left, right-1, count+1);
        return Math.min(l, r);
    }
    static int minRemovalsPrefixSum(int[] arr, int k) {
        int total = 0;
        for (int num: arr) {
            total += num;
        }
        if (k == total) return arr.length;
        int target = total - k;
        Map<Integer, Integer> prefixIdx = new HashMap<>();
        int prefSum = 0, maxLength = -1;
        for (int i=0; i<arr.length; i++) {
            prefSum += arr[i];
            if (prefSum == target) {
                maxLength = i + 1;
            } else if (prefixIdx.containsKey(prefSum - target)) {
                maxLength = Math.max(maxLength, i - prefixIdx.get(prefSum - target));
            }
            if (!prefixIdx.containsKey(prefSum)) {
                prefixIdx.put(prefSum, i);
            }
        }
        return maxLength == -1 ? -1 : arr.length-maxLength;
    }
    static int minRemovalsSlidingWindow(int[] arr, int k) {
        int total = 0, n = arr.length;
        for (int num: arr) {
            total += num;
        }
        int target = total - k;
        if (target == 0) return n; // if target sum == 0, all elements must be removed
        int left = 0, currSum = 0, maxLength = -1;
        for (int right = 0; right < n; right++) {
            currSum += arr[right];
            while (left < right && currSum > target) {
                currSum -= arr[left++];
            }
            if (currSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength == -1 ? -1 : n - maxLength;
    }
}