package com.java.dsa.hashing;

import com.java.dsa.recursion.IntegerPermutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionIntoMinSetsOfConsecutiveNumbers {
    public static void main(String args[]) {
        int[] arr = {100, 56, 5, 6, 102, 58, 101, 57, 7, 103};
        System.out.println(minSubsetsNaive(arr));
        System.out.println(minSubsets(arr));
    }
    static int minSubsetsNaive(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] + 1 != arr[i+1]) {
                count++;
            }
        }
        return count;
    }
    static int minSubsets(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num: arr) {
            set.add(num);
        }
        int count = 0;
        for (int num: arr) {
            if (!set.contains(num-1)) {
                count++;
            }
        }
        return count;
    }
}
