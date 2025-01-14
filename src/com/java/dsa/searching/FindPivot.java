package com.java.dsa.searching;

public class FindPivot {
    static int peakElement(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            boolean left = true, right = true;
            if (i>0 && arr[i] <= arr[i-1]) left = false;
            if (i<arr.length-1 && arr[i]<=arr[i+1]) right = false;
            if (left && right) return i;
        }
        return 0;
    }
    static int peakElementExpected(int[] arr) {
        int n = arr.length;
        if (n==1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n-1] > arr[n-2]) return n-1;
        int low = 1, high = n-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            if (arr[mid] > arr[mid+1]) high = mid-1;
            else low = mid+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(peakElement(arr));
        System.out.println(peakElementExpected(arr));
    }
}
