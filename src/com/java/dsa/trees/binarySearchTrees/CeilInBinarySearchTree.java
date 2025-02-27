package com.java.dsa.trees.binarySearchTrees;

public class CeilInBinarySearchTree {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(1);
      root.right = new TreeNode(7);
      root.left.right = new TreeNode(2);
      root.left.right.right = new TreeNode(3);
      int value = 3;
      System.out.println("The ceil of the value is: " + findCeil(root, value));
    }
    private static int findCeil(TreeNode root, int value) {
      int ceil = -1;
      TreeNode temp = root;
      while (temp != null) {
        if (temp.data == value) {
          ceil = temp.data;
          return ceil;
        }
        if (value > temp.data) {
          temp = temp.right;
        } else {
          ceil = temp.data;
          temp = temp.left;
        }
      }
      return ceil;
    }
}