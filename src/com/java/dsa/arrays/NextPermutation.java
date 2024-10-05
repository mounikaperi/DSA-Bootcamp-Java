import java.util.*;

public class NextPermutation {
    public static void main(String[] args) {
      int[] nums = {2, 1, 5, 4, 3, 0, 0};
      int[] ans = nextGreaterPermutation(nums);
      System.out.println("The next permutation array is: " + Arrays.toString(ans));
    }
    private static int[] nextGreaterPermutation(int[] nums) {
      int startIndex = -1;
      int endIndex = -1;
      for (int i=nums.length-2; i>=0; i--) {
        if (nums[i] < nums[i+1]) {
          startIndex = i;
          break;
        }
      }
      if (startIndex == -1) { // find breaking point
        reverse(nums, 0);
        return nums;
      } 
      // find next greater element and swap
      for (int i=nums.length-1; i>=0; i--) {
        if (nums[i] > nums[startIndex]) {
          endIndex = i;
          break;
        }
      }
      swap(nums, startIndex, endIndex);
      reverse(nums, startIndex+1); // reverse the rest right half
      return nums;
    }
    private static void swap(int[] nums, int startIndex, int endIndex) {
      int temp = nums[startIndex];
      nums[startIndex] = nums[endIndex];
      nums[endIndex] = temp;
    }
    private static void reverse(int[] nums, int index) {
      int start = index;
      int end = nums.length - 1;
      while (start < end) {
        swap(nums, start, end);
        start++;
        end--;
      }
    }
}