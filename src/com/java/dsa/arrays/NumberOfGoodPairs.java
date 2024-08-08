import java.util.*;

public class Main {
    public static void NumberOfGoodPairs(String[] args) {
        // https://leetcode.com/problems/number-of-good-pairs/
        int[] arr = {1,2,3,1,1,3};
        System.out.println("Total number of good pairs: " + numIdenticalPairs1(arr));
         System.out.println("Total number of good pairs: " + numIdenticalPairs2(arr));
    }
    public static int numIdenticalPairs1(int[] arr) {
        int ans = 0;
        int count[] = new int[101];
        for (int num: arr) {
            ans += count[num]++;
        }
        return ans;
    }
    public static int numIdenticalPairs2(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        for (int num: arr) {
            int count = hm.getOrDefault(num, 0);
            ans += count;
            hm.put(num, count+1);
        }
        return ans;
    }
}
