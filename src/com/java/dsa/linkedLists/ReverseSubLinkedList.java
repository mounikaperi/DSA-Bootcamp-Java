public class Main {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/reverse-linked-list-ii/
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.print("Original Linked List: ");
        printLinkedList(head);
        System.out.print("Reversed Sub Linked List: ");
        reverseBetween(head, 2, 4);
        printLinkedList(head);
	}
	private static void printLinkedList(ListNode head) {
	    ListNode temp = head;
	    while (temp!=null) {
	        System.out.print(temp.val+" ");
	        temp = temp.next;
	    }
	    System.out.println();
	}
	private static ListNode reverseBetween(ListNode head, int left, int right) {
        // if there is only one node or no need to reverse return the original list
        if (head == null || head.next == null || left == right) return head;
        // dummynode to simplify the handling of head node
        ListNode dummyNode = new ListNode(0, head);
        // pointer to track the node before the reversal
        ListNode nodeBeforeReverse = dummyNode;
        for (int i=0; i<left-1; i++) {
            nodeBeforeReverse = nodeBeforeReverse.next;
        }
        // firstreversed will become last node after reversal
        ListNode firstReversed = nodeBeforeReverse.next;
        ListNode current = firstReversed;
        ListNode prev = null;
        for (int i=0; i<right-left+1; i++) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        // Reconnect the reversed section back to the list
        nodeBeforeReverse.next = prev;
        firstReversed.next = current;
        return dummyNode.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}