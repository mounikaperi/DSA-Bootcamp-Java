package com.java.dsa.trees.binaryTrees;

import java.util.*;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
      // https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);
      System.out.println("The maximum depth of Binary Tree is: " + maxDepth(root));
    }
    private static int maxDepth(TreeNode node) {
      if (node == null) return 0;
      int left = maxDepth(node.left);
      int right = maxDepth(node.right);
      return Math.max(left, right) + 1;
    }
}