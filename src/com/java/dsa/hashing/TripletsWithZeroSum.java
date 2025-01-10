package com.java.dsa.hashing;

import java.util.ArrayList;
import java.util.List;

public class TripletsWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        ArrayList<ArrayList<Integer>> res = findTriplets(arr);
        for (List<Integer> triplet : res)
            System.out.println(triplet.get(0) + " " + triplet.get(1)
                    + " " + triplet.get(2));
        res = findTripletsExpected(arr);
        for (List<Integer> triplet : res)
            System.out.println(triplet.get(0) + " " + triplet.get(1)
                    + " " + triplet.get(2));
    }
    static ArrayList<ArrayList<Integer>> findTriplets(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length;
        for (int i=0; i<n-2; i++) {
            for (int j=0; j<n-1; j++) {
                for (int k=0; k<n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(i); triplet.add(j); triplet.add(k);
                        result.add(triplet);
                    }
                }
            }
        }
        return result;
    }
    static ArrayList<ArrayList<Integer>> findTripletsExpected(int[] arr) {

    }
}
