package com.java.dsa.trees.binaryTrees;

public class InvertBinaryTree {
    static int diameter = 0;
    public static void main(String[] args) {
      // https://leetcode.com/problems/invert-binary-tree/description/
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);
      TreeNode invertedRoot = invertTree(root);
    }
    private static TreeNode invertTree(TreeNode node) {
      if (node == null) return null;
      TreeNode left = invertTree(node.left);
      TreeNode right = invertTree(node.right);
      node.left = right;
      node.right = left;
      return node;
    }
}