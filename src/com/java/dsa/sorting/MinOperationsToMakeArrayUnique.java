package com.java.dsa.sorting;

import java.util.Arrays;

public class MinOperationsToMakeArrayUnique {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 4, 1};
        System.out.println(minIncrementsNaive(arr));
        int[] arr1 = {2, 1, 2, 4, 1};
        System.out.println(minIncrements(arr1));
    }
    static int minIncrementsNaive(int[] arr) {
        Arrays.sort(arr);
        int numOfIncrements = 0;
        for (int i=1; i<arr.length; i++) {
            if (arr[i] <= arr[i-1]) {
                numOfIncrements += arr[i-1] + 1 - arr[i];
                arr[i] = arr[i-1]+1;
            }
        }
        return numOfIncrements;
    }
    static int minIncrements(int[] arr) {

        int n = arr.length;
        int cnt = 0;

        // Find the maximum element in the array
        int mx = arr[0];
        for (int ele : arr)
            mx = Math.max(mx, ele);

        int[] freq = new int[n + mx];

        // Find the frequency of all elements from the array
        for (int ele : arr)
            freq[ele]++;

        for (int num = 0; num < freq.length; num++) {

            // If there is more than one occurrence of num
            if (freq[num] > 1) {

                // Increment all extra occurrences by 1
                freq[num + 1] += freq[num] - 1;

                // Count these increment operations
                cnt += freq[num] - 1;
                freq[num] = 1;
            }
        }
        return cnt;
    }
}
