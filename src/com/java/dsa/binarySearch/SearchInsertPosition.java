public class SearchInsertPosition {
	public static void main(String[] args) {
    // https://leetcode.com/problems/search-insert-position/description/
		int[] arr = {1,3,5,6};
        int target = 7;
        int index = binarySearch(arr, 0, arr.length-1, target);
        System.out.println("The upper bound is the index: " + index);
	}
    private static int binarySearch(int[] arr, int low, int high, int target) {
        int ans = high + 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                return binarySearch(arr, mid+1, high, target);
            } else {
                return binarySearch(arr, low, mid-1, target);
            }
        }
        return ans;
    }
}
