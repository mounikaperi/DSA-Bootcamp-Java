package com.java.dsa.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class FormBiggestNumber {
    public static void main(String[] args) {
        int[] arr = { 3, 30, 34, 5, 9 };
        System.out.println(findLargest(arr));
    }
    static boolean myCompare(String s1, String s2) {
        return (s1 + s2).compareTo(s2 + s1) > 0;
    }
    static String findLargest(int[] arr) {
        ArrayList<String> numbers = new ArrayList<>();
        for (int element: arr) numbers.add(Integer.toString(element));
        Collections.sort(numbers, (s1, s2) -> myCompare(s1, s2) ? -1: 1); // -1 means s1 should come before s2, 1 means s2 should come before s1
        if (numbers.get(0).equals("0")) return "0"; // as numbers is sorted in desc order, if zero in front means complete array is zero
        StringBuilder res = new StringBuilder();
        for(String num: numbers) res.append(num);
        return res.toString();
    }
}
