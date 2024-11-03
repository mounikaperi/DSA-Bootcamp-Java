import java.util.*;

public class GCD {
    public static void main(String[] args) {
      System.out.println("The GCD of 5 and 6 is: " + GCD(5, 6));
      // Euclid's algorithm is used to find gcd
      // GCD(n, m) == GCD(m, nmodm)
    }
    private static int GCD(int m, int n) {
      if (m<n) return GCD(n, m);
      if (m%n == 0) return n;
      return GCD(n, m%n);
    }
  
}