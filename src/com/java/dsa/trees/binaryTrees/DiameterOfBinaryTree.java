import java.util.*;

public class DiameterOfBinaryTree {
    static int diameter = 0;
    public static void main(String[] args) {
      // https://leetcode.com/problems/diameter-of-binary-tree/
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);
      System.out.println("The diameter of the longest length in binary tree is: " + diameterOfBinaryTree(root));
    }
    private static int diameterOfBinaryTree(TreeNode root) {
      height(root);
      return diameter-1;
    }
    private static int height(TreeNode node) {
      if (node == null) return 0;
      int leftHeight = height(node.left);
      int rightHeight = height(node.right);
      int dia = leftHeight + rightHeight + 1;
      diameter = Math.max(dia, diameter);
      return Math.max(leftHeight, rightHeight) + 1;
    }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}