package com.java.dsa.searching;

public class CountNoOfOccurrencesInSortedArray {
    static int countFreq(int[] arr, int target) {
        int res = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == target) res++;
        }
        return res;
    }
    static int lowerBound(int[] arr, int target) {
        int low = 0; int high=arr.length-1; int res = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    static int upperBound(int[] arr, int target) {
        int low = 0, high=arr.length-1, res=arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
    static int countFreqUsingBinarySearch(int[] arr, int target) {
        return upperBound(arr, target) - lowerBound(arr, target);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int target = 2;
        System.out.println(countFreq(arr, target));
        System.out.println(countFreqUsingBinarySearch(arr, target));
    }
}
