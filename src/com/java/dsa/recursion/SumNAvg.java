import java.util.*;

public class SumNAvg {
    public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4, 5};
      System.out.println("The average of numbers is: " + average(arr, 5));
      int[][] data = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
      System.out.println(sum(data, 0, 3, 0, 4));
    }
    private static double average(int[] arr, int length) {
      double sum, average;
      if (length == 1) sum = arr[0];
      else {
        // Calculate sum of n-1 numbers = (n-1) * (avg of n-1 numbers)
        // and add nth number to it ( i.e. a[n-1])
        sum = arr[length-1] + (length-1) * average(arr, length-1);
      }
      average = sum / length;
      return average;
    }
    private static int sum(int[][] arr, int x, int rows, int y, int cols) {
      // This is the BinarySum for 2D matrix, assuming you have n1 rows and n2 column, So, the total sum will be equals to the sum of n1/2 first rows and n1/2 last rows. For each row, the sum will be divided into n2/2 first columns and n2/2 last columns,
      if (rows == 1 && cols == 1)
        return arr[x][y];
      if (rows == 1)
        return sum(arr, x, rows, y, cols/2) + sum(arr, x, rows, y + (cols /2), cols-(cols/2));
      else 
        return sum(arr, x, (rows/2), y, cols) + sum(arr, x + (rows /2), rows-(rows/2), y, cols);
    }
}