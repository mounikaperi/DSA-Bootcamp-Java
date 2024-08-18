public class CapacityToShipInDdays {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
	    int[] arr = {1,2,3,4,5,6,7,8,9,10};
	    int days = 5;
		System.out.println("The smallest divisor is: " + shipWithinDays(arr, days));
	}
	private static int shipWithinDays(int[] arr, int days) {
	    int low = Integer.MIN_VALUE;
        int high = 0;
        for (int num: arr) {
            low = Math.max(low, num);
            high += num;
        }
	    int load = 0;
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        int numberOfDays = findNumberOfDays(arr, mid);
	        if (numberOfDays <= days) high = mid - 1;
	        else low = mid + 1;
	    }
	    return low;
	}
	private static int findNumberOfDays(int[] arr, int capacity) {
	    int load = 0;
	    int days = 1;
	    for (int num: arr) {
	        if (load + num > capacity) {
	            ++days;
	            load = num;
	        } else {
	            load += num;
	        }
	    }
	    return days;
	}
	private static int findMax(int[] arr) {
	    int max = Integer.MIN_VALUE;
	    for (int num: arr) if (num > max) num = max;
	    return max;
	}
}
