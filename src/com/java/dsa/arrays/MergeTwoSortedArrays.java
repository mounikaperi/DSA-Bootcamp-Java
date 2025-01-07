package com.java.dsa.arrays;

import java.util.*;

public class MergeTwoSortedArrays {
  public static void main(String[] args) {
    long[] arr1 = {1, 4, 8, 10};
    long[] arr2 = {2, 3, 9};
    int n = 4, m = 3;
    mergeBruteForce(arr1, arr2, n, m);
    mergeOptimal1(arr1, arr2, n, m);
    mergeOptimal2(arr1, arr2, n, m);
    System.out.println("The merged arrays are:");
    System.out.print("arr1[] = ");
    for (int i = 0; i < n; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.print("\narr2[] = ");
    for (int i = 0; i < m; i++) {
       System.out.print(arr2[i] + " ");
    }
    System.out.println();
  }
  private static void mergeBruteForce(long[] arr1, long[] arr2, int n, int m) {
    long[] arr3 = new long[n+m];
    int left = 0, right = 0, index = 0;
    while (left < n && right < m) {
      if (arr1[left] <= arr2[right]) {
        arr3[index] = arr1[left];
        left++;
        index++;
      } else {
        arr3[index] = arr2[right];
        right++;
        index++;
      }
    }
    while (left < n) {
      arr3[index++] = arr1[left++];
    }
    while (right < m) {
      arr3[index++] = arr2[right++];
    }
    // fill back arr3 elements to arr1 and arr2
    for (int i=0; i<(n+m); i++) {
      if (i<n) {
        arr1[i] = arr3[i];
      } else {
        arr2[i-n] = arr3[i];
      }
    }
  }
  private static void mergeOptimal1(long[] arr1, long[] arr2, int n, int m) {
    int left = n-1;
    int right = 0;
    while (left >= 0 && right < m) {
      if (arr1[left] > arr2[right]) {
        long temp = arr1[left];
        arr1[left] = arr2[right];
        arr2[right] = temp;
        left--;
        right++;
      } else {
        break;
      }
    }
    Arrays.sort(arr1);
    Arrays.sort(arr2);
  }
  private static void mergeOptimal2(long[] arr1, long[] arr2, int n, int m) {
    int length = n+m;
    int gap = (length / 2) + (length % 2);
    while (gap > 0) {
      // Step1: Place two pointers in their correct position like the left pointer at index 0 and the right pointer at index (left+gap).
      int left = 0;
      int right = left + gap; 
      /** Step2:
       * Again we will run a loop until the right pointer reaches the end i.e. (n+m). Inside the loop, there will be 3 different cases:
       * If the left pointer is inside arr1[] and the right pointer is in arr2[]: We will compare arr1[left] and arr2[right-n] and swap them if arr1[left] > arr2[right-n].
       * If both the pointers are in arr2[]: We will compare arr1[left-n] and arr2[right-n] and swap them if arr1[left-n] > arr2[right-n].
       * If both the pointers are in arr1[]: We will compare arr1[left] and arr2[right] and swap them if arr1[left] > arr2[right].
       */
      while (right < length) {
        if (left < n && right >= n) {
          swapIfGreater(arr1, arr2, left, right-n);
        } else if (left >= n) {
          swapIfGreater(arr2, arr2, left-n, right-n);
        } else {
          swapIfGreater(arr1, arr1, left, right);
        }
        left++; right++;
      }
      // Step3: After the right pointer reaches the end, we will decrease the value of the gap and it will become ceil(current gap / 2). 
      if (gap == 1) break;
      gap = (gap / 2) + (gap % 2);
    }
  }
  private static void swapIfGreater(long[] arr1, long[] arr2, int index1, int index2) {
    if (arr1[index1] > arr2[index2]) {
      long temp = arr1[index1];
      arr1[index1] = arr2[index2];
      arr2[index2] = temp;
    }
  }
}