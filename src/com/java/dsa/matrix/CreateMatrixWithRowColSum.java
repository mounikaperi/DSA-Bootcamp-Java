package com.java.dsa.matrix;

public class CreateMatrixWithRowColSum {
    // https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-bonus-problem/article/NTMyMTY3
    public static void main(String[] args) {
        int[] rowSum = { 5, 7, 10 };
        int[] colSum = { 8, 6, 8 };

        int[][] res = generateMatrixNaive(rowSum, colSum);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        rowSum = new int[] { 5, 7, 10 };
        colSum = new int[] { 8, 6, 8 };
        res = generateMatrixBetter(rowSum, colSum);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        rowSum = new int[] { 5, 7, 10 };
        colSum = new int[] { 8, 6, 8 };
        res = generateMatrixExpected(rowSum, colSum);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static int[][] generateMatrixNaive(int[] rowSum, int[] colSum) {
        /*
            - The idea is to assign such a number in each cell (i, j) such that sum of elements in row i does not
              exceed rowSum[i] and the sum of elements in col j does not exceed colSum[j].
            - This is because the resultant matrix  cannot have negative integers, so we cannot reduce total sum if
              it exceeds rowSum[i] or colSum[j]
            - Now, we can use greedy approach by assigning the largest possible number for each cell (i, j):
                - Largest number we can assign such that sum does not exceed rowSum = (rowSum - cumulativesum of row numbers)
                - Largest number we can assign such that sum does not exceed colSum = (colSum - cumulativesum of col numbers)
            - The minimum number among the above two will be assigned to cell (i, j).
            - To get the cumulative sum of elements filled so far in row and column, maintain two arrays
              currRowSum[] and currColSum[].
         */
        int n = rowSum.length;
        int m = colSum.length;
        int[][] res = new int[n][m];

        int[] currRowSum = new int[n];
        int[] currColSum = new int[m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int rowVal = rowSum[i] - currRowSum[i];
                int colVal = colSum[j] - currColSum[j];
                res[i][j] = Math.min(rowVal, colVal);
                currRowSum[i] += res[i][j];
                currColSum[j] += res[i][j];
            }
        }
        return res;
    }

    static int[][] generateMatrixBetter(int[] rowSum, int[] colSum) {
        /*
            - In the previous approach, we are using two auxillary arrays to store the running sum of each row and column
              but don't need these arrays if we store the remaining sums in the row and col sum arrays.
            - So, traverse the matrix and for each cell of result matrix, assign the minimum of rowSum[i] and colSum[j]
              so that sums donot exceed the given values.
            - After each assignment, reduce the corresponding row and column sum in sum arrays
        */
        int n = rowSum.length;
        int m = colSum.length;

        int[][] res = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int mn = Math.min(rowSum[i], colSum[j]);
                res[i][j] = mn;
                rowSum[i] -= mn;
                colSum[j] -= mn;
            }
        }
        return res;
    }

    static int[][] generateMatrixExpected(int[] rowSum, int[] colSum) {
        /*
        - In the previous approach, for each cell we are assigning min(rowSum, colSum) to it and then subtracting
          the assigned value from both rowSum and colsum.
        - Now, if we observed carefully, then after subtracting atleast one of rowSum or colSum will become 0.
        - So, if rowSum becomes 0 then we don't need to traverse the entire row as all elements in the ith row will be 0
        - Similarly, if colSum becomes 0 then we don't need to traverse the entire col as all the elements in jth col should be 0
         */
        int n = rowSum.length;
        int m = colSum.length;

        int[][] res = new int[n][m];
        int i=0, j=0;

        while (i<n && j<m) {
            res[i][j] = Math.min(rowSum[i], colSum[j]);

            rowSum[i] -= res[i][j];
            colSum[j] -= res[i][j];

            if (rowSum[i]==0) i++;
            if (colSum[j]==0) j++;
        }
        return res;
    }
}
