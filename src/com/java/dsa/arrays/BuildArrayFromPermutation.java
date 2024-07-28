package com.java.dsa.arrays;

import java.util.Arrays;
public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        int[] arr = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArrayBruteForce(arr)));
        System.out.println(Arrays.toString(buildArrayInConstantTime(arr)));
    }
    static int[] buildArrayBruteForce(int[] arr) {
        int[] result = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            result[i] = arr[arr[i]];
        }
        return result;
    }
    static int[] buildArrayInConstantTime(int[] arr) {
        int CONST = 1001;
        for (int i=0; i<arr.length; i++) {
            int a = arr[i] ;
            int b = arr[a] % CONST;
            arr[i] = a + CONST * b;
        }
        for (int i=0; i<arr.length; i++) {
            arr[i] /= CONST;
        }
        return arr;
    }
}
