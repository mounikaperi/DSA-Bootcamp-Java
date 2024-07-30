class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 10, 11};
        int target = 8;
        System.out.println("Is Element found? " + CeilingOfNumber(arr, target));
    }
    static boolean isArraySortedInAscOrder(int[] arr, int low, int high) {
        return arr[low] < arr[high];
    }
    static int CeilingOfNumber(int[] arr, int target) {
        int low = 0; int high = arr.length-1;
        boolean isArrSortedInAscending = isArraySortedInAscOrder(arr, low, high);
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (target == arr[mid]) return arr[mid];
            if (isArrSortedInAscending) {
                if (target > arr[mid]) low = mid + 1;
                else high = mid - 1;
            } else {
                if (target > arr[mid]) high = mid - 1;
                else low = mid + 1;
            }
        }
        return arr[low];
    }
}
