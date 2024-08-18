package com.java.dsa.binarySearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int index = countRotations(arr);
        System.out.println("Array is rotated " + index + " times");
    }
    private static int countRotations(int[] arr) {
      int pivot = findPivot(arr);
      if (pivot == -1) return 0;
      return pivot+1;
    }
    private static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end-start) / 2;
            // Case-1: If middle element is greater than next element => first part of array is asc, second part is asc
            // Possibility is pivot to be present as last element => arr[mid+1] would throw ArraysIndexOutOfBoundsException
            if (mid < end && arr[mid] > arr[mid+1]) return mid;
            // Case-2: If middle element is lesser than the but one element => first part of array is desc
            // Implies before element is greatest than mid and that is the pivot
            // Possibility is pivot to be present as first element => arr[mid-1] would throw ArraysIndexOutOfBoundsException
            if (mid > start && arr[mid] < arr[mid-1]) return mid - 1;
            // Case:3- If elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // What if these elements at start and end are pivots?
                // check if start is pivot
                if (arr[start] > arr[start+1]) return start;
                start++;
                // check if end is pivot
                if (arr[end] < arr[end-1]) return end - 1;
                end--;
            // left side is sorted, pivot should be at right
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
