package com.java.dsa.sorting;
import java.util.List;
import java.util.ArrayList;
public class FindAllMissingNumbersInArray {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
	    int[] arr = {4,3,2,7,8,2,3,1};
	    System.out.println("The missing numbers are: " + findMissingNumbers(arr));
	}
	private static List<Integer> findMissingNumbers(int[] arr) {
	    List<Integer> list = new ArrayList<Integer>();
	    int i = 0;
	    while (i < arr.length) {
	        int correctIndex = arr[i] - 1;
	        if (arr[i] != arr[correctIndex]) swap(arr, i, correctIndex);
	        else i++;
	    }
	    for (i=0; i<arr.length; i++) {
	        if (arr[i] - 1 != i) list.add(i+1);
	    }
	    return list;
	}
	private static void swap(int[] arr, int i, int correctIndex) {
	    int temp = arr[i];
	    arr[i] = arr[correctIndex];
	    arr[correctIndex] = temp;
	}
}
