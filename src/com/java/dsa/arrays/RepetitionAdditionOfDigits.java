package com.java.dsa.arrays;

public class RepetitionAdditionOfDigits {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int k = 2;
        System.out.println(maxOnes(arr, k));
        System.out.println(maxOnesUsingSlidingWindow(arr, k));
    }
    static int maxOnes(int[] arr, int k) {
        int res = 0;
        for (int i=0; i<arr.length; i++) {
            int count = 0;
            for (int j=i; j<arr.length; j++) {
                if (arr[j] == 0) count++;
                if (count <= k) res = Math.max(res, (j-i+1));
            }
        }
        return res;
    }
    static int maxOnesUsingSlidingWindow(int[] arr, int k) {
        /*
            The idea is to use two pointers, start and end to mark the start and end pointers of the current subarray.

            Intitally, both pointers are set to the beginning of the array
            Continuously, increase the size of the current window by incrementing the end pointer while keeping track of
            the count of zeros within the window.

            If at any point the count of zeros exceeds k, shrink the window by incrementing the start pointer until the
            count is reduced to k. The result will be the maximum length among all windows that contains at most k zeros
         */
        int res=0;
        int start=0, end =0;
        int count=0;
        while (end < arr.length) {
            if (arr[end] == 0) count++;
            while (count > k) {
                // Shrink the window from left if no of zeros are greater than k
                if (arr[start] == 0) count--;
                start++;
            }
            res = Math.max(res, (end-start+1));
            end++;
        }
        return res;
    }
}
