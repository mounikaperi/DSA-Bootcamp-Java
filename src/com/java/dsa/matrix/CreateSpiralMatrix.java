package com.java.dsa.matrix;

public class CreateSpiralMatrix {
    public static void main(String[] args) {
        int m = 4, n = 4;
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11, 12, 13, 14, 15, 16 };
        int[][] res = createSpiralMatrix(arr, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[][] createSpiralMatrix(int[] arr, int n, int m) {
        /*
            1. We initialize matrix of size nxn and four boundary variables top=0, bottom=n-1, left=0, right=n-1
            2. We also initialize an index=0 to keep track of the current element in the array
            3. We will the top row from left to right with values from array, updating index as we go. Then increment top
            4. Fill the rightmost column from top to bottom with values from the array updating index as we go.
            5. Then decrement right pointer
            6. Fill the bottom row from right to left with values from the array, updating index as we go
            7. Then decrement bottom pointer from 1
            8. Fill the left column from bottom to top with values from the array, updating index as we go.
            9. Then decrement left pointer by 1
            10. We fill the top row from left to right with values from array, updating index as we go.
            11. Then increment top 1
            12. Fill the rightmost column from top to bottom with values from the array, updating index we go
            13. Then decrement right pointer by 1
            14. Fill the bottom row from right to left with values from the array, updating index as we go.
            15. Then decrement bottom pointer by 1. As we reach the end of the array, we completed spiral traversal
        */
        int[][] res = new int[n][m];
        int top=0, bottom=n-1, left=0, right=m-1;
        int index=0;
        while (index < arr.length) {
            for (int j=left; j<=right; j++)
                res[top][j] = arr[index++];
            top++;
            for (int j=top; j<=bottom; j++)
                res[j][right] = arr[index++];
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    res[bottom][j] = arr[index++];
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res[i][left] = arr[index++];
                }
                left++;
            }
        }
        return res;
    }
}
