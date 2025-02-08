package com.java.dsa.prefixsum;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 3};
        System.out.println(findEquilibriumIndexNaive(arr));
        System.out.println(findEquilibriumIndexPrefixSum1(arr));
        System.out.println(findEquilibriumIndexPrefixSum2(arr));
    }
    static int findEquilibriumIndexNaive(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int leftSum = 0;
            for (int j=0; j<i; j++)
                leftSum += arr[j];
            int rightSum = 0;
            for (int j=i+1; j<arr.length; j++)
                rightSum += arr[j];
            if (leftSum == rightSum)
                return i;
        }
        return -1;
    }
    static int findEquilibriumIndexPrefixSum1(int[] arr) {
        int n = arr.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        pref[0] = arr[0];
        suff[n-1] = arr[n-1];
        for (int i=1; i<n; i++) {
            pref[i] = pref[i-1] + arr[i];
        }
        for (int i=n-2; i>=0; i--) {
            suff[i] = suff[i+1] + arr[i];
        }
        for (int i=0; i<n; i++) {
            if (pref[i] == suff[i])
                return i;
        }
        return -1;
    }
    static int findEquilibriumIndexPrefixSum2(int[] arr) {
        int prefixSum = 0, total = 0;
        for (int element: arr) {
            total += element;
        }
        for (int i=0; i<arr.length; i++) {
            int suffSum = total - prefixSum - arr[i];
            if (prefixSum == suffSum)
                return i;
            prefixSum += arr[i];
        }
        return -1;
    }
}
