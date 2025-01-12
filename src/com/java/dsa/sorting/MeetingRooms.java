package com.java.dsa.sorting;

import java.util.Arrays;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] arr = {{2, 4}, {1, 2}, {7, 8}, {5, 6}, {6, 8}};
        System.out.println(canAttend(arr));
        System.out.println(canAttendExpected(arr));
    }
    static boolean canAttend(int[][] arr) {
        int n = arr.length;
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (isOverlap(arr[i], arr[j])) return false;
            }
        }
        return true;
    }
    static boolean isOverlap(int[] meet1, int[] meet2) {
        return ((meet1[0] >= meet2[0] && meet1[0] <meet2[1])
                || (meet2[0] >= meet1[0] && meet2[0] <meet1[1]));
    }
    static boolean canAttendExpected(int[][] arr) {
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        // { 1, 2}, {2, 4}, {5, 6}, {6, 8}, {7, 8}
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i][1] > arr[i+1][0]) return false;
        }
        return true;
    }
}