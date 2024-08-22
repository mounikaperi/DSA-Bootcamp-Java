import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class SplitArrayLargestSum {
	public static void main(String[] args) {
      // https://leetcode.com/problems/split-array-largest-sum/description/
	    int[] arr = {7,2,5,10,8};
	    int k = 2;
	    int ans = largestSubArraySumMinimized(arr, k);
	    System.out.println("The answer is: " + ans);
	}
	private static int largestSubArraySumMinimized(int[] arr, int k) {
	    int low = arr[0];
	    int high = 0;
	    // find maximum and sum
	    for (int num: arr) {
	        low = Math.max(low, num);
	        high += num;
	    }
	    while (low <= high) {
	        int mid = low + (high - low) / 2;
	        int partitions = countPartitions(arr, mid);
	        if (partitions > k) low = mid + 1;
	        else high = mid - 1;
	    }
	    return low;
	}
	private static int countPartitions(int[] arr, int maxSum) {
	    int partitions = 1;
	    int subArraySum = 0;
	    for (int num: arr) {
	        if (subArraySum + num <= maxSum) {
	            subArraySum += num;
	        } else {
	            partitions++;
	            subArraySum = num;
	        }
	    }
	    return partitions;
	}
}
