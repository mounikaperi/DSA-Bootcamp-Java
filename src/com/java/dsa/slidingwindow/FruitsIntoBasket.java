import java.util.*;

public class FruitsIntoBasket {
    // https://leetcode.com/problems/fruit-into-baskets/description/
    public static void main(String[] args) {
      int[] fruits = {1,2,3,2,2};
      System.out.println("BruteForce: Total number of fruits are: " + totalFruit(fruits));
      System.out.println("SlidingWindow: Total number of fruits are: " + totalFruitUsingSlidingWindow(fruits));
    }
    private static int totalFruit(int[] fruits) {
      int maxLength = 0;
      for (int i=0; i<fruits.length; i++) {
        Set<Integer> set = new HashSet<>();
        for (int j=i; j<fruits.length; j++) {
          set.add(fruits[j]);
          if (set.size() <= 2) 
            maxLength = Math.max(maxLength, j-i+1);
          else
            break;
        }
      }
      return maxLength;
    }
    private static int totalFruitUsingSlidingWindow(int[] fruits) {
      int left = 0;
      int right = 0;
      int maxLength = 0;
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      while (right < fruits.length) {
        map.put(fruits[right], map.getOrDefault(fruits[right], 0)+1);
        // invalid case 2 baskets can contain 2 unique fruits
        while (map.size() > 2) {
          map.put(fruits[left], map.get(fruits[left])-1);
          if (map.get(fruits[left]) <= 0)
            map.remove(fruits[left]);
          left++;
        }
        if (map.size() <= 2) {
          maxLength = Math.max(maxLength, right-left+1);
        }
        right++;
      }
      return maxLength;
    }
}