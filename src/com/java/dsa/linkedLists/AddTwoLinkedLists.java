package com.java.dsa.linkedLists;

class LinkedListNode {
    int data;
    LinkedListNode next;
    
    public LinkedListNode(int data) {
        this.data = data;
    }
}
public class AddTwoLinkedLists {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.
        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode temp = dummy;
        int carry = 0;
        while (head1 != null || head2 != null || carry == 1) {
            int sum = 0;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            sum += carry;
            carry = sum / 10;
            LinkedListNode node = new LinkedListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}