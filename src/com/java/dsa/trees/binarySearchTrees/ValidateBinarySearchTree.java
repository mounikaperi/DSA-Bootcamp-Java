import java.util.*;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
      // https://leetcode.com/problems/validate-binary-search-tree//
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);
      System.out.println("Is given tree a valid binary search tree: " + isValidBST(root));
    }
    private static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private static boolean helper(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        if (low != null && node.val <= low) return false;
        if (high != null && node.val >= high) return false;
        boolean leftTree = helper(node.left, low, node.val);
        boolean rightTree = helper(node.right, node.val, high);
        return leftTree && rightTree;
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