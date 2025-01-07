package com.java.dsa.trees.binarySearchTrees;

public class InsertInBST {
    public static void main(String[] args) {
      // https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(7);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      int value = 5;
      TreeNode result = insertTreeNode(root, value);
      System.out.println(result);
    }
    private static TreeNode insertTreeNode(TreeNode root, int value) {
      if (root == null) return new TreeNode(value);
      if (value < root.data)
        root.left = insertTreeNode(root.left, value);
      else 
        root.right = insertTreeNode(root.right, value);
      return root;
    }
}