class PeakIndexInMountainArray {
    public static void main(String[] args) {
         int[] arr = {10, 20, 30, 40, 50, 45, 35, 25, 15, 0};
         System.out.println("Peak Element is " + findPeakIndexInMountainArray(arr));
    }
    static int findPeakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are in descending part of array. 
                // This may be the answer but look at left to see if there is another descending element
                ans = mid;
                high = mid - 1;
            } else {
                // You are in ascending part of array
                // because we know that mid + 1 element is greater than mid element
                low = mid + 1;
            }
        }
        // In the end low == high pointing at the largest element 
        // low and end are always finding max element in the above two checks
        // hence when they both are finding to just one element that is the maximum one
        // More elaboration: At every point of time for low and high they have best possible answer till that time
        // and if we are saying if only one item is remaining hence that's the best possible answer
        return ans;
    }
}
