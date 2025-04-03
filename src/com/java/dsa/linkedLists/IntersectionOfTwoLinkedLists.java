package com.java.dsa.linkedLists;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(15);
        head1.next.next = new Node(30);
        Node head2 = new Node(3);
        head2.next = new Node(6);
        head2.next.next = new Node(9);
        head2.next.next.next = head1.next;

        Node intersectionPoint = intersectionPointNaive(head1, head2);
        if (intersectionPoint == null)
            System.out.println("-1");
        else
            System.out.println(intersectionPoint.data);
        Node intersectionPoint = intersectionPointHashing(head1, head2);
        if (intersectionPoint == null)
            System.out.println("-1");
        else
            System.out.println(intersectionPoint.data);
            Node intersectionPoint = intersectionTwoPointer(head1, head2);
        if (intersectionPoint == null)
            System.out.println("-1");
        else
            System.out.println(intersectionPoint.data);
    }
    static Node intersectionPointNaive(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while(temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }
    static Node intersectionPointHashing(Node head1, Node head2) {
        Set<Node> visitedNodes = new HashSet<>();
        Node curr1 = head1;
        while (curr1 != null) {
            visitedNodes.add(curr1);
            curr1 = curr1.next;
        }
        Node curr2 = head2;
        while (curr2 != null) {
            if (visitedNodes.contains(curr2)) {
                return curr2;
            }
            curr2 = curr2.next;
        }
        return null;
    }
    static Node intersectionTwoPointer(Node head1, Node head2) {
        /*
            Initialize two pointers ptr1 and ptr2 at head1 and head2 respectively.
            Traverse through the lists, one node at a time.
            When ptr1 reaches the end of a list, then redirect it to head2.
            Similarly, when ptr2 reaches the end of a list, redirect it to the head1.
            Once both of them go through reassigning, they will be at equal distance from the collision point.
            If at any node ptr1 meets ptr2, then it is the intersection node.
            After the second iteration if there is no intersection node , returns NULL.
        */
       Node ptr1 = head1;
       Node ptr2 = head2;
       if (ptr1 == null || ptr2 == null) {
            return null;
       }
       while (ptr1 != ptr2) {
            ptr1 = (ptr1 != null) ? ptr1.next: head2;
            ptr2 = (ptr2 != null) ? ptr2.next: head1;
       }
       return ptr1;
    }
}