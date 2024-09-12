public class ReorderList {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/reorder-list/
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.print("Original Linked List: ");
        printLinkedList(head);
        System.out.print("Reorderd Linked List: ");
        reorderList(head);
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
	private static void reorderList(ListNode head) {
        if (head == null || head.next == null) return; 
        ListNode middleNode = getMiddleNode(head);
        ListNode headSecond = reverseLinkedList(middleNode);
        ListNode headFirst = head;
        // rearrange
        while (headFirst != null && headSecond != null) {
            ListNode temp = headFirst.next;
            headFirst.next = headSecond;
            headFirst = temp;

            temp = headSecond.next;
            headSecond.next = headFirst;
            headSecond = temp;
        }
        if (headFirst != null) headFirst.next = null;
    }
    private static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private static ListNode reverseLinkedList(ListNode head) {
	    ListNode temp = head;
	    ListNode prev = null;
	    while(temp!=null) {
	        ListNode front = temp.next; // store the next node in front to preserve the reference
	        temp.next = prev;
	        prev = temp;
	        temp = front;
	    }
	    return prev;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}