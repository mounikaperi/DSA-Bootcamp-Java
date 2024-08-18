package com.java.dsa.sorting;
import java.util.Arrays;
public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 4, 3};
        System.out.println("Sorted Array is: " + Arrays.toString(cycleSort(arr)));
    }
    private static int[] cycleSort(int[] arr) {
        int i=0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }
        return arr;
    }    
    private static void swap(int[] arr, int i, int correctIndex) {
        int temp = arr[i];
        arr[i] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
