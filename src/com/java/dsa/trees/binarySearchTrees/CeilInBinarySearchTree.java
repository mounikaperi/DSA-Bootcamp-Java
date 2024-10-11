import java.util.*;

public class CeilInBinarySearchTree {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(1);
      root.right = new TreeNode(7);
      root.left.right = new TreeNode(2);
      root.left.right.right = new TreeNode(3);
      int value = 3;
      System.out.println("The ceil of the value is: " + findCeil(root, value));
    }
    private static int findCeil(TreeNode root, int value) {
      int ceil = -1;
      TreeNode temp = root;
      while (temp != null) {
        if (temp.data == value) {
          ceil = temp.data;
          return ceil;
        }
        if (value > temp.data) {
          temp = temp.right;
        } else {
          temp = temp.left;
          ceil = temp.data;
        }
      }
      return ceil;
    }
}
class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;
  TreeNode(int data) {
    this.data = data;
  }
  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}