package com.java.dsa.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        // https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        System.out.println("intersection-of-two-arrays: " + Arrays.toString(intersection(arr1, arr2)));
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
}
