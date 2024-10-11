import java.util.*;

public class Main {
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
      TreeNode root = new TreeNode(-10);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);
      System.out.println("The maximum of path sum is: " + maxPathSum(root));
    }
    private static int maxPathSum(TreeNode root) {
       helper(root);
       return ans;
    }
    private static int helper(TreeNode node) {
      if (node == null) return 0;
      // to ignore negative values take max of left, 0 and max of right, 0
      int left = Math.max(helper(node.left), 0);
      int right = Math.max(helper(node.right), 0);
      ans = Math.max(ans, left + right + node.val);
      return Math.max(left, right) + node.val;
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