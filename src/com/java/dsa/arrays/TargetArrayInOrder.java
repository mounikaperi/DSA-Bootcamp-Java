package com.java.dsa.arrays;

import java.util.*;

public class TargetArrayInOrder {
    public static void main(String[] args) {
        // https://leetcode.com/problems/create-target-array-in-the-given-order/description/
        int[] arr = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        System.out.println("Created Target Array in given Order: " + Arrays.toString(createTargetArray(arr, index)));
    }
    public static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] target = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            target[i] = list.get(i);
        }
        return target;
    }
}
