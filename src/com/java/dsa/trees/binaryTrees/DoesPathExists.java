package com.java.dsa.trees.binaryTrees;


public class DoesPathExists {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(5);
      root.right = new TreeNode(9);
      root.right.left = new TreeNode(10);
      root.right.left.left = new TreeNode(16);
      root.right.right = new TreeNode(12);
      root.right.right.left = new TreeNode(8);
      int[] arr = {3, 9, 10, 16};
      System.out.println("Does path exists? " + findPath(root, arr));
    }
    private static boolean findPath(TreeNode node, int[] arr) {
      if (node == null) return arr.length == 0;
      return helper(node, arr, 0);
    }
    private static boolean helper(TreeNode node, int[] arr, int index) {
      if (node == null || index < 0 || index >= arr.length || node.val != arr[index]) return false;
      if (node.left == null && node.right == null && index == arr.length-1) return true;
      return helper(node.left, arr, index+1) || helper(node.right, arr, index+1);
    }
}