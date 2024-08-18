package com.java.dsa.binarySearch;
class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int target = 4;
        System.out.println("Is Element found? " + binarySearch(arr, target));
    }
    static boolean isArraySortedInAscOrder(int[] arr, int low, int high) {
        return arr[low] < arr[high];
    }
    static boolean binarySearch(int[] arr, int target) {
        int low = 0; int high = arr.length-1;
        boolean isArrSortedInAscending = isArraySortedInAscOrder(arr, low, high);
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) return true;
            if (isArrSortedInAscending) {
                if (target > arr[mid]) low = mid + 1;
                else high = mid - 1;
            } else {
                if (target > arr[mid]) high = mid - 1;
                else low = mid + 1;
            }
        }
        return false;
    }
}
