package com.java.dsa.searching;

import java.util.*;

public class MajorityRepeatedNumber {
    public static void main(String[] args) {
      // Given an array of n elements. Find the majority element, which appears 
      // more than n/2 times. Return 0 in case there is no majority element.
      int[] arr = {1, 2, 2, 3, 3, 3, 4, 3, 3, 5};
      System.out.println("Majority repeated element > (n/2) is: " + getMajority1(arr, 10));
      System.out.println("Majority repeated element > (n/2) is: " + getMajority2(arr, 10));
      System.out.println("Majority repeated element > (n/2) is: " + getMajority3(arr, 10));
    }
    /**
     * First approach: Exhaustive search or Brute force, for each element in array
     * find how many times this particular value appears in array. Keep track of 
     * the maxCount and when some element count is greater than it then update 
     * the maxCount. This is done using two for loop, first loop to select the 
     * element and second loop to count the occurrence of that element. Once we have
     * the final, maxCount we can see if it is greater than n/2, if it is greater 
     * than we have a majority if not we do not have any majority.
    */ 
    private static int getMajority1(int[] arr, int size) {
      int max = 0;
      int count = 0;
      int maxCount = 0;
      for (int i=0; i<size; i++) {
        for (int j=i+1;j<size; j++) {
          if (arr[i] == arr[j]) count++;
        }
        if (count > maxCount) {
          max = arr[i];
          maxCount = count;
        }
      }
      if (maxCount > size/2) return max;
      return Integer.MIN_VALUE;
    }
    /**
     * Second approach: Sorting, Sort all the elements in the array. If there is 
     * a majority than the middle element at the index n/2 must be the majority 
     * number. So just single scan can be used to find its count and see if the 
     * majority is there or not.
     */
    private static int getMajority2(int[] arr, int size) {
      // 1, 2, 2, 3, 3, 3, 3, 3, 4, 5
      int majIndex = size/2;
      Arrays.sort(arr);
      int count = 0;
      for (int i = 0; i < size; i++)
        if(arr[i] == arr[majIndex])
          count++;
      if (count >= size/2)
        return arr[majIndex];
      else
        return Integer.MIN_VALUE;
    }
    /**
     * Third approach: This is a cancelation approach (Moore’s Voting Algorithm), 
     * if all the elements stand against the majority and each element is cancelled
     * with one element of majority if there is majority then majority prevails.
     * · Set the first element of the array as majority candidate and initialize the count to be 1.
     * · Start scanning the array.
     * o If we get some element whose value same as a majority candidate,
     *    then we increase the count.
     * o If we get an element whose value is different from the majority candidate, then we
     *    decrement the count.
     * o If count become 0, that means we have a new majority candidate. Make the 
     *    current candidate as majority candidate and reset count to 1.
     * o At the end, we will have the only probable majority candidate.
     * Now scan through the array once again to see if that candidate we found above 
     * have appeared more than n/2 times.
    */
    private static int getMajority3(int[] arr, int size) {
      int majorityIndex = 0;
      int count = 1;
      int maxCount = 0;
      for (int i=0; i<size; i++) {
        if (arr[majorityIndex] == arr[i]) count++;
        else count--;
        if (count == 0) {
          majorityIndex = i;
          count = 1;
        }
      }
      count = 0;
      for (int i = 0; i < size; i++)
        if(arr[i] == arr[majorityIndex])
          count++;
      if (count >= size/2) return arr[majorityIndex];
      return Integer.MIN_VALUE;
    }
}