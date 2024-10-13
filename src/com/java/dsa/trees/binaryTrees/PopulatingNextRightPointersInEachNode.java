public class PopulatingNextRightPointersInEachNode {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		TreeNode result = connect(root);
	}
	private static TreeNode connect(TreeNode root) {
	    if (root == null) return null;
	    TreeNode leftMost = root;
	    while (leftMost.left != null) {
	        TreeNode current = leftMost; // traverse level wise here from left to right
	        while (current != null) {   
	            current.left.next = current.right;
	            if (current.next != null) {
	                current.right.next = current.next.left;
	            }
	            current = current.next;
	        }
	        leftMost = leftMost.left;
	    }
	    return root;
	}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}