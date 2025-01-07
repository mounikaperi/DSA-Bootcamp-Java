package com.java.dsa.trees.binarySearchTrees;

public class FloorInBinarySearchTree {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(2);
      root.right = new TreeNode(81);
      root.right.left = new TreeNode(42);
      root.right.right = new TreeNode(87);
      root.right.left.right = new TreeNode(66);
      root.right.left.right.left = new TreeNode(45);
      root.right.right.right = new TreeNode(90);
      int value = 87;
      System.out.println("The floor value is: " + findFloor(root, value));
    }
    private static int findFloor(TreeNode root, int value) {
      int floor = -1;
      TreeNode temp = root;
      if (temp == null) return floor;
      while (temp != null) {
        if (temp.data == value) {
          floor = temp.data;
          return floor;
        }
        if (value < temp.data) {
          temp = temp.left;
        } else {
          floor = temp.data;
          temp = temp.right;  
        }
      }
      return floor;
    }
}