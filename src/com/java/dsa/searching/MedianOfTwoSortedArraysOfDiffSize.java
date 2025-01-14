package com.java.dsa.searching;

import java.util.Arrays;

public class MedianOfTwoSortedArraysOfDiffSize {
    public static void main(String[] args) {
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };

        System.out.println(getMedianNaive(arr1, arr2));
        System.out.println(getMedianMergeSort(arr1, arr2));    }
    static double getMedianNaive(int[] a, int[] b) {
        int length = a.length+b.length;
        int[] c = new int[length];
        int index = 0;
        for (int i=0; i<a.length; i++) c[index++] = a[i];
        for (int j=0; j<b.length; j++) c[index++] = b[j];
        Arrays.sort(c);
        if ((length) % 2 == 0)
            return (c[length/2] + c[length/2-1]) / 2.0;
        return c[length/2];
    }
    static double getMedianMergeSort(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int i=0, j=0, count=0;
        int m1 = -1, m2=-1;
        for (count = 0; count < (m+n) /2 ; count++) {
            m2 = m1;
            // if both the arrays have remaining elements
            if (i < n && j < m)
                m1 = (a[i]>b[j]) ? b[j++]: a[i++];
            else if (i<n) // remaining elements of a[]
                m1 = a[i++];
            else if (j<m) // remaining elements of b[]
                m1 = b[j++];
        }
        if ((m1+m2)%2==0) return (m1+m2)/2.0;
        return m1;
    }
    static double getMedianOptimal(int[] a, int[] b) {
        int n = a.length, m = b.length;
        if (n>m) return getMedianOptimal(b, a);// this helps in reducing time complexity O(log(min(m, n))
        int low = 0, high = n;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (n + m + 1) / 2 - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE: a[mid1-1];
            int l2 = (mid1 == n) ? Integer.MAX_VALUE: a[mid1];

            int r1 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2-1];
            int r2 = (mid2 == n) ? Integer.MAX_VALUE : b[mid2];

            if (l1<=r2 && l2<=r1) {
                if ((n+m)%2==0) return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else {
                return Math.max(l1, l2);
            }
            if (l1 > r2) high = mid1 - 1; // check if we need to take fewer elements from a
            else low = mid1 + 1;
        }
        return 0;
    }
}
