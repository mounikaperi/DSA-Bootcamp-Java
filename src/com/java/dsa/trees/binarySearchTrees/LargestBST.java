package com.java.dsa.trees.binarySearchTrees;

public class LargestBST {
    static TreeNode prev = null, first = null, second = null;
    public static void main(String[] args) {
      // https://www.geeksforgeeks.org/problems/largest-bst/1
      TreeNode root = new TreeNode(6);
      root.left = new TreeNode(6);
      root.left.right = new TreeNode(2);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(1);
      root.right.right = new TreeNode(3);
      System.out.println("The maxSize of the BST is: " + largestBst(root));
    }
    static int largestBst(TreeNode root) {
      Pair result = largestBSTHelper(root);
      return result.size;
    }
    private static Pair largestBSTHelper(TreeNode root) {
      if (root == null) {
        return new Pair(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }
      Pair left = largestBSTHelper(root.left);
      Pair right = largestBSTHelper(root.right);
      if (root.data > left.max && root.data < right.min) {
        return new Pair(left.size + right.size + 1, 
                        Math.max(root.data, right.max), 
                        Math.min(root.data, left.min));
      } 
      return new Pair(Math.max(left.size, right.size), 
                      Integer.MAX_VALUE, 
                      Integer.MIN_VALUE);
    }
}
class Pair {
    int size, max, min;
    Pair(int size, int max, int min) {
        this.size = size;
        this.max = max;
        this.min = min;
    }
}
