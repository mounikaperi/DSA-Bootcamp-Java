package com.java.dsa.linkedLists;

public class IntersectionPointOfTwoLinkedLists {
    public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here
        if (firstHead == null || secondHead == null) return -1;
        Node temp1 = firstHead;
        Node temp2 = secondHead;
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1 == temp2) return temp1.data;
            if (temp1 == null) temp1 = secondHead;
            if (temp2 == null) temp2 = firstHead;
        }
        return temp1.data;
    }
}
