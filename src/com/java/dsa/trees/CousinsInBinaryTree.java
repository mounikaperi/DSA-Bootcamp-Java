import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class CousinsInBinaryTree {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/cousins-in-binary-tree/
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println("Are nodes corresponding to x and y cousins? " + isCousins(root, 4, 3));
	}
    private static boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        // both x and y should not have the same parent and should be present at same height
        return (
            (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }
    private static TreeNode findNode(TreeNode node, int x) {
        if (node == null) return null;
        if (node.val == x) return node;
        TreeNode leftNode = findNode(node.left, x);
        if (leftNode != null) return leftNode; // if leftNode is found return else search in right subtree
        return findNode(node.right, x);
    }
    private static int level(TreeNode node, TreeNode xx, int height) {
        if (node == null) return 0;
        if (node == xx) return height;
        int l = level(node.left, xx, height+1);
        if (l!=0) return l;
        return level(node.right, xx, height+1);
    }
    private static boolean isSibling(TreeNode node, TreeNode xx, TreeNode yy) {
        if (node == null) return false;
        return (
            (node.left == xx && node.right == yy) || (node.left == yy && node.right == xx) || isSibling(node.left, xx, yy) || isSibling(node.right, xx, yy)
        );
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