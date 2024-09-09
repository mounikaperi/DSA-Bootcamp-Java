public class MergeTwoSortedLinkedLists {
	public static void main(String[] args) {
	    // https://leetcode.com/problems/merge-two-sorted-lists/description/
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		
		ListNode head2 = new ListNode(6);
		head2.next = new ListNode(7);
		head2.next.next = new ListNode(8);
		head2.next.next.next = new ListNode(9);
		head2.next.next.next.next = new ListNode(10);
		ListNode result = mergeTwoLists(head1, head2);
		while (result != null) {
		    System.out.print(result.val + "->");
		    result = result.next;
		}
		System.out.println();
	}
	private static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
	    ListNode dummyNode = new ListNode(-1);
	    ListNode newHead = dummyNode;
	    while (head1 != null && head2 != null) {
	        if (head1.val <= head2.val) {
	            newHead.next = head1;
	            head1 = head1.next;
	        } else {
	            newHead.next = head2;
	            head2 = head2.next;
	        }
	        newHead = newHead.next;
	    }
	    // add remaining elements 
	    newHead.next = (head1 == null) ? head2 : head1;
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