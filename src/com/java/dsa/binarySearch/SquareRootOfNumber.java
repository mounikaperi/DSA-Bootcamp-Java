import java.util.*;
public class SquareRootOfNumber {
    public static void main(String[] args) {
        int x=8;
        System.out.println("The Square root of " +x+ " is: " + findSquareRoot(x));
    }
    private static int findSquareRoot(int x) {
        if (x==0 || x==1) return x;
        long low = 1;
        long high = x;
        long result = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x) return (int) mid;
            else if (mid * mid < x) {
                low = mid + 1;
                result = mid;
            } else high = mid - 1;
        }
        return (int) result;
    }
}

