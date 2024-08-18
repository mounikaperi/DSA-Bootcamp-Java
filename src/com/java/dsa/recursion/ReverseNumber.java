package com.java.dsa.recursion;
public class ReverseNumber {
    static int sum = 0;
    public static void main(String[] args) {
      System.out.println(reverse1(1234));
      System.out.println(reverse2(1234));
    }
    private static int reverse1(int n) {
      if (n == 0) return 0;
      int rem = n%10;
      sum = sum * 10 + rem;
      reverse1(n/10);
      return sum;
    }
    private static int reverse2(int n) {
      // sometimes you might need some additional variables in the argument
      // in that case, make another function
      int digits = (int)(Math.log10(n)) + 1;
      return helper(n, digits);
    }
    private static int helper(int n, int digits) {
        if (n%10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int)(Math.pow(10, digits-1)) + helper(n/10, digits-1);
    }
}
