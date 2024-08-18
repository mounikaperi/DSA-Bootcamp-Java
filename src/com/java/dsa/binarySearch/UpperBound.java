package com.java.dsa.binarySearch;
public class UpperBound {
	public static void main(String[] args) {
		int[] arr = {3, 5, 8, 9, 15, 19};
        int n = 6, x = 9;
        int ind = upperBound(arr, x, n);
        System.out.println("The upper bound is the index: " + ind);
        int index = upperBoundViaRecursion(arr, 0, n-1, x);
        System.out.println("The upper bound is the index: " + index);
	}
    private static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
    private static int upperBoundViaRecursion(int[] arr, int low, int high, int target) {
        int ans = high + 1;
        if (low > high) return ans;
        int mid = low + ((high-low)/2);
        if (arr[mid] > target) {
            ans = mid;
            ans = upperBoundViaRecursion(arr, low, mid-1, target);
        } else {
            ans = upperBoundViaRecursion(arr, mid+1, high, target);
        }
        return ans;
    }
}
