public class CountNumberOfNegatives {
    public static void main(String[] args) {
        // https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
        int[][] arr = {{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}};
        System.out.println("Count number of negative numbers in matrix is: " + countNegatives(arr));
    }
    private static int countNegatives(int[][] arr) {
        int rowCount = arr.length;
        int colCount = arr[0].length;
        int row = 0; int col = arr[0].length-1; int count = 0;
        while (row < rowCount && col >= 0) {
            if (arr[row][col] >= 0) row++;
            else {
                count += rowCount - row;
                col--;
            }
        }
        return count;
    }       
}

