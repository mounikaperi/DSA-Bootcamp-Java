public class RemoveDuplicatesFromSortedLinkedLists {
	public static void main(String[] args) {
        // https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		ListNode result = deleteDuplicates(head);
		while (result != null) {
		    System.out.print(result.val + "->");
		    result = result.next;
		}
		System.out.println("END");
	}
	private static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp!=null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}