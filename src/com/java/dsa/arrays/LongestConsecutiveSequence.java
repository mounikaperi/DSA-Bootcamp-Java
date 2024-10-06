import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
      // https://www.naukri.com/code360/problems/longest-successive-elements_6811740?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM
      int[] a = {100, 200, 1, 2, 3, 4};
      int ans = longestSuccessiveElementsViaBruteForce(a);
      System.out.println("The longest consecutive sequence is: " + ans);
      ans = longestSuccessiveElementsViaBetterApproach(a);
      System.out.println("The longest consecutive sequence is: " + ans);
      ans = longestSuccessiveElementsViaOptimalApproach(a);
      System.out.println("The longest consecutive sequence is: " + ans);
    }
    private static int longestSuccessiveElementsViaBruteForce(int[] a) {
      int longest = 1;
      for (int i=0; i<a.length; i++) {
        int currentElement = a[i];
        int count = 1;
        while (linearSearch(a, currentElement+1) == true) {
          currentElement++;
          count++;
        }
        longest = Math.max(longest, count);
      }
      return longest;
    }
    private static boolean linearSearch(int[] a, int element) {
      for (int i=0; i<a.length; i++) {
        if (a[i] == element)
          return true;
      }
      return false;
    }
    private static int longestSuccessiveElementsViaBetterApproach(int[] a) {
      if (a.length == 0) return 0;
      Arrays.sort(a);
      int lastSmaller = Integer.MIN_VALUE;
      int count = 0;
      int longest = 1;
      for (int i=0; i<a.length; i++) {
        if (a[i] - 1 == lastSmaller) {
          count++;
          lastSmaller = a[i];
        } else if (a[i] != lastSmaller) {
          count = 1;
          lastSmaller = a[i];
        }
        longest = Math.max(longest, count);
      }
      return longest;
    }
    private static int longestSuccessiveElementsViaOptimalApproach(int[] a) {
      if (a.length == 0) return 0;
      int longest = 1;
      Set<Integer> set = new HashSet<>();
      for (int i=0; i<a.length; i++)
        set.add(a[i]);
      for (int it: set) {
        if (!set.contains(it-1)) {
          int count = 1;
          int x = it;
          while (set.contains(x+1)) {
            x++;
            count++;
          }
          longest = Math.max(longest, count);
        }
      }
      return longest;
    }
}