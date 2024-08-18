// https://leetcode.com/problems/find-in-mountain-array/description/
class FindInMountainArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,3,1};
        int target = 3;
        System.out.println("Target element " + target + " is present in mountainArray at index " + findInMountainArray(target, arr));
    }
    private static int findInMountainArray(int target, int[] arr) {
        int peakElementIndex = findPeakElementIndex(arr);
        int index = orderAgnosticBinarySearch(arr, target, 0, peakElementIndex);
        if (index != -1) return index;
        return orderAgnosticBinarySearch(arr, target, peakElementIndex+1, arr.length-1);
    }
    private static int orderAgnosticBinarySearch(int[] arr, int target, int low, int high) {
        boolean isAscendingOrder = arr[low] < arr[high];
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (isAscendingOrder) {
                if (target > arr[mid]) low = mid + 1;
                else high = mid - 1;
            } else {
                if (target < arr[mid]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
    private static int findPeakElementIndex(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid+1]) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
