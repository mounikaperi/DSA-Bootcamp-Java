package com.java.dsa.trees.binaryTrees;

import java.util.*;

public class SumOfAllRootToLeafNodes {
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
      System.out.println("Sum of all the root-to-leaf paths is: " + sumNumbers(root));
    }
    private static int sumNumbers(TreeNode root)  {
      return helper(root, 0);
    }
    private static int helper(TreeNode node, int sum) {
      if (node == null) return 0;
      sum = (sum*10)+node.val;
      if (node.left == null && node.right == null) return sum;
      return helper(node.left, sum) + helper(node.right, sum);
    }
}