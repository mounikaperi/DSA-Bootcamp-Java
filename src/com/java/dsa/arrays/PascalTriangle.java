package com.java.dsa.arrays;

import java.util.*;

class PascalTriangle {
    public static void main(String[] args) {
      int row = 5; int col = 3;
      int element = pascalTriangle1(row, col);
      System.out.println("The element at position (r, c) is: " + element);
    }
    private static int pascalTriangle1(int row, int col) {
      int element = (int) nCr(row-1, col-1);
      return element;
    }
    private static long nCr(int n, int row) {
      long res = 1;
      for (int i=0; i<row; i++) {
        res = res * (n - i);
        res = res / (i + 1);
      }
      return res;
    }
}

class PascalTriangle2 {
    private static int nCr(int n, int r) {
      long res = 1;
        for (int i = 0; i < r; i++) {
          res = res * (n - i);
          res = res / (i + 1);
        }
        return (int) res;
    }
    private static List<List<Integer>> pascalTriangle(int n) {
      List<List<Integer>> ans = new ArrayList<>();
      for (int row = 1; row <= n; row++) {
        List<Integer> tempLst = new ArrayList<>();
        for (int col = 1; col <= row; col++) {
          tempLst.add(nCr(row - 1, col - 1));
        }
        ans.add(tempLst);
      }
      return ans;
    }

    public static void main(String[] args) {
      int n = 5;
      List<List<Integer>> ans = pascalTriangle(n);
      for (List<Integer> it : ans) {
        for (int ele : it) {
          System.out.print(ele + " ");
        }
        System.out.println();
      }
    }
}

class PascalTriangleOptimized {
  public static List<Integer> generateRow(int row) {
    long ans = 1;
    List<Integer> ansRow = new ArrayList<>();
    ansRow.add(1);
    for (int col = 1; col < row; col++) {
      ans = ans * (row - col);
      ans = ans / col;
      ansRow.add((int)ans);
    }
    return ansRow;
  }
  public static List<List<Integer>> pascalTriangle(int n) {
    List<List<Integer>> ans = new ArrayList<>();
    for (int row = 1; row <= n; row++) {
      ans.add(generateRow(row));
    }
    return ans;
  }
  public static void main(String[] args) {
    int n = 5;
    List<List<Integer>> ans = pascalTriangle(n);
    for (List<Integer> it : ans) {
      for (int ele : it) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }
}

// https://leetcode.com/problems/pascals-triangle-ii/
// rowIndex is 0 based here hence adding 1 to rowIndex when for loop is running
class PascalTriangleForSpecificRowIndex {
    public List<Integer> getRow(int rowIndex) {
        long ans = 1;
        List<Integer> result = new ArrayList<>();
        result.add(1); // always starts with 1
        for (int col = 1; col < rowIndex+1; col++) {
            ans = ans * ( rowIndex+1 - col);
            ans = ans / col;
            result.add((int) ans);
        }
        return result;
    }
}
