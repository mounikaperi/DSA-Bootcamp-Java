package com.java.dsa.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPairClosestToTarget {
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 1, 4};
        int[] arr1 = {5, 2, 7, 1, 4};
        int target = 10;

        List<Integer> res = sumClosestNaive(arr, target);
        if(res.size() > 0)
            System.out.println(res.get(0) + " " + res.get(1));
        res = sumClosestBinarySearch(arr1, target);
        if(res.size() > 0)
            System.out.println(res.get(0) + " " + res.get(1));
        res = sumClosestTwoPointers(arr, target);
        if(res.size() > 0)
            System.out.println(res.get(0) + " " + res.get(1));
    }
    private static List<Integer> sumClosestNaive(int[] arr, int target) {
        List<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                int currSum = arr[i] + arr[j];
                int currDiff = Math.abs(currSum-target);
                // if currDiff is less than minDiff, it indicates
                // that this pair is closer to the target
                if (currDiff < minDiff) {
                    minDiff = currDiff;
                    res = Arrays.asList(Math.min(arr[i], arr[j]),
                            Math.max(arr[i], arr[j]));
                }

                // if currDiff is equal to minDiff, find the one with
                // largest absolute difference
                else if (currDiff == minDiff &&
                        (res.get(1) - res.get(0)) < Math.abs(arr[i] - arr[j])) {
                    res = Arrays.asList(Math.min(arr[i], arr[j]),
                            Math.max(arr[i], arr[j]));
                }
            }
        }
        return res;
    }
    private static List<Integer> sumClosestBinarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i=0; i<arr.length-1; i++) {
            int complement = target - arr[i];
            int closest = findClosest(arr, i+1, arr.length-1, complement);
            int currDiff = Math.abs(target-arr[i]-closest);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                result = Arrays.asList(arr[i], closest);
            }
        }
        return result;
    }
    static int findClosest(int[] arr, int low, int high, int complement) {
        int result = arr[low];
        while(low <= high) {
            int mid = (low + high) >> 1;
            if (Math.abs(arr[mid] - complement) < Math.abs(result - complement))
                result = arr[mid];
            else if (Math.abs(arr[mid] - complement) == Math.abs(result - complement))
                result = Math.max(result, arr[mid]);
            if (arr[mid] == complement)
                return arr[mid];
            else if (arr[mid] < complement)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return result;
    }
    private static List<Integer> sumClosestTwoPointers(int[] arr, int target) {
        /*
            Two pointer approach: O(nlogn+n) TC, O(1) SC
            - Sort the array
            - Point left to the beginning and right to the end of the array
            - if (arr[left] + arr[right] < target increment left pointer
            - if (arr[left] + arr[right] > target decrement right pointer
            - if (arr[left] + arr[right] == target found pair
            In this approach, we don't need to separately handle the case where there is a tie
            between pairs and we need to select the one with max difference.

            This is because we are selecting the first element of the pair in increasing order,
            so if we have a tie between two pairs, we can always choose the first pair
         */
        List<Integer> result = new ArrayList<>();
        if (arr.length == 0 || arr.length == 1) return result;
        Arrays.sort(arr);
        int left = 0, right = arr.length-1, minDiff = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(target-sum) < minDiff) {
                minDiff = Math.abs(target-sum);
                result = Arrays.asList(arr[left], arr[right]);
            }
            if (sum < target) left++;
            else if (sum > target) right--;
            else return result;
        }
        return result;
    }
}
