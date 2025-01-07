package com.java.dsa.trees.binarySearchTrees;

public class LowestCommonAncestor {
    public static void main(String[] args) {
      // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
      TreeNode root = new TreeNode(6);
      root.left = new TreeNode(2);
      root.right = new TreeNode(8);
      root.left.left = new TreeNode(0);
      root.left.right = new TreeNode(4);
      root.left.right.left = new TreeNode(3);
      root.left.right.right = new TreeNode(5);
      root.right.left = new TreeNode(7);
      root.right.right = new TreeNode(9);
      int p = 2, q = 8;
      TreeNode result = lowestCommonAncestor(root, new TreeNode(p), new TreeNode(q));
      System.out.println("lowestCommonAncestor " + result);
    }
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode firstNode, TreeNode secondNode) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        if (left != null && right != null) return root;
        return (left == null) ? right: left;
    }
}