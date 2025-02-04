package com.java.dsa.slidingwindowtwopointers;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    String s = "abcabcbb";
    System.out.println("BruteForce: The length of the longest substring is: " + lengthOfLongestSubstring(s)); 
    System.out.println("SlidingWindow: The length of the longest substring is: " + lengthOfLongestSubstringUsingSlidingWindow(s)); 
  }
  private static int lengthOfLongestSubstring(String s) { // O(n^2)
    if (s.length() == 0) return 0;
    if (s.length() == 1) return 1;
    int maxLength = 0;
    for (int i=0; i<s.length()-1; i++) {
      int[] hash = new int[256];
      for (int j=i; j<s.length()-1; j++) {
        if (hash[s.charAt(j)] == 1) break;
        maxLength = Math.max(maxLength, j-i+1);
        hash[s.charAt(j)] = 1;
      }
    }
    return maxLength;
  }
  private static int lengthOfLongestSubstringUsingSlidingWindow(String s) {
    if (s.length() == 0) return 0;
    if (s.length() == 1) return 1;
    int[] hash = new int[256];
    Arrays.fill(hash, -1);
    int left = 0;
    int right = 0;
    int maxLength = 0;
    while (right < s.length()-1) {
      if (hash[s.charAt(right)] != -1) {
        if (hash[s.charAt(right)] >= left) {
          left = hash[s.charAt(right)] + 1;
        }
      }
      maxLength = Math.max(maxLength, right-left+1);
      hash[s.charAt(right)] = right;
      right++;
    }
    return maxLength;
  }
}