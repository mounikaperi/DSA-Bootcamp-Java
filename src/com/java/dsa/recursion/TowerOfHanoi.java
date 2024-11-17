import java.util.*;

public class TowerOfHanoi {
    public static void main(String[] args) {
      System.out.println("The factorial of 5 is: " + factorial(5));
      printBase10(25);
      System.out.println("--------------------------------------");
      printBase16(25, 16);
      System.out.println("--------------------------------------");
      int num = 4;
      System.out.println("The sequence of moves in the Tower of Hanoi are : ");
      towerOfHanoi(num, 'A', 'C', 'B');
      System.out.println("--------------------------------------");
    }
    private static int factorial(int i) {
      if (i<=1) return 1;
      return i * factorial(i-1);
    }
    private static void printBase10(int number) {
      char digit = (char) (number % 10 +'O');
      number = number / 10;
      if (number != 0)
        printBase10(number / 10);
      System.out.print(" " + digit);
    }
    private static void printBase16(int number, final int base) {
      String conversion = "0123456789ABCDEF";
      char digit = (char) (number % base);
      number = number / base;
      if (number != 0)
        printBase16(number, base);
      System.out.print(" " + conversion.charAt(digit));
    }
    private static void towerOfHanoi(int num, char src, char dst, char tmp) {
      if (num < 1) return;
      towerOfHanoi(num-1, src, tmp, dst); // move n-1 from src to tmp
      System.out.println("Move"+num+"disk from peg"+src+" to peg " + dst);
      towerOfHanoi(num-1, tmp, dst, src); // move n-1 from tmp to dst
    }
}