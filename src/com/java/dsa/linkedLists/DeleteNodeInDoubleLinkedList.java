class DeleteNodeInDoubleLinkedList {
    public Node deleteNode(Node head, int x) {
        // if head is null linkedlist is empty nothing to delete
        if (head == null) return null;
        // if head is the only node in the list delete it 
        if (head.prev == null && head.next == null) return null;
        Node temp = head;
        for (int i=1; i<x; i++) {
            temp = temp.next;
        }
        // If the node to be deleted is the first one
        if (temp.prev == null) {
            return head = temp.next;
        } else { // there is a node before the currentNode
            temp.prev.next = temp.next;
        }
        if (temp.next != null) { // it is not the last node
            temp.next.prev = temp.prev;
        }
        temp.prev = null;
        temp.next = null;
        return head;
    }
}
