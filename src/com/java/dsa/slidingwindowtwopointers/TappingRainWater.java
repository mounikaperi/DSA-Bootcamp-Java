package com.java.dsa.slidingwindowtwopointers;

public class TappingRainWater {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWaterNaive(arr));
        int[] arr1 = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWaterPrefixSuffix(arr1));
        int[] arr2 = { 2, 1, 5, 3, 1, 0, 4 };
        System.out.println(maxWaterTwoPointers(arr2));
    }
    static int maxWaterNaive(int[] arr) {
        // Traverse every array element and find the highest bars on the left
        // and right sides. The difference between the smaller height and the
        // height of the current element is the amount of water that can be
        // stored in this array element
        int result = 0;
        for (int i=1; i<arr.length-1; i++) {
            int left = arr[i];
            for (int j=0; j<i; j++) {
                left = Math.max(left, arr[j]);
            }
            int right = arr[i];
            for (int j=i+1; j<arr.length; j++) {
                right = Math.max(right, arr[j]);
            }
            result += Math.min(left, right) - arr[i];
        }
        return result;
    }
    static int maxWaterPrefixSuffix(int[] arr) {
        /*
        In the previous approach, for every element  we needed to calculate the
        highest element on the left and on the right. So, to reduce the time
        complexity:
        - For every element we first calculate and store the highest bar on the
        left[] and the right[]
        - Then iterate the array and use the calculated values to find the amount
        of water stored in the index which is same as min(left[i], right[i]) - arr[i]
         */
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int result = 0;
        left[0] = arr[0];
        for (int i=1; i<n; i++)
            left[i] = Math.max(left[i-1], arr[i]);
        right[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--)
            right[i] = Math.max(right[i+1], arr[i]);
        for (int i=1; i<n-1; i++) {
            int minOf2 = Math.min(left[i-1], right[i+1]);
            if (minOf2 > arr[i])
                result += minOf2 - arr[i];
        }
        return result;
    }
    static int maxWaterTwoPointers(int[] arr) {
        int n = arr.length;
        int left = 1;
        int right = n-2;
        int lMax = arr[left-1];
        int rMax = arr[right+1];
        int result = 0;
        while (left <= right) {
            if (rMax<=lMax) {
                result += Math.max(0, rMax-arr[right]);
                rMax = Math.max(rMax, arr[right]);
                right -=1;
            } else {
                result += Math.max(0, lMax-arr[left]);
                lMax = Math.max(lMax, arr[left]);
                left += 1;
            }
        }
        return result;
    }
}
