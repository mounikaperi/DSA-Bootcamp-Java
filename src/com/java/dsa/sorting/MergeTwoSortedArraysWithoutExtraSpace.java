package com.java.dsa.sorting;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        mergeArraysInsertionSort(a, b);
        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");

        mergeArraysUsingKthSmallest(a, b);

        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");

        a = new int[] {1, 5, 9, 10, 15, 20};
        b = new int[] {2, 3, 8, 13};
        mergeArraysSwapNSort(a, b);

        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");

        a = new int[] {1, 5, 9, 10, 15, 20};
        b = new int[] {2, 3, 8, 13};
        mergeArraysGapMethod(a, b);
        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");
    }
    static void mergeArraysInsertionSort(int[] a, int[] b) {
        for (int i=b.length-1; i>=0; i--) {
            if (a[a.length-1] > b[i]) {
                int temp = a[a.length-1];
                int j = a.length-2;
                while (j>=0 && a[j] > b[i]) {
                    a[j+1] = a[j];
                    j--;
                }
                a[j+1]  = b[i];
                b[i] = temp;
            }
        }
    } // o(m*n)
    static void mergeArraysSwapNSort(int[] a, int[] b) {
        int i = a.length-1, j=0;
        while (i>=0 && j<b.length) {
            if (a[i]<b[j]) i--;
            else {
                int temp = b[j];
                b[j] = a[i];
                a[i] = temp;
                i--;
                j++;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    } // O(m+n) + mlogn + nlogm
    static int kthSmallest(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;
        int lo = 0, hi = n, idx = 0;
        while (lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = k - mid1;

            // We don't have mid2 elements in b[], so pick more
            // elements from a[]
            if (mid2 > m) {
                lo = mid1 + 1;
                continue;
            }

            // Find elements to the left and right of partition in a[]
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : a[mid1]);

            // Find elements to the left and right of partition in b[]
            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
            int r2 = (mid2 == m ? Integer.MAX_VALUE : b[mid2]);

            // If it is a valid partition
            if (l1 <= r2 && l2 <= r1) {
                idx = mid1;
                break;
            }

            // Check if we need to take lesser elements from a[]
            if (l1 > r2)
                hi = mid1 - 1;

                // Check if we need to take more elements from a[]
            else
                lo = mid1 + 1;
        }
        return idx;
    }
    static void mergeArraysUsingKthSmallest(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int idx = kthSmallest(a, b, n);

        // Move all smaller elements in a[]
        for (int i = idx; i < n; i++) {
            int temp = a[i];
            a[i] = b[i - idx];
            b[i - idx] = temp;
        }

        // Sort both a[] and b[]
        Arrays.sort(a);
        Arrays.sort(b);
    }
    static void mergeArraysGapMethod(int[] a, int[] b) {
        /*
            - The idea is to assume two arrays as a single continous array of size n+m and sort it using gap method
            - here we adjust the indices according to whether it lies in a or b arrays
            - and if indices lie in b then adjust the indices by subtracting n from it.

            - Assume two arrays as a single continuous array of size n+m and find the gap = ceil(n+m/2)
            - Until the gap doesn't become zero, perform the following operations
                - Take two pointers left and right, place then at 0 and left+gap respectively
                - Run loop until right is less than n+m
                - 3 different cases inside loop:
                    - when both left and right pointers are in a[], if a[left]>a[right] swap
                    - when left is in a[] and right is in b[], if a[left]>b[right-m] swap
                    - when both left and right pointers are in b[], if b[left]>b[right-m] swap
                - if the right pointer reaches end, m+n decrement the gap by ceil(gap/2)
         */
        int n = a.length, m = b.length;
        int gap = (n+m+1)/2;
        while (gap > 0) {
            int leftPointer = 0, rightPointer = leftPointer + gap;
            while (rightPointer < (n+m)) {
                // if both pointers are in a[]
                if (rightPointer<n && a[leftPointer]>b[rightPointer]) {
                    // if both pointers are in a[]
                    swap(a, leftPointer, rightPointer);
                } else if (leftPointer < n && rightPointer >= n && a[leftPointer] > b[rightPointer-n]) {
                    // if the left pointer is in a and right pointer is in b
                    int temp = a[leftPointer];
                    a[leftPointer] = b[rightPointer-n];
                    b[rightPointer-n] = temp;
                } else if (leftPointer >= n && rightPointer >= n && b[leftPointer-n] > b[rightPointer-n]) {
                    // If the left pointer and right pointer both are in b[]
                    swap(b, leftPointer-n, rightPointer-n);
                }
                leftPointer++;
                rightPointer++;
            }
            if (gap == 1) break;
            gap = (gap+1)/2;
        }
    } // O(m+n)*O(log(m+n))
    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
