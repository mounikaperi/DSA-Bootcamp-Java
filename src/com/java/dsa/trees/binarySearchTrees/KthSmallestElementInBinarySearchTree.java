package com.java.dsa.trees.binarySearchTrees;

public class KthSmallestElementInBinarySearchTree {
    static int count = 0;
    public static void main(String[] args) {
      // https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(6);
      root.left.left = new TreeNode(2);
      root.left.right = new TreeNode(4);
      root.left.left.left = new TreeNode(1);
      System.out.println("The kth smallest element in the binary search tree is: " + kthSmallest(root, 3));
  }
  private static int kthSmallest(TreeNode root, int k) {
    TreeNode kthSmallestNode = helper(root, k); 
    return (kthSmallestNode != null) ? kthSmallestNode.data : 0;
  }
  private static TreeNode helper(TreeNode root, int k) {
    if (root == null) return null;
    TreeNode left = helper(root.left, k);
    if (left != null) return left;
    count++;
    if (count == k) return root;
    TreeNode right = helper(root.right, k);
    return right;
  }
}