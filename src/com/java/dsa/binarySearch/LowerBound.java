public class Main {
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 3, 5};
		int x = 2;
		System.out.println("Lower Bound of x is: " + findLowerBound(arr, x));
		System.out.println("Lower Bound of x is: " + findLowerBoundViaRecursion(arr, 0, arr.length-1, x));
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
	private static int findLowerBoundViaRecursion(int[] arr, int low, int high, int target) {
	    int ans = high + 1;
            if (low > high) return ans;
            int mid = (low + high)/2;
            if (arr[mid] >= target) {
               ans = mid;
	       ans = findLowerBoundViaRecursion(arr, low, mid-1, target);
            } else {
               ans = findLowerBoundViaRecursion(arr, mid+1, high, target);
            } 
            return ans;
	}
}
