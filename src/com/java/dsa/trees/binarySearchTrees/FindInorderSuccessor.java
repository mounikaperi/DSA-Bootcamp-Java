import java.util.*;

public class FindInorderSuccessor {
    public static void main(String[] args) {
      TreeNode root = new TreeNode(4);
      root.left = new TreeNode(2);
      root.right = new TreeNode(6);
      root.left.left = new TreeNode(1);
      root.left.right = new TreeNode(3);
      root.right.left = new TreeNode(5);
      root.right.right = new TreeNode(7);
      TreeNode result = findInorderSuccessor(root, new TreeNode(3));
      System.out.println(result.toString());
    }
    private static TreeNode findInorderSuccessor(TreeNode root, TreeNode p) {
      TreeNode successor = null;
      while (root != null) {
        if (p.data < root.data) {
          successor = root;
          root = root.left;
        } else {
          root = root.right;
        }
      }
      return successor;
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