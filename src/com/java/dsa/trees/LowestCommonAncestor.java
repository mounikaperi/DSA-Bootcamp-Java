import java.util.*;

public class LowestCommonAncestor {
    public static void main(String[] args) {
      // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(5);
      root.left.left = new TreeNode(6);
      root.left.right = new TreeNode(2);
      root.left.right.left = new TreeNode(7);
      root.left.right.right = new TreeNode(4);
      root.right = new TreeNode(1);
      root.right.left = new TreeNode(0);
      root.right.right = new TreeNode(8);
      TreeNode lowestCommonAncestor = findLowestCommonAncestor(root, root.left, root.right);
      System.out.println("The lowest common ancestor is: " + lowestCommonAncestor.val);
  }
  private static TreeNode findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left = findLowestCommonAncestor(root.left, p, q);
    TreeNode right = findLowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) return root;
    return (left == null) ? right : left;
  }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}