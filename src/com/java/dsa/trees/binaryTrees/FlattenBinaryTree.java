package com.java.dsa.trees.binaryTrees;

public class FlattenBinaryTree {
    public static void main(String[] args) {
      // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);
      int[] nums = {1, 2, 3, 4, 5, 6};
      TreeNode root = flattenBinaryTree(nums);
    }
    private static TreeNode flattenBinaryTree(TreeNode node) {
      if (node == null) return null;
      TreeNode current = root;
      while (current != null) {
        if (current.left != null) {
          TreeNode rightMost = current.left;
          while (rightMost.right != null) {
            rightMost = rightMost.right;
          }
          rightMost.right = current.right;
          current.right = current.left;
          current.left = null;
        }
        current = current.right;
      }
    }
}