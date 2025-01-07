package com.java.dsa.arrays;

import java.util.Arrays;
public class ArrayEasyProblems1 {
	public static void main(String[] args) {
	    int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
	    int largestElement = getLargestElement(arr);
	    System.out.println("The largest element in array is: " + largestElement);
	    int smallestElement = getSmallestElement(arr);
	    System.out.println("The smallest element in array is: " + smallestElement);
	    int secondLargestElement = getSecondLargestElement(arr);
	    System.out.println("The second largest element in array is: " + secondLargestElement);
	    int secondSmallestElement = getSecondSmallestElement(arr);
	    System.out.println("The second smallest element in array is: " + secondSmallestElement);
	    boolean isArraySorted = IsInputArraySorted(arr);
	    System.out.println("Is Array sorted: " + isArraySorted);
	    boolean isArrayRotated = isInputArraySortedNRotated(arr);
	    System.out.println("Is Array rotated: " + isArrayRotated);
	    int[] arr1 = {10, 10, 20, 20, 30, 40, 50};
	    int[] result = removeDuplicates(arr1);
	    System.out.println("Array after removing duplicates: " + Arrays.toString(result));
	}
	private static int getLargestElement(int[] arr) {
	    int largestElement = arr[0];
	    for (int i=1; i<arr.length; i++) {
	        if (arr[i] > largestElement)
	            largestElement = arr[i];
	    }
	    return largestElement;
	}
	private static int getSmallestElement(int[] arr) {
	    int smallestElement = arr[0];
	    for (int i=1; i<arr.length; i++) {
	        if (arr[i] < smallestElement) {
	            smallestElement = arr[i];
	        }
	    }
	    return smallestElement;
	}
	private static int getSecondLargestElement(int[] arr) {
	    int largestElement = Integer.MIN_VALUE;
	    int secondLargestElement = Integer.MIN_VALUE;
	    for (int i=0; i<arr.length; i++) {
	        if (arr[i] > largestElement) {
	            secondLargestElement = largestElement;
	            largestElement = arr[i];
	        } else if (arr[i] > secondLargestElement && arr[i] != largestElement) {
	            secondLargestElement = arr[i];
	        }
	    }
	    return secondLargestElement;
	}
	private static int getSecondSmallestElement(int[] arr) {
	    int smallestElement = Integer.MAX_VALUE;
	    int secondSmallestElement = Integer.MAX_VALUE;
	    for (int i=0; i<arr.length; i++) {
	        if (arr[i] < smallestElement) {
	            secondSmallestElement = smallestElement;
	            smallestElement = arr[i];
	        } else if (arr[i] < secondSmallestElement && arr[i] != smallestElement) {
	            secondSmallestElement = arr[i];
	        }
	    }
	    return secondSmallestElement;
	}
	private static boolean IsInputArraySorted(int[] arr) {
	    if (arr.length == 0 || arr.length == 1) return true;
	    for (int i=0; i<arr.length-1; i++) {
	        if (arr[i] > arr[i+1] && arr[i] != arr[i+1]) return false;
	    }
	    return true;
	}
	private static boolean isInputArraySortedNRotated(int[] arr) {
	   int rotationCount = 0;
	   int n = arr.length;
	   for (int i=0; i<n; i++) {
	       if (arr[i] > arr[(i+1) % n]) {
	           ++rotationCount;
	       }
	   }
	   return rotationCount <= 1;
	}
	private static int[] removeDuplicates(int[] arr) {
	    int i=0;
	    for (int j=1; j<arr.length; j++) {
	        if (arr[i] != arr[j]) {
	            i++;
	            arr[i] = arr[j];
	        }
	    }
	    return Arrays.copyOfRange(arr, 0, i+1);
	}
}
