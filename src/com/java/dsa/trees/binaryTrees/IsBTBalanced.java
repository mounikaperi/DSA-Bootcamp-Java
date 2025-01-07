package com.java.dsa.trees.binaryTrees;

import java.util.*;

public class IsBTBalanced {
    // https://leetcode.com/problems/balanced-binary-tree/description/
    public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);
      System.out.println("Is Tree Balanced? : " + isBalanced(root));
    }
    private static boolean isBalanced(TreeNode root) {
        return heightOfTree(root) != -1;
    }
    private static int heightOfTree(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = heightOfTree(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = heightOfTree(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight,  rightHeight) + 1;
    }
}