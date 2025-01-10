package com.java.dsa.arrays;

public class AllAntsFallOffPlank {
    public static void main(String[] args) {
        int n = 4;
        int[] left = {2};
        int[] right = {0, 1, 3};
        System.out.println(getLastMoment(n, left, right));
    }
    static int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for (int i=0; i<left.length; i++) res = Math.max(res, left[i]);
        for (int i=0; i<right.length; i++) res = Math.max(res, n-right[i]);
        return res;
    }
}
