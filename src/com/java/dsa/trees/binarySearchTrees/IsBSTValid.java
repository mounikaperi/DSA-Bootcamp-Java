import java.util.*;

public class IsBSTValid {
    private static Integer previousValue = null;
    public static void main(String[] args) {
      // https://leetcode.com/problems/validate-binary-search-tree/
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(1);
      root.right = new TreeNode(4);
      root.right.left = new TreeNode(3);
      root.right.right = new TreeNode(6);
      System.out.println("Is the given input tree a valid binary search tree? " + isBinarySearchTreeValid(root));
    }
    private static boolean isBinarySearchTreeValid(TreeNode root) {
      if (root == null) {
        return true; // An empty tree is valid BST tree
      }
      if (!isBinarySearchTreeValid(root.left)) {
        // traverse left subtree-if not valid, return false immediately
        return false;
      }
      if (previousValue != null && previousValue >= root.data) {
         // Check the current node value with the previous node's value.
         // As it's an in-order traversal, previousValue should be less than the current node's value.
        return false;
      }
      // Update previousValue with the current node's value.
      previousValue = root.data;
      if (!isBinarySearchTreeValid(root.right)) {
        // Traverse the right subtree. If it's not a valid BST, return false immediately.
        return false;
      }
      return true; // All checks passed, it's a valid BST.
    }
}
class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  TreeNode(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}