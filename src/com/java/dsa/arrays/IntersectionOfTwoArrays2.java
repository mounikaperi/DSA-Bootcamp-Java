package com.java.dsa.arrays;

import java.util.*;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        // https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        System.out.println("intersection-of-two-arrays: " + Arrays.toString(intersection(arr1, arr2)));
        System.out.println(intersectionWithDuplicates(arr1, arr2));
    }
    private static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> occurrenceTable = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num: nums1) {
            occurrenceTable.put(num, occurrenceTable.getOrDefault(num, 0) + 1);
        }
        for (int n: nums2) {
            if (occurrenceTable.containsKey(n) && occurrenceTable.get(n) >= 1) {
                result.add(n);
                occurrenceTable.put(n, occurrenceTable.get(n) - 1);
            }
        }
        int[] resultArray = result.stream().mapToInt(i -> i).toArray();
        return resultArray;
    }
    public static ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        Set<Integer> resultSet = new HashSet<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i=0; i<a.length; i++) {
            resultSet.add(a[i]);
        }
        for (int i=0; i<b.length; i++) {
            if (resultSet.contains(b[i])) {
                resultList.add(b[i]);
                resultSet.remove(b[i]); // to avoid duplicates
            }
        }
        return resultList;
    }
}
