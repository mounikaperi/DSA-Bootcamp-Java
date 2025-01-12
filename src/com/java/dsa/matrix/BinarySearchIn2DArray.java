package com.java.dsa.matrix;
class BinarySearchIn2DArray {
    public static void main(String[] args) {
       int arr[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
       int target = 3;
       System.out.println("Is Element present? "+ searchMatrix(arr, target));

       int[][] mat = {{1, 5, 9}, {14, 20, 21}, {30, 34, 43}};
       int x = 14;
       System.out.println("Is Element present? "+ searchMatrixOptimal(arr, target));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0; i<matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length-1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
    private static boolean binarySearch(int[] matrix, int target) {
        int low = 0, high = matrix.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid] == target) return true;
            if (target > matrix[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    static boolean searchMatrixOptimal(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0; int high = n*m-1;
        while (low <= high) {
            int mid = ( low + high ) / 2;
            int row = mid / m;
            int col = mid % m;
            if (target == mat[row][col]) return true;
            else if (target > mat[row][col]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    
}
