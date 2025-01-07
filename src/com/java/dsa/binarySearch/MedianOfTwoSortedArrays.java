package com.java.dsa.binarySearch;

public class MedianOfTwoSortedArrays {
   public static void main(String[] args) {
          int[] a = {1, 4, 7, 10, 12};
          int[] b = {2, 3, 6, 15};
          System.out.println("The median of two sorted arrays is " + median(a, b));
    }
    public static double median(int[] a, int[] b) {
    	int leftArrayLength = a.length;
        int rightArrayLength = b.length;
        if (leftArrayLength > rightArrayLength)
            return median(b, a);
        int totalLength = leftArrayLength + rightArrayLength;
        int totalLeftLength = (totalLength + 1) / 2;
        int low = 0; 
        int high = leftArrayLength;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = totalLeftLength - mid1;
            int l1 = (mid1 > 0) ? a[mid1-1]: Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2-1]: Integer.MIN_VALUE;
            int r1 = (mid1 < leftArrayLength) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < rightArrayLength) ? b[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                if (totalLength % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return ((double)(Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
