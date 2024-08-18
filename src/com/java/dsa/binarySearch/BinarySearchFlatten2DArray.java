package com.java.dsa.binarySearch;
class BinarySearchFlatten2DArray {
    public static void main(String[] args) {
       int arr[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
       int target = 3;
       System.out.println("Is Element present? "+ searchMatrix(arr, target));
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = (n*m)-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;
            if (matrix[row][col] == target) return true;
            else if(target > matrix[row][col]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}
