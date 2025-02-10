package com.java.dsa.stacks;

import java.util.ArrayList;
import java.util.List;

public class NumberOfGreaterElementsToRight {
    public static void main(String[] args) {
        int[] a = { 3, 4, 2, 7, 5, 8, 10, 6 };
        int Q = 2;
        int[] queries = {0, 5};
        for (int i=0; i<Q; i++) {
            System.out.print(nextGreaterElementsNaive(a, queries[i]) + " ");
        }
        System.out.println();
        nextGreaterElements(a.length, a, Q, queries);
    }
    static int nextGreaterElementsNaive(int[] arr, int index) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > arr[index]) {
                count++;
            }
        }
        return count;
    }
    static void nextGreaterElements(int length, int[] arr, int queries, int[] indices) {
        List<MyPair<Integer, Integer>> result = new ArrayList<>();
        int[] ans = new int[length];
        for (int i=0; i<length; i++) {
            result.add(new MyPair<>(arr[i], i));
        }
        mergeSort(result, ans, 0, length-1);
        for (int i=0; i<queries; i++) {
            int j = indices[i];
            System.out.print(ans[j] + " ");
        }
    }
    static void mergeSort(List<MyPair<Integer, Integer>> result, int[] ans, int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) >> 1;
            mergeSort(result, ans, low, mid);
            mergeSort(result, ans, mid+1, high);
            merge(result, ans, low, mid, high);
        }
    }
    static void merge(List<MyPair<Integer, Integer>> result, int[] ans, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        List<MyPair<Integer, Integer>> arr = new ArrayList<>();
        List<MyPair<Integer, Integer>> brr = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            arr.add(result.get(i + low));
        }
        for (int i = 0; i < n2; i++) {
            brr.add(result.get(i + mid + 1));
        }
        int i = 0;
        int j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (arr.get(i).first < brr.get(j).first) {
                // Finding number of next greater elements
                ans[arr.get(i).second] += n2 - j;
                result.set(k, arr.get(i));
                i++;
                k++;
            } else {
                result.set(k, brr.get(j));
                j++;
                k++;
            }
        }
        while (i < n1) {
            result.set(k, arr.get(i));
            i++;
            k++;
        }
        while (j < n2) {
            result.set(k, brr.get(j));
            j++;
            k++;
        }
    }
}
class MyPair<I extends Number, I1 extends Number> {
    int first;
    int second;
    MyPair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }
}
