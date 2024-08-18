package com.java.dsa.arrays;
class FindSingleElementInArray {
    public static void main(String[] args) {
        // https://leetcode.com/problems/single-number/description/
        int[] arr = {4,1,2,1,2};
        System.out.println("Single element in array: " + singleNumber(arr));
    }
    private static int singleNumber(int[] arr) {
        // xor all the elements
        // element ^ 0 is same element
        // element ^ element is 0
        // 4 ^ 1  ^ 2 ^ 1 ^ 2
        // 4 ^ (1 ^ 1) ^ (2 ^ 2)
        // 4 ^ 0 ^ 0 = 4
        int xor = 0;
        for (int i=0; i<arr.length; i++) {
            xor = xor ^ arr[i];
        }
        
        return xor;
    }
}
