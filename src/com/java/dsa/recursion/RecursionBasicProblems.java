package com.java.dsa.recursion;

public class RecursionBasicProblems {
    static int sum = 0;
    public static void main(String[] args) {
      print1toN(5);
      System.out.println();
      printNto1(5);
      System.out.println();
      System.out.println(factorial(5));
      System.out.println(sum(5));
      System.out.println(sumOfDigits(1234));
      System.out.println(productOfDigits(1234));
    }
    private static int print1toN(int n) {
      if (n == 0) return 0;
      print1toN(n-1);
      System.out.print(n + " ");
      return 0;
    }
    private static int printNto1(int n) {
      if (n==0) return 0;
      System.out.print(n + " ");
      printNto1(n-1);
      return 0;
    }
    private static int factorial(int n) {
      int fact = 0;
      if (n<=1) return 1;
      fact = n * factorial(--n);
      return fact;
    }
    private static int sum(int n) {
      int sum = 0;
      if (n<=1) return 1;
      sum = n + sum(--n);
      return sum;
    }
    private static int sumOfDigits(int n) {
      if (n == 0) return 0;
      return (n%10)+sumOfDigits(n/10);
    }
    private static int productOfDigits(int n) {
      if (n % 10 == n) return n;
      return (n%10) * productOfDigits(n/10);
    }
}
