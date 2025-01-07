package com.java.dsa.trees.binarySearchTrees;

public class SearchInBST {
    public static void main(String[] args) {
      // https://leetcode.com/problems/search-in-a-binary-search-tree/
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(7);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      int val = 2;
      TreeNode subTree = searchValueInBST(root, val);
    }
    private static TreeNode searchValueInBST(TreeNode root, int value) {
      TreeNode temp = root;
      while (temp != null && temp.data != value) {
        temp = (value < temp.data) ? temp.left : temp.right;
      }
      return temp;
    }
}