package com.java.dsa.slidingwindowtwopointers;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 2, 4};
        int target = 4;
        System.out.println(closest3SumNaive(arr, target));
        System.out.println(closest3Sum(arr, target));
    }
    static int closest3SumNaive(int[] arr, int target) {
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        for (int i=0; i<n-2; i++) {
            for (int j=i+1;j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    int currSum = arr[i] + arr[j] + arr[k];
                    int currDiff = Math.abs(target - currSum);
                    if (currDiff < minDiff) {
                        result = currSum;
                        minDiff = currDiff;
                    } else if (currDiff == minDiff) {
                        result = Math.max(result, currSum);
                    }
                }
            }
        }
        return result;
    }
    static int closest3Sum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i=0; i<n-2; i++) {
            int left = i+1, right = n-1;
            while (left < right) {
                int currSum = arr[i] + arr[left] + arr[right];
                int currDiff = Math.abs(target - currSum);
                if (currDiff < minDiff) {
                    result = currSum;
                    minDiff = currDiff;
                } else if (currDiff == minDiff) {
                    result = Math.max(result, currSum);
                }
            }
        }
        return result;
    }
}