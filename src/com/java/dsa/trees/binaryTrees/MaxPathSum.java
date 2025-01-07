package com.java.dsa.trees.binaryTrees;

import java.util.*;

public class MaxPathSum {
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) {
      // https://leetcode.com/problems/sum-root-to-leaf-numbers/
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(4);
      root.right = new TreeNode(8);
      root.left.left = new TreeNode(11);
      root.left.left.left = new TreeNode(7);
      root.left.left.right = new TreeNode(2);
      root.right.left = new TreeNode(13);
      root.right.right = new TreeNode(4);
      root.right.right.right = new TreeNode(1);
      System.out.println("Max Path sum is : " + maxPathSum(root));
    }
    private static int maxPathSum(TreeNode root) {
       helper(root);
       return ans;
    }
    private static int helper(TreeNode node) {
        if (node == null) return 0;
        // to ignore negative values take max of left, 0 and max of right, 0
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        int pathSum = left + right + node.val; 
        ans = Math.max(ans, pathSum);
        return Math.max(left, right) + node.val;
    }
}