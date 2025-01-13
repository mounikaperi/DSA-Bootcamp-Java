package com.java.dsa.searching;

public class FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMin(arr));
        System.out.println(findMinExpected(arr));
    }
    static int findMin(int[] arr) {
        int minimum = arr[0];
        for (int i=1; i<arr.length; i++) {
            minimum = Math.min(minimum, arr[i]);
        }
        return minimum;
    }
    static int findMinExpected(int[] arr) {
        int low = 0, high = arr.length-1;
        while (low < high) {
            if (arr[low] < arr[high]) {
                // the current subarray is already sorted, the min is at low index
                return arr[low];
            }
            // we reach here when we have atleast two elements and the currentsubarray is rotated
            int mid = (low + high) / 2;
            if (arr[mid]>arr[high]) {
                // The right half is not sorted, So min element must be in right half
                low = mid+1;
            }
            else {
                // the right half is sorted. In this case, we donot change high to mid-1 but keep it to mid.
                // As the mid element itself can be the smallest
                high = mid;
            }
        }
        return arr[low];
    }
}
