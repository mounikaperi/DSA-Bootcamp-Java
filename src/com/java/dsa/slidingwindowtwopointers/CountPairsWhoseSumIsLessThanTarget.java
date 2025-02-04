package com.java.dsa.slidingwindowtwopointers;

import java.util.Arrays;

public class CountPairsWhoseSumIsLessThanTarget {
    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 3, 4, 7, 6, 5};
        int target = 7;
        System.out.println(countPairsNaive(arr, target));
        System.out.println(countPairsBinarySearch(arr, target));
        System.out.println(countPairsTwoPointers(arr, target));
    }

    // Brute Force- Generate All Pairs - O(n^2) TC and O(1) SC
    static int countPairsNaive(int[] arr, int target) {
        int count = 0;
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] + arr[j] < target)
                    count++;
            }
        }
        return count;
    }

    /*
        BinarySearch: O(2*nlogn) TC and O(1) SC
        Sort the array
        calculate the complement -> target - arr[i]
        Find first element in the array which is greater than or equal to the complement using binarysearch
        All the elements which appear before that will make a valid pair with current element having sum
        less than given target.
        Also, handle a case where an element pairs itself. Since, each pair is counted twice, totalcount
        should be divided by 2
     */
    static int countPairsBinarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            int complement = target - arr[i];
            int index = binarySearch(arr, complement);
            count += index;
            if (index > i) count--;
        }
        return count / 2;
    }
    static int binarySearch(int[] arr, int target) {
        int result = 0, low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid] >= target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /*
    Two pointer approach: O(nlogn+n) TC, O(1) SC
    */
    static int countPairsTwoPointers(int[] arr, int target) {
        Arrays.sort(arr);
        int count =0, left=0, right=arr.length-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum >= target) right--;
            else {
                count += (right - left);
                left++;
            }
        }
        return count;
    }
}
