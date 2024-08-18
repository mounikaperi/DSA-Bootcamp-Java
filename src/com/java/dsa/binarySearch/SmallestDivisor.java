public class SmallestDivisor {
	public static void main(String[] args) {
	    int[] arr = {1,2,5,9};
	    int threshold = 6;
		System.out.println("The smallest divisor is: " + smallestDivisor(arr, threshold));
	}
	private static int smallestDivisor(int[] arr, int threshold) {
	    int low = 0;
	    int high = findMax(arr);
	    int ans = 0;
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        int calculatedSum = findSum(arr, mid);
	        if (calculatedSum <= threshold) {
	            ans = mid;
	            high = mid - 1;
	        } else low = mid + 1;
	    }
	    return ans;
	}
	private static int findSum(int[] arr, int divisor) {
	    int totalSum = 0;
	    for (int i=0; i<arr.length; i++) {
	        totalSum += Math.ceil((double)(arr[i]) / (double)divisor);
	    }
	    return totalSum;
	}
	private static int findMax(int[] arr) {
	    int max = Integer.MIN_VALUE;
	    for (int num: arr) if (num > max) max = num;
	    return max;
	}
}
