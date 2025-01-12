package com.java.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertMergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        int[] newInterval = {5, 6};

        ArrayList<int[]> res = mergeOverlapNaive(intervals, newInterval);
        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        res = mergeOverlapOptimal(intervals, newInterval);
        for (int[] interval : res) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
    static ArrayList<int[]> mergeOverlapNaive(int[][] arr, int[] newInterval) {
        ArrayList<int[]> intervalList =
                new ArrayList<>(Arrays.asList(arr));
        intervalList.add(newInterval);
        arr = intervalList.toArray(new int[0][]);
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> res = new ArrayList<>();
        res.add(arr[0]);
        for (int i=1; i<arr.length; i++) {
            int[] last = res.get(res.size()-1);
            int[] curr = arr[i];
            if (curr[0] <= last[1]) last[1] = Math.max(curr[1], last[1]);
            else res.add(curr);
        }
        return res;
    }
    static ArrayList<int[]> mergeOverlapOptimal(int[][] arr, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int resIndex = 0; int i=0; int n = arr.length;
        while (i< n && arr[i][1] < newInterval[0]) {
            res.add(arr[i]);
            i++;
        }
        while (i<n && arr[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], arr[i][0]);
            newInterval[1] = Math.max(newInterval[1], arr[i][1]);
            i++;
        }
        res.add(newInterval);
        // add all remaining intervals
        while (i < n) {
            res.add(arr[i]);
            i++;
        }
        return res;
    }
}
