import java.util.*;

class NumbersSmallerThanCurrent {
    public static void main(String[] args) {
        // https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
        int[] arr = {8,1,2,2,3};
        int[] result = smallerNumbersThanCurrent(arr);
        System.out.println("Smaller elements in array for each element: " + Arrays.toString(result));
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] bucket = new int[101];
        for (int i=0; i<nums.length; i++) {
            bucket[nums[i]] += 1;
        }
        for (int j=1; j<=100; j++) {
            bucket[j] += bucket[j-1];
        }
        for (int k=0; k<nums.length; k++) {
            int position = nums[k];
            nums[k] = position == 0 ? 0 : bucket[position-1];
        }
        return nums;
    }
}
