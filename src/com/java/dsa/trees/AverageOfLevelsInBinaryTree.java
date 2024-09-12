import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class AverageOfLevelsInBinaryTree {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/average-of-levels-in-binary-tree/
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<Double> result = averageOfLevels(root);
		for (double value: result) {
		    System.out.print(value + " ");
		}
		System.out.println();
	}
	private static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double averageLevel = 0.0;
            for (int i=0; i<levelSize; i++) {
                TreeNode currentNode = queue.poll();
                averageLevel += currentNode.val;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            averageLevel = averageLevel / levelSize;
            result.add(averageLevel);
        }
        return result;
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