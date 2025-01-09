package com.java.dsa.arrays;

import java.util.*;

public class SetMatrixZeros {
  public static void main(String[] args) {
    int[][] matrix = {
      {1, 1, 1},
      {1, 0, 1},
      {1, 1, 1}
    };
    int[][] result = zeroMatrixBruteForce(matrix, matrix.length, matrix[0].length);
    int[][] matrix1 = {
      {1, 1, 1},
      {1, 0, 1},
      {1, 1, 1}
    };
    result = zeroMatrixBetterApproach(matrix1, matrix1.length, matrix1[0].length);
    int[][] matrix2 = {
      {1, 1, 1},
      {1, 0, 1},
      {1, 1, 1}
    };
    result = zeroMatrixOptimalApproach(matrix2, matrix2.length, matrix2[0].length);
    System.out.println("The Final matrix is: ");
    for (int[] row: result) {
      for (int value: row) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }
  private static int[][] zeroMatrixBruteForce(int[][] matrix, int row, int col) {
    for (int i=0; i<row; i++) {
      for (int j=0; j<col; j++) {
        if (matrix[i][j] == 0) {
          markRow(matrix, row, col, i);
          markCol(matrix, row, col, j);
        }
      }
    }
    // finally, mark all -1 as 0
    for (int i=0; i<row; i++) {
      for (int j=0; j<col; j++) {
        if (matrix[i][j] == -1)
          matrix[i][j] = 0;
      }
    }
    return matrix;
  }
  private static void markRow(int[][] matrix, int row, int col,  int i) {
    for (int j=0; j<col; j++) {
      if (matrix[i][j] != 0)
        matrix[i][j] = -1;
    }
  }
  private static void markCol(int[][] matrix, int row, int col, int j) {
    for (int i=0; i<row; i++) {
      if (matrix[i][j] != 0)
        matrix[i][j] = -1;
    }
  }
  
  private static int[][] zeroMatrixBetterApproach(int[][] matrix, int n, int m) {
    int[] row = new int[n]; 
    int[] col = new int[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 0) {
          row[i] = 1;
          col[j] = 1;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (row[i] == 1 || col[j] == 1) {
          matrix[i][j] = 0;
        }
      }
    }
    return matrix;
  }
  
  private static int[][] zeroMatrixOptimalApproach(int[][] matrix, int n, int m) {
    int col0 = 1;
    // step 1: Traverse the matrix and mark 1st row & col accordingly:
    for (int i=0; i<n; i++) {
      for (int j=0; j<m; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          if (j!= 0) matrix[0][j] = 0;
          else col0 = 0;
        }
      }
    }
    // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
    for (int i=0; i<n; i++) {
      for (int j=0; j<m; j++) {
        if (matrix[i][j] != 0) {
          if (matrix[0][j] == 0 || matrix[i][0] == 0)
            matrix[i][j] = 0;
        }
      }
    }
    // step3: finally mark the 1st col and 1st row
    if(matrix[0][0] == 0) {
      for (int j=0; j<m; j++) matrix[0][j] = 0;
    }
    if (col0 == 0) {
      for (int i=0; i<n; i++) matrix[i][0] = 0;
    }
    return matrix;
  }
}
