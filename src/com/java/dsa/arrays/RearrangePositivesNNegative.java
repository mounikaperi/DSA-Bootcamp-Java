package com.java.dsa.arrays;

import java.util.*;

public class RearrangePositivesNNegative {
    public static void main(String[] args) {
      int[] nums = {3,1,-2,-5,2,-4};
      int[] rearrangedArray = rearrangeArray(nums);
      System.out.println("The rearrangedArray is: " + Arrays.toString(rearrangedArray));
    }
    private static int[] rearrangeArray(int[] nums) {
      int length = nums.length;
      ArrayList<Integer> positives = new ArrayList<>();
      ArrayList<Integer> negatives = new ArrayList<>();
      for (int i=0; i<length; i++) {
        if (nums[i] > 0)
          positives.add(nums[i]);
        else
          negatives.add(nums[i]);
      }
      if (positives.size() > negatives.size()) {
        for (int i=0; i<negatives.size(); i++) {
          nums[2*i] = positives.get(i);
          nums[2*i+1] = negatives.get(i);
        }
        int index = negatives.size() * 2;
        for (int i=negatives.size(); i<positives.size(); i++) {
          nums[index] = positives.get(i);
          index++;
        }
      } else {
        for (int i=0; i<positives.size(); i++) {
          nums[2*i] = positives.get(i);
          nums[2*i+1] = negatives.get(i);
        }
        int index = positives.size() * 2;
        for (int i=positives.size(); i<negatives.size(); i++) {
          nums[index] = negatives.get(i);
          index++;
        }
      }
      return nums;
    }
}