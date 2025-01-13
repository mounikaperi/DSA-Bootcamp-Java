package com.java.dsa.searching;

public class SearchInRotatedSortedArray {
    static int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    static int findPivot(int[] arr, int low, int high) {
        while (low < high) {
            if (arr[low] < arr[high]) return arr[low];
            int mid = (low + high) / 2;
            if (arr[mid] > arr[high]) low = mid+1;
            else high = mid;
        }
        return low;
    }
    static int search(int[] arr, int key) {
        int pivot = findPivot(arr, 0, arr.length-1);
        if (arr[pivot] == key) return pivot;
        if (pivot == 0) return binarySearch(arr, 0, arr.length-1, key);
        if (arr[0] <= key) return binarySearch(arr, 0, pivot-1, key);
        return binarySearch(arr, pivot+1, arr.length-1, key);
    }
    static int searchExpected(int[] arr, int key) {
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid] == key) return mid;
            if (arr[mid] >= arr[low]) {
                // left half is sorted
                if (key >= arr[low] && key < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // right half is sorted
                if (key > arr[mid] && key <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        System.out.println(search(arr, key));
        System.out.println(searchExpected(arr, key)); // using single binary search
    }
}
