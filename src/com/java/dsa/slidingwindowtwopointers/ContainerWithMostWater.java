package com.java.dsa.slidingwindowtwopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 6, 4, 6, 5, 5};
        System.out.println(maxWaterNaive(arr));
        System.out.println(maxWaterTwoPointers(arr));
    }
    public static int maxWaterNaive(int[] arr) {
        int n = arr.length;
        int result = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int amount = Math.min(arr[i], arr[j]) * (j-i);
                result = Math.max(amount, result);
            }
        }
        return result;
    }
    public static int maxWaterTwoPointers(int[] arr) {
        int left = 0, right=arr.length-1;
        int result = 0;
        while (left < right) {
            int water = Math.min(arr[left], arr[right]) * (right - left);
            result = Math.max(result, water);
            if (arr[left] < arr[right])
                left += 1;
            else
                right -= 1;
        }
        return result;
    }
}
