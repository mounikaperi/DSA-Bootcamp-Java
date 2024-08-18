package com.java.dsa.recursion;
public class NumberOfSteps {
    // https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
    public static void main(String[] args) {
      System.out.println(reduceStepsToZero(14, 0));
    }
    private static int reduceStepsToZero(int n, int steps) {
      if (n == 0) return steps;
      if (n%2 == 0) return reduceStepsToZero(n/2, steps+1);
      return reduceStepsToZero(n-1, steps+1);
    }
}
