package com.java.dsa.strings;

import java.util.*;

public class CountReversals {
  public static void main(String[] args) {
    String expression = "}{{}}{{{";
    int result = countReversals(expression);
    System.out.println(result);
  }
  private static int countReversals(String s) {
    // https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
    if (s.length() == 0) return 0;
    if (s.length() % 2 != 0) return -1;
    Stack<Character> stack = new Stack<>();
    int ans = 0;
    for (char ch: s.toCharArray()) {
      if (ch == '{') stack.push('{');
      else if (ch == '}') {
        if (!stack.isEmpty()) 
          stack.pop();
        else {
          stack.push('{');
          ans++;
        }
      }
    }
    ans += stack.size() / 2;
    return ans;
  }
}