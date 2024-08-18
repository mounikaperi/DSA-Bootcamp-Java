// https://leetcode.com/problems/search-in-rotated-sorted-array/
class RotatedBinarySearchWithDuplicatesLongVersion {
    public static void main(String[] args) {
        int[] arr = {4, 5, 5, 6, 7, 0, 1, 2, 3, 4};
        int target = 0;
        int index = searchInRotatedArray(arr, target);
        System.out.println("Element is found at position " + index);
    }
    private static int pivotElementIndex(int[] arr) {
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
    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            else if(target > arr[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
    private static int searchInRotatedArray(int[] arr, int target) {
        int pivot = pivotElementIndex(arr);
        // Case - 1:If you did not find a pivot that means array is not rotated, just do a normal binarySearch
        if (pivot == -1) return binarySearch(arr, target, 0, arr.length-1);
        // Case - 2: If pivot is found, then you found 2 ascending sorted arrays
        if (arr[pivot] == target) return pivot;
        // Case - 3: if target is greater than first element search element in first half of array
        if (target >= arr[0]) return binarySearch(arr, target, 0, pivot-1);
        // case -4: if target is less than first element search in second half of array
        return binarySearch(arr, target, pivot+1, arr.length-1);
    }
}
