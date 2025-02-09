package com.java.dsa.prefixsum;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = {10, 3, 5, 6, 2};
        int[] res1 = productExceptSelfNaive(arr);
        System.out.println(Arrays.toString(res1));
        int[] res2 = productExceptSelfPrefixArray(arr);
        System.out.println(Arrays.toString(res2));
        int[] res3 = productExceptSelf(arr);
        System.out.println(Arrays.toString(res3));
    }
    static int[] productExceptSelfNaive(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i!=j) {
                    res[i] *= arr[j];
                }
            }
        }
        return res;
    }
    static int[] productExceptSelfPrefixArray(int[] arr) {
        int n = arr.length;
        int[] prefProduct = new int[n];
        int[] suffProduct = new int[n];
        int[] res = new int[n];
        prefProduct[0] = 1;
        for (int i=1; i<n; i++) {
            prefProduct[i] = arr[i-1] * prefProduct[i-1];
        }
        suffProduct[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            suffProduct[i] = arr[i+1] * suffProduct[i+1];
        }
        for (int i=0; i<n; i++) {
            res[i] = prefProduct[i] * suffProduct[i];
        }
        return res;
    }
    static int[] productExceptSelf(int[] arr) {
        /*
        The idea is to handle two special cases of the input array:
        when it contains zero and when it doesn't

        if the array has no zeros, product of the array at any index exluding
        itself, can be calculated by dividing the total product of all elements
        by the current element

        However, division by zero is undefined, so if there are zeros in the array
        the logic changes. If there is exactly one zero, the product for that index
        will be the product of all other non-zero elements, while the elements in
        rest of the indices will be zero

        if there are more than one zero, the product of all indices will be zero,
        since multiplying by zero results in zero
         */

        int zeros = 0, index=-1, prod = 1, n=arr.length;
        for (int i=0; i<n; i++) {
            if (arr[i] == 0) {
                zeros++;
                index = i;
            } else {
                prod *= arr[i];
            }
        }
        int[] res = new int[n];
        Arrays.fill(res, 0);
        if (zeros == 0) {
            for (int i=0; i<n; i++)
                res[i] = prod / arr[i];
        } else if (zeros == 1) {
            res[index] = prod;
        }
        return res;
    }
}
