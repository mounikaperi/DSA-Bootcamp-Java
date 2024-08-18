package com.java.dsa.binarySearch;
class BinarySearchIn2DArray {
    public static void main(String[] args) {
       int arr[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
       int target = 3;
       System.out.println("Is Element present? "+ searchMatrix(arr, target));
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
}
