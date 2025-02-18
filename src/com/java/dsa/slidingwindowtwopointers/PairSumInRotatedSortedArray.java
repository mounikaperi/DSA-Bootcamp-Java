package com.java.dsa.slidingwindowtwopointers;

// Java code to check whether any pair exists
// whose sum is equal to the given target value

import java.util.HashSet;
class PairSumInRotatedSortedArray {
    static boolean pairInSortedRotatedHashing(int[] arr, int target){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {

            // Calculate the complement that added to
            // arr[i], equals the target
            int complement = target - arr[i];

            // Check if the complement exists in the set
            if (set.contains(complement)) {
                return true;
            }

            // Add the current element to the set
            set.add(arr[i]);
        }
        
        // If no pair is found
        return false;
    }
    static boolean pairInSortedRotated(int[] arr, int target) {
        int n = arr.length;
        int i;
        for (i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1])
                break;
        // l is now index of smallest element
        int l = (i + 1) % n;
        // r is now index of largest element
        int r = i;
        // Keep moving either l or r till they meet
        while (l != r) {
            // If we find a pair with sum target, return true
            if (arr[l] + arr[r] == target)
                return true;
            // If current pair sum is less, move to higher sum
            if (arr[l] + arr[r] < target)
                l = (l + 1) % n;
            // Move to lower sum side
            else
                r = (r - 1 + n) % n;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {11, 15, 6, 8, 9, 10};
        int target = 16;
        System.out.println(pairInSortedRotatedHashing(arr, target));
        System.out.println(pairInSortedRotated(arr, target));
    }
}