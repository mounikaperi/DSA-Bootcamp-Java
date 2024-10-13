import java.util.*;

public class SortedArrayToBinarySearchTree {
    public static void main(String[] args) {
      // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
      int[] nums = {1, 2, 3, 4, 5, 6};
      TreeNode root = sortedArrayToBST(nums);
    }
    private static TreeNode sortedArrayToBST(int[] nums) {
      return populateSorted(nums, 0, nums.length-1);
    }
    private static TreeNode populateSorted(int[] nums, int start, int end) {
      if (start > end) return null;
      int mid = start + (end - start) / 2;
      TreeNode root = new TreeNode(nums[mid]);
      root.left = populateSorted(nums, 0, mid-1);
      root.right = populateSorted(nums, mid+1, end);
      return root;
    }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}