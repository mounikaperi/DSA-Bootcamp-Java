import java.util.*;

public class FirstNonRepeatingChar {
  public static void main(String[] args) {
    String s = "racecar";
    System.out.println(nonRepeatingCharNaive(s));
    System.out.println(nonRepeatingCharUsingFreq(s));
    System.out.println(nonRepeatingCharUsingVisited(s));
  }
  private static char nonRepeatingCharNaive(String s) {
    for (int i=0; i<s.length(); i++) {
      boolean found = false;
      for (int j=0; j<s.length(); j++) {
        if (i!=j && s.charAt(i) == s.charAt(j)) {
          found = true;
          break;
        }
      }
      if (!found)
       return s.charAt(i);
    }
    return '$';
  }
  private static char nonRepeatingCharUsingFreq(String s) {
    final int MAX_CHAR = 26;
    int[] freq = new int[MAX_CHAR];
    for (char ch: s.toCharArray()) {
      freq[ch-'a']++;
    }
    for (int i=0; i<s.length(); i++) {
      if (freq[s.charAt(i)-'a'] == 1)
        return s.charAt(i);
    }
    return '$';
  }
  private static char nonRepeatingCharUsingVisited(String s) {
    final int MAX_CHAR = 26;
    int[] visited = new int[MAX_CHAR];
    Arrays.fill(visited, -1);
    for (int i=0; i<s.length(); i++) {
      if (visited[s.charAt(i)-'a'] == -1) visited[s.charAt(i)-'a'] = i;
      else visited[s.charAt(i)-'a'] = -2;
    }
    int index = Integer.MAX_VALUE;
    for(int i=0; i<MAX_CHAR; i++) {
      if (visited[i] >= 0)
        index = Math.min(visited[i], index);
    }
    return index == Integer.MAX_VALUE ? '$' : s.charAt(index);
  }
}
