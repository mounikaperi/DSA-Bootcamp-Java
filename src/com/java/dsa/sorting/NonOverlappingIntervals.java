package com.java.dsa.sorting;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(minRemoval(intervals));
        System.out.println(minRemovalEndPoints(intervals));
    }
    // By sorting start points
    static int minRemoval(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int end = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] < end) {
                // If the current starting point is less than the previous interval's ending point then it's an overlap
                count++;
                end = Math.min(intervals[i][1], end);
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
    // By sorting end points
    static int minRemovalEndPoints(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
