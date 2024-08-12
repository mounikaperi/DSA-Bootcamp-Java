public class LowerBound {
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 3, 5};
		int x = 2;
		System.out.println("Lower Bound of x is: " + findLowerBound(arr, x));
	}
	private static int findLowerBound(int[] arr, int target) {
	    int low = 0;
	    int high = arr.length - 1;
	    int ans = high + 1;
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        if (arr[mid] >= target) {
	            ans = mid;
	            high = mid - 1;
	        } else {
	            low = mid + 1;
	        }
	    }
	    return ans;
	}
}
