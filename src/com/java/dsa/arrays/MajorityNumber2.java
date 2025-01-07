package com.java.dsa.arrays;

import java.util.*;

public class MajorityNumber2 {
    // https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/majority-vote
    public static void main(String[] args) {
      int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
      List<Integer> ans = findMajority(arr);
      for (int num: ans) System.out.print(num + " ");
    }
    private static List<Integer> findMajority(int[] nums) {
      int n = nums.length;
      int element1 = -1;
      int element2 = -1;
      int count1 = 0;
      int count2 = 0;
      for (int num: nums) {
        if (num == element1) count1++;
        if (num == element2) count2++;
        else if (count1 == 0) {
          element1 = num;
          count1++;
        } else if (count2 == 0) {
          element2 = num;
          count2++;
        } else {
          count1--;
          count2--;
        }
      }
      List<Integer> result = new ArrayList<>();
      count1 = 0;
      count2 = 0;
      for (int element: nums) {
        if (element == element1) count1++;
        if (element == element2) count2++;
      }
      if (count1 > (n/3)) result.add(element1);
      if (count2 > (n/3) && element1 != element2) result.add(element2);
      if (result.size() == 2 && result.get(0) > result.get(1)) {
        int temp = result.get(0);
        result.set(0, result.get(1));
        result.set(1, temp);
      }
      return result;
    }
}