
import java.util.*;
class RotateArrayBy90Deg {
    /**
     * [Naive Approach] Using Extra Space - O(n^2) Time and O(n^2) Space
     * We mainly need to move first row elements to first column in reverse order, second row elements to second column in reverse order and so on.
     * Let us first try to find out a pattern to solve the problem for n = 4 (second example matrix above)
                mat[0][0] goes to mat[3][0]
                mat[0][1] goes to mat[2][0]
                mat[1][0] goes to mat[3][1]
                mat[3][3] goes to mat[0][3]
        Do you see a pattern? Mainly we need to move mat[i][j] to mat[n-j-1][i]. We first move elements in a temporary matrix, 
        then copy the temporary to the original. If we directly copy elements within the matrix, it would cause data loss.
     */
    static void rotateMatrixNaive(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                result[n-j-1] = matrix[i][j];
            }
        }
        // copy the rotated matrix back to original matrix
        for (int i=0; i<n; i++) {
            System.arraycopy(result[i], 0, matrix[i], 0, n);
        }
    }

    /**
     * [Expected Approach 1] Forming Cycles - O(n^2) Time and O(1) Space
     * To solve the question without any extra space, rotate the array in form of cycles. 
     * For example, a 4 X 4 matrix will have 2 cycles. The first cycle is formed by its 1st row, last column, last row, and 1st column. 
     * The second cycle is formed by the 2nd row, second-last column, second-last row, and 2nd column. 
     * The idea is for each square cycle, to swap the elements involved with the corresponding cell in the matrix in an anticlockwise direction 
     * i.e. from top to left, left to bottom, bottom to right, and from right to top one at a time using nothing but a temporary variable to achieve this.
     */


    static void rotateMatrixoptimal1(int[][] matrix) {
        int n = matrix.length;000
        for (int i=0; i<(n/2); i++) {
            for (int j=i; j<n-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[n-i-1][n-j-1];
                matrix[n-1-i][n-j-1] = matrix[n-1-j][i];
                matrix[n-1-j][i] = temp;
            }
        }
    }

    /**
     * [Expected Approach 2] Reversing Rows and Transposing - O(n^2) Time and O(1) Space
     * Rotating a square matrix 90 degrees counterclockwise, each element moves to a new position. 
     * The top row becomes the left most column in reverse order, the second row becomes the second-left most column in reverse order, and so on. 
     * By first reversing the rows, you rearrange the elements in such a way that when you transpose them, they end up in their final rotated positions.
     * Follow the given steps to solve the problem:
            Reverse every individual row of the matrix
            Perform Transpose of the matrix
            Note: We can also rotate the matrix by first performing the transpose and then reversing every column of the matrix.
     */

    static void reverseMatrixOptimal2(int[][] mat) {
        int n = mat.length;
        // reverse each row
        for (int i=0; i<n; i++) {
            int start = 0; int end = n-1;
            while (start <= end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
        // Performing transpose
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static void main(String args[]) {
        // https://www.geeksforgeeks.org/batch/gfg-160-problems/track/matrix-gfg-160/article/MTM3ODgx
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrixNaive(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrixoptimal1(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrixoptimal2(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

