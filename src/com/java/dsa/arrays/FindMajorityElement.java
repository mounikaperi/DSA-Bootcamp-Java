import java.util.*;

public class FindMajorityElement {
    // https://leetcode.com/problems/majority-element/description/
    public static void main(String[] args) {
      int[] nums = {2,2,1,1,1,2,2};
      int majorityElement = findMajorityElementUsingBruteForce(nums);
      System.out.println("BruteForce: The majority element is: " + majorityElement);
      majorityElement = findMajorityElementUsingHashMap(nums);
      System.out.println("HashMap: The majority element is: " + majorityElement);
      majorityElement = findMajorityElementUsingMooreVotingAlgo(nums);
      System.out.println("Moore's Voting Algo: The majority element is: " + majorityElement);
    }
    private static int findMajorityElementUsingBruteForce(int[] nums) {
      /**
       * We will run the loop and select element one by one
       * Now, for each element, we will run another loop and count the occurrences
       * If any element occurs more than the floor of (N/2) we return it
       */
       for (int i=0; i<nums.length; i++) {
         int count = 0;
         for (int j=0; j<nums.length; j++) {
           if (nums[i] == nums[j])
            count++;
         }
         if (count > (nums.length) / 2)
          return nums[i];
       }
       return -1;
    }
    private static int findMajorityElementUsingHashMap(int[] nums) {
      /**
       * Use HashMap and store key as element and value as count
       * Traverse the array and update the value of the element 
       * Simultaneously, check if the value is greater than floor of (n/2)
       * if yes, return the key else iterate forward
       */
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i=0; i<nums.length; i++) {
        int value = map.getOrDefault(nums[i], 0);
        map.put(nums[i], value+1);
      }
      for (Map.Entry<Integer, Integer> it: map.entrySet()) {
        if (it.getValue() > (nums.length) / 2) {
          return it.getKey();
        }
      }
      return -1;
    }
    private static int findMajorityElementUsingMooreVotingAlgo(int[] nums) {
      int count = 0;
      int element = 0;
      // traverse thru array and keep incrementing or decrementing for the first value
      for (int i=0; i<nums.length; i++) {
        if (count == 0) {
          count = 1;
          element = nums[i];
        } else if (element == nums[i]) {
          count++;
        } else {
          count--;
        }
      }
      // checking if the stored element is the majority element
      int countElement = 0;
      for (int i=0; i<nums.length; i++) {
        if (nums[i] == element) 
          countElement++;
      }
      if (countElement > (nums.length) / 2) {
        return element;
      }
      return -1;
    }
}