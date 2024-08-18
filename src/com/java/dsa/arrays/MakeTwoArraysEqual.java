package com.java.dsa.arrays;
public class MakeTwoArraysEqual
{
	public static void main(String[] args) {
		int[] target = {1, 2, 3, 4};
		int[] arr = {2, 4, 1, 3};
		System.out.println("Are both target and input arrays equal? " + canBeEqual(target, arr));
	}
	private static boolean canBeEqual(int[] target, int[] arr) {
	    int[] targetArray = new int[1001];
	    int uniqueCount = 0;
	    for (int i=0; i<target.length; i++) {
	        if (targetArray[arr[i]]++ == 0) uniqueCount++;
	        if (targetArray[target[i]]-- == 1) uniqueCount--;
	    }
	    return uniqueCount == 0;
	}
}
