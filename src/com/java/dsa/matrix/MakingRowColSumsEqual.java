package com.java.dsa.matrix;

public class MakingRowColSumsEqual {
    public static void main(String[] args) {
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 2, 3 },
                { 3, 2, 1 }
        };
        System.out.println(findMinOperation(mat));
    }
    static int findMinOperation(int[][] matrix) {
        /*
            The idea is to find the maximum sum among all rows and columns sums
            Now to minimize the operation count, make all rows and column sums equal to maximum sum by performing operations
            on the rows and cols which has sum less than the maximum sum.
            Now, incrementing an element will increase the row sum as well as the column sum, so min operations will be
            equal to the sum of operations for all rows or columns
        */
        int n = matrix.length;
        int res = 0;
        int maxSum = 0;

        // Find maximum sum across all the rows
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=0; j<n; j++) {
                sum += matrix[i][j];
            }
            maxSum = Math.max(sum, maxSum);
        }

        // find maximum sum across all columns
        for (int j=0; j<n; j++) {
            int sum = 0;
            for (int i=0; i<n; i++) {
                sum += matrix[i][j];
            }
            maxSum = Math.max(sum, maxSum);
        }

        // Sum of operations across all rows
        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=0; j<n; j++) {
                sum += matrix[i][j];
            }
            res += (maxSum - sum);
        }
        return res;
    }
}
