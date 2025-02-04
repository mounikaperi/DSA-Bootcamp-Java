package com.java.dsa.slidingwindowtwopointers;

import java.util.Arrays;

public class CountPossibleTriangles {
    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 7};
        System.out.println(countTrianglesNaive(arr));
        System.out.println(countTrianglesBinarySearch(arr));
        System.out.println(countTrianglesTwoPointers(arr));
    }
    static int countTrianglesNaive(int[] arr) {
        int countTriangles = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                for (int k=j+1; k<arr.length; k++) {
                    if (arr[i] + arr[j] > arr[k]
                        && arr[j] + arr[k] > arr[i]
                        && arr[k] + arr[i] > arr[j]) {
                        countTriangles++;
                    }
                }
            }
        }
        return countTriangles;
    }
    static int countTrianglesBinarySearch(int[] arr) {
        /*
        The idea is to sort the array in ascending order. Then, use two nested loops,
        The outer loop is to fix the first side and inner loop is to fix the second side
        Next, find the fartheset index for the third side, such that its value is less
        than sum of the first two sides using BinarySearch.

        So a range of values for third side can be found, where it is guaranteed that
        its length is greater than the other individual sides but < sum of both sides

        Add the range size to the result
        */
        int countPairs = 0;
        Arrays.sort(arr);
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                int low = j+1, high=arr.length;
                int sumSoFar = arr[i] + arr[j];
                while (low < high) {
                    int mid = (low + high) >> 1;
                    if (arr[mid] < sumSoFar) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                int count = low - j - 1;
                countPairs += count;
            }
        }
        return countPairs;
    }
    static int countTrianglesTwoPointers(int[] arr) {
        int countPairs = 0;
        Arrays.sort(arr);
        for (int i=2; i<arr.length; i++) {
            int left = 0, right=i-1;
            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    // if arr[left] + arr[right] satisfies triangle inequality,
                    // so all pairs (x, right) with (left <= x <= right) are valid
                    countPairs += right-left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return countPairs;

    }
}
