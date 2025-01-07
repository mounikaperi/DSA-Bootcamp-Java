package com.java.dsa.trees.binarySearchTrees;

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
        if (low != null && node.data <= low) return false;
        if (high != null && node.data >= high) return false;
        boolean leftTree = helper(node.left, low, node.data);
        boolean rightTree = helper(node.right, node.data, high);
        return leftTree && rightTree;
    }
}