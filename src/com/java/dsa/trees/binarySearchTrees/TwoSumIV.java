package com.java.dsa.trees.binarySearchTrees;

import java.util.*;

public class TwoSumIV {
    public static void main(String[] args) {
      // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(3);
      root.right = new TreeNode(6);
      root.left.left = new TreeNode(2);
      root.left.right = new TreeNode(4);
      root.right.right = new TreeNode(7);
      System.out.println("Does there exist elements in BST such that their sum is equal to targetSum? " + findTarget(root, 9));
    }
    private static boolean findTarget(TreeNode root, int target) {
      return find(root, target);
    }    
    private static boolean find(TreeNode node, int target) {
      if (node == null) return false;
      if (hasRequiredVal(node, target-node.data, node.data)) return true;
      return find(node.left, target) || find(node.right, target);
    }
    private static boolean hasRequiredVal(TreeNode node, int val, int firstVal) {
      if (node == null) return false;
      if (node.data == val && node.data != firstVal) return true;
      else if (val < node.data) return hasRequiredVal(node.left, val, firstVal);
      else
        return hasRequiredVal(node.right, val, firstVal);
    }
}
