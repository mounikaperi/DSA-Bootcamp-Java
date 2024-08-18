class BinarySearchInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(getRangeToSearch(arr, target));
    }
    static int getRangeToSearch(int[] arr, int target) {
        // start with chunk of 2 and exponentially increase it as it is infinite array
        int start = 0, end = 1;
        while (target > arr[end]) {
            int newStart = end + 1;
            end += (end - start + 1) * 2; // grow exponentially
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
    }
    static int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) return mid;
            else if (target > arr[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }    
}
