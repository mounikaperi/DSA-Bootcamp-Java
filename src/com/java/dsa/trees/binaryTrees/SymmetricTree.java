import java.util.*;

public class SymmetricTree {
	// https://leetcode.com/problems/symmetric-tree/description/
    public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);
      boolean isTreeSymmetric = isSymmetricTree(root);
      System.out.println("Is the given tree symmetric? " + isTreeSymmetric);
    }
    private static boolean isSymmetricTree(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root.left);
      queue.offer(root.right);
      while (!queue.isEmpty()) {
        TreeNode left = queue.poll();
        TreeNode right = queue.poll();
        if (left == null && right == null) continue;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        queue.offer(left.left);
        queue.offer(right.right);
        queue.offer(left.right);
        queue.offer(right.left);
      }
      return true;
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