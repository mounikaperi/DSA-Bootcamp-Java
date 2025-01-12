package com.java.dsa.matrix;

public class RotateArrayBy180Deg {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateMatrix(mat);
        for (int[] row : mat) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        rotateMatrix1(mat);
        for (int[] row : mat) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                result[i][j] = matrix[n-i-1][n-j-1];
            }
        }
        for (int i=0; i<n; i++) {
            System.arraycopy(result[i], 0, matrix[i], 0, n);
        }
    }
    static void rotateMatrix1(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n/2; i++) {
            for (int j=0; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = temp;
            }
        }
        // Handle middle row of matrix which has odd dimensions
        if (n % 2 != 0) {
            int mid = n/2;
            for (int j=0; j<n/2; j++) {
                int temp = matrix[mid][j];
                matrix[mid][j] = matrix[mid][n-j-1];
                matrix[mid][n-j-1] = temp;
            }
        }
    }
}
