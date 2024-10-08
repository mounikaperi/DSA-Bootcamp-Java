package com.java.dsa.binarySearch;
class RotatedBinarySearchShortVersion {
    public static void main(String[] args) {
        int[] arr = {4, 5, 5, 6, 7, 0, 1, 2, 3, 4};
        int target = 0;
        int index = searchInRotatedArray(arr, target);
        System.out.println("Element is found at position " + index);
    }
    private static int searchInRotatedArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
