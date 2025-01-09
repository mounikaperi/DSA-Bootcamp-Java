package com.java.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {
    public static List<Integer> printSpiralNaive(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // List to store the spiral order elements
        ArrayList<Integer> result = new ArrayList<>();
        // 2D array to keep track of visited cells
        boolean[][] visited = new boolean[m][n];
        // change the row index for each direction
        int[] dr = {0, 1, 0, -1};
        // change the column index for each direction
        int[] dc = {1, 0, -1, 0};
        // Initial position in the matrix
        int r=0, c=0;
        int index = 0;
        // Iterate through all the elements in the matrix
        for (int i=0; i<(m*n); ++i) {
            result.add(matrix[r][c]); // add current element to the result list
            visited[r][c] = true; // Mark current cell as visited
            int newRow = r + dr[index]; // calculate the next cell coordinates based on current direction
            int newCol = c + dc[index]; 
            if (0<=newRow && newRow < m && 0<=newCol && newCol < n && !visited[newRow][newCol]) {
                r = newRow;
                c = newCol;
            } else {
                index = (index+1)%4; // change direction turn clockwise
                r += dr[index];
                c += dc[index];
            }
        }
        return result;
    }

    public static List<Integer> printSpiral(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int n = mat.length; // no. of rows
        int m = mat[0].length; // no. of columns
        // Initialize the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;
        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {
            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(mat[top][i]);
            top++;
            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(mat[i][right]);
            right--;
            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(mat[bottom][i]);
                bottom--;
            }
            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(mat[i][left]);
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
        //Matrix initialization.
        int[][] mat = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16}};

        List<Integer> ans = printSpiralNaive(mat);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
        
        ans = printSpiral(mat);

        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }

        System.out.println();
    }
}