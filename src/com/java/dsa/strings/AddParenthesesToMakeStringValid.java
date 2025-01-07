package com.java.dsa.strings;

import java.util.*;

public class AddParenthesesToMakeStringValid {
  // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
  public static void main(String[] args) {
    String expression = "}}{{";
    int result = getNoOfParenthesesToAdd(expression);
    System.out.println(result);
  }
  private static int getNoOfParenthesesToAdd(String s) {
    int additionsRequired = 0;
    int balanceCount = 0;
    for (char character : s.toCharArray()) {
      if (character == '{') balanceCount++; // An opening parenthesis increments the balance count
      else if (balanceCount > 0) balanceCount--; // A closing parenthesis decrements the balance count if there are unmatched opening ones
      else additionsRequired++; // If there are no unmatched opening, we need an opening parenthesis
    }
    // Add the remaining unmatched opening parentheses to the count of required additions
    additionsRequired += balanceCount;
    return additionsRequired;
  }
}