import java.util.Map;
import java.util.HashMap;
public class LongestSubArrayWithGivenSumKPositives {
	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 1, 9};
        long k = 10;
        System.out.println("The length of the longest subarray is: " + getLongestSubArrayViaBruteForce(arr, k));
        System.out.println("The length of the longest subarray is: " + getLongestSubArrayViaNaiveApproach(arr, k));
        System.out.println("The length of the longest subarray is: " + getLongestSubArrayViaHashing(arr, k));
        System.out.println("The length of the longest subarray is: " + getLongestSubArrayViaTwoPointers(arr, k));
	}
	private static int getLongestSubArrayViaBruteForce(int[] arr, long target) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) { // starting index
            for (int j = i; j < arr.length; j++) { // ending index
                // add all the elements of
                // subarray = a[i...j]:
                long sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == target)
                    length = Math.max(length, j - i + 1);
            }
        }
        return length;
	}
	private static int getLongestSubArrayViaNaiveApproach(int[] arr, long target) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) { // starting index
            long sum = 0; // Sum variable
            for (int j = i; j < arr.length; j++) { // ending index
                // add the current element to
                // the subarray a[i...j-1]:
                sum += arr[j];
                if (sum == target)
                    length = Math.max(length, j - i + 1);
            }
        }
        return length;

	}
	private static int getLongestSubArrayViaHashing(int[] arr, long target) {
	    Map<Long, Integer> map = new HashMap<>();
	    long sum = 0;
	    int maxLength = 0;
	    for (int i=0; i<arr.length; i++) {
	        sum += arr[i];
	        if (sum == target) {
	            maxLength = Math.max(maxLength, i+1);
	        }
	        long remainingSum = sum - target;
	        if (map.containsKey(remainingSum)) {
	            int length = i - map.get(remainingSum);
	            maxLength = Math.max(maxLength, length);
	        } else {
	            map.put(sum, i);
	        }
	    }
	    return maxLength;
	}
	private static int getLongestSubArrayViaTwoPointers(int[] arr, long target) {
	    int low = 0;
	    int high = 0;
	    long sum = arr[0];
	    int maxLength = 0;
	    while (high < arr.length) {
	        // If sum > target, reduce the subarray from low until sum becomes less or equal to target
	        while (low <= high && sum > target) {
	            sum -= arr[low];
	            low++;
	        }
	        if (sum == target) {
	            maxLength = Math.max(maxLength, high-low+1);
	        }
	        high++;
	        if (high < arr.length) {
	            sum += arr[high];
	        }
	    }
	    return maxLength;
	}
}
