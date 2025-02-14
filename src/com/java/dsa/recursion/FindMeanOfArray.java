package com.java.dsa.recursion;

public class FindMeanOfArray {
    public static void main(String[] args) {
        float mean = 0;
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(findMean(arr, 5));
    }
    static float findMean(int[] arr, int n) {
        /* Sum of first N-1 elements = (Mean of N-1 elements)*(N-1)
           Mean of N elements = (Sum of first N-1 elements + N-th elements) / (N)
         */
        if (n == 1) {
            return (float) (arr[n-1]);
        } else {
            return (float) (findMean(arr, n-1) * (n-1) + arr[n-1] / n);
        }
    }
}
