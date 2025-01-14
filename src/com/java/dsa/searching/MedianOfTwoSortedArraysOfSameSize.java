package com.java.dsa.searching;

import java.util.Arrays;

public class MedianOfTwoSortedArraysOfSameSize {
    public static void main(String[] args) {
        int[] a = { 1, 12, 15, 26, 38 };
        int[] b = { 2, 13, 17, 30, 45 };

        System.out.println(getMedianNaive(a, b));
        System.out.println(getMedianMergeSort(a, b));
        System.out.println(getMedianOptimal(a, b));
    }
    static double getMedianNaive(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int index = 0;
        for (int i=0; i<a.length; i++)
            c[index++] = a[i];
        for (int j=0; j<b.length; j++)
            c[index++] = b[j];
        Arrays.sort(c);
        int mid1 = c.length / 2;
        int mid2 = mid1 - 1;
        return (c[mid1] + c[mid2]) / 2.0;
    }
    static double getMedianMergeSort(int[] a, int[] b) {
        /*
        Given arrays are sorted. merge the sorted arrays in an efficient way and keep the
        count of elements processed so far. So, when we reach half of the total, print median
        The median will be the average of elements at index (n-1) and n in the array
        obtained after merging both the arrays
         */
        int n = a.length;
        int i=0, j=0;
        int count;
        int m1 = -1, m2=-1; // m1 to store the index of n, m2 to store the index of n-1
        for (count=0; count <= n; count++) {
            m2 = m1;
            if (i<n && j<n) {
                if (a[i]>b[j]) m1 = b[j++]; // if a has larger element than b then consider b
                else m1 = a[i++]; // if a has smaller element then consider a
            }
            else if (i<n) // if a has remaining elements
                m1 = a[i++];
            else
                m1 = b[j++];
        }
        return (m1+m2)/2.0;
    }
    static double getMedianOptimal(int[] a, int[] b) {
        int n = a.length;
        int low = 0, high=n;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = n-mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE: a[mid1-1];
            int r1 = (mid1 == n) ? Integer.MAX_VALUE: a[mid1];

            int l2 = (mid2 == 0) ? Integer.MIN_VALUE: b[mid2-1];
            int r2 = (mid2 == n) ? Integer.MAX_VALUE: b[mid2];

            if (l1 <= r2 && l2 <= r1) // valid partition
                return (Math.max(l1,l2) + Math.min(r1, r2)) / 2.0;
            if (l1 > r2)
                high = mid1-1;
            else
                low = mid1+1;
        }
        return 0;
    }
}
