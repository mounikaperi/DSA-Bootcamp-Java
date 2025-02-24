package com.java.dsa.recursion;

import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
      int[] arr = {5, 4, 3, 2, 1};
      mergeSortInPlace(arr, 0, arr.length);
      System.out.println(Arrays.toString(arr));
  }
  static void mergeSortInPlace(int[] arr, int start, int end) {
    if (end-start == 1) {
      return;
    }
    int mid = (start + end ) / 2;
    mergeSortInPlace(arr, start, mid);
    mergeSortInPlace(arr, mid, end);
    mergeInPlace(arr, start, mid, end);
  }
  static void mergeInPlace(int[] arr, int start, int mid, int end) {
    int[] result = new int[end-start];
    int i=0, j=0, k=0;
    while (i<mid && j<end) {
      if (arr[i] < arr[j] ) {
        result[k] = arr[i];
        i++;
      } else {
        result[k] = arr[j];
        j++;
      }
      k++;
    }
    while (i < mid) {
      result[k] = arr[i];
      i++;
      k++;
    }
    while (j < end) {
      result[k] = arr[j];
      j++;
      k++;
    }
    for (int l = 0; l < result.length; l++) {
      arr[starts+l] = result[l];
    }
  }
}
