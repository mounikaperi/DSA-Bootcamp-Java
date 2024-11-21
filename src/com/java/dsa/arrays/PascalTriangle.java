import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) {
      int row = 5; int col = 3;
      int element = pascalTriangle1(row, col);
      System.out.println("The element at position (r, c) is: " + element);
    }
    private static int pascalTriangle1(int row, int col) {
      int element = (int) nCr(row-1, col-1);
      return element;
    }
    private static long nCr(int n, int row) {
      long res = 1;
      for (int i=0; i<row; i++) {
        res = res * (n - i);
        res = res / (i + 1);
      }
      return res;
    }
}