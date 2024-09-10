public class AVLTrees {
    class Node {
        int value;
        Node left;
        Node right;
        int height;  
        public Node() {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    private Node root;
    public AVLTrees() {

    }
    public int height() {
        return height(root);
    }
    private int height(Node node) {
        if (node == null) return -1;
        return node.height;
    }
    public void insert(int value) {
        root = insert(value, root);
    }
    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }
        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left) - height(node.right)) + 1;
        return rotate(node);
    }
    /**
     * SUMMARY:
     * if difference between height of left node and height of right node is greater than 1
     *      ->(LEFT subtree) if difference between height of left node of left node and left node of right node is > 0 perform rightRotation
     *      -> if difference between height of left of left node and height of left node of right node is < 0 perform left rotation on left node and then right rotation on top node
     *  If difference between height of left node and height of right node is less than -1
     *      -> (RIGHT subtree) If difference between right node of left node and right node of right node is < 0 perform left rotation
     *      -> If differencce between right node of left node and right node of right node is > 0 perform right Rotation on right node and left rotation on top node
     */
    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if (height(node.left.left) - height(node.left.right) > 0) {
                // left left case - do right rotation
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // left right case 
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // left right case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
    }
    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;
        c.right = p;
        p.left = t;
        p.height = Math.max(height(p.left) - height(p.right) + 1);
        c.height = Math.max(height(c.left) - height(c.right) + 1);
        return c;
    }
}
