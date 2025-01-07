package com.java.dsa.trees.binaryTrees;

public class TargetPathSum {
    public static void main(String[] args) {
      // https://leetcode.com/problems/path-sum/description/
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(4);
      root.right = new TreeNode(8);
      root.left.left = new TreeNode(11);
      root.left.left.left = new TreeNode(7);
      root.left.left.right = new TreeNode(2);
      root.right.left = new TreeNode(13);
      root.right.right = new TreeNode(4);
      root.right.right.right = new TreeNode(1);
      System.out.println("Does the binary tree have path sum equal to targetSum? " + hasPathSum(root, 22));
    }
    private static boolean hasPathSum(TreeNode node, int targetSum) {
      if (node == null) return false;
      if (node.val == targetSum && node.left == null && node.right == null) return true;
      return hasPathSum(node.left, targetSum-node.val) || hasPathSum(node.right, targetSum-node.val);
    }
}