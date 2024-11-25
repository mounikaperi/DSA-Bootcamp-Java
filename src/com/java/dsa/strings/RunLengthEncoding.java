import java.util.*;

public class RunLengthEncoding {
    public static void main(String[] args) {
      int n = 4;
      String result = countAndSay(n);
      System.out.println("Run Length Encoding is: " + result);
    }
    private static String countAndSay(int n) {
      String current = "1";
      while(--n > 0) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<current.length(); ) {
          char ch = current.charAt(i);
          int count = 0;
          while (i < current.length() && current.charAt(i) == ch) {
            i++;
            count++;
          }
          sb.append(count).append(ch);
        }
        current = sb.toString();
      }
      return current;
    }
}