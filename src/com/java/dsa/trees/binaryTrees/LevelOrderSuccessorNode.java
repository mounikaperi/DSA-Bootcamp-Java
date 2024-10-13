import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class LevelOrderSuccessorNode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println("The successorNode is: " + findSuccessor(root, 20).val);
	}
    private static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
            if (currentNode.val == key) break;
        }
        return queue.peek();
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