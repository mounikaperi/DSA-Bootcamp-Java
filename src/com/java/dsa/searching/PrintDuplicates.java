package com.java.dsa.searching;

import java.util.*;

public class PrintDuplicates {
    public static void main(String[] args) {
      int[] arr = {1, 2, 2, 3, 4, 5, 6, 6};
      printRepeating1(arr, 8);
      System.out.println();
      printRepeating2(arr, 8);
      System.out.println();
      printRepeating3(arr, 8);
      System.out.println();
      printRepeating4(arr, 8);
      System.out.println();
    }
    /**
     * First approach: 
     * Exhaustive search or Brute force, for each element in array find if there is some 
     * other element with the same value. This is done using two for loop, first loop to
     * select the elementand second loop to find its duplicate entry
    */
    private static void printRepeating1(int[] arr, int size) {
      System.out.println("Repeating elements are: ");
      for (int i=0; i<size; i++) {
        for (int j=i+1; j<size; j++) {
          if (arr[i] == arr[j])
            System.out.print(" " + arr[i]);
        }
      }
    }
    /**
     * Second approach: Sorting, Sort all the elements in the array and after this in a single scan, we can 
     * find the duplicates.\
    */
    private static void printRepeating2(int[] arr, int size) {
      Arrays.sort(arr);
      System.out.println("Repeating elements are: ");
      for (int i=1; i<size; i++) {
        if (arr[i] == arr[i-1])
          System.out.print(" " + arr[i]);
      }
    }
    /**
     * Third approach: Hash-Table, using Hash-Table, we can keep track of the elements
     * we have already seen and we can find the duplicates in just one scan.
    */
    private static void printRepeating3(int[] arr, int size) {
      HashSet<Integer> hs = new HashSet<>();
      System.out.println("Repeating elements are: ");
      for (int i=0; i<size; i++) {
        if (hs.contains(arr[i]))
          System.out.print(" " + arr[i]);
        else 
          hs.add(arr[i]);
      }
    }
    /**
     * Forth approach: Counting, this approach is only possible if we know the 
     * range of the input. If we know that, the elements in the array are in 
     * the range 0 to n-1. We can reserve and array of length n and when we see 
     * an element we can increase its count. In just one single scan, we know the 
     * duplicates. If we know the range of the elements, then this is the 
     * fastest way to find the duplicates.
    */
    private static void printRepeating4(int[] arr, int size) {
      int[] count = new int[size];
      for (int i=0; i<size; i++) {
        count[i] = 0;
      }
      System.out.println(" Repeating elements are ");
      for(int i = 0; i < size; i++) {
        if(count[arr[i]] == 1)
          System.out.print(" " + arr[i]);
        else
          count[arr[i]]++;
      }
    }
}