package com.java.dsa.sorting;
public class FindDuplicateNumber {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/find-the-duplicate-number/description/
	    int[] arr = {1,3,4,2,2};
	    System.out.println("The Duplicate element is: " + findDuplicateViaCycleSort(arr));
	    System.out.println("The Duplicate element is: " + findDuplicate(arr));
	}
	private static int findDuplicate(int[] arr) {
	    boolean bool[] = new boolean[arr.length];
	    for (int num: arr) {
	        if (bool[num]) return num;
	        bool[num] = true;
	    }
	    return 0;
	}
	private static int findDuplicateViaCycleSort(int[] arr) {
	    int i=0;
	    while (i<arr.length) {
	        int correctIndex = arr[i] - 1;
	        if (arr[i] != arr[correctIndex]) swap(arr, i, correctIndex);
	        else i++;
	    }
	    for (i=0; i<arr.length; i++) {
	        if (arr[i]-1 != i) return arr[i];
	    }
	    return 0;
	}
	private static void swap(int[] arr, int i, int correctIndex) {
	    int temp = arr[i];
	    arr[i] = arr[correctIndex];
	    arr[correctIndex] = temp;
	}
}
