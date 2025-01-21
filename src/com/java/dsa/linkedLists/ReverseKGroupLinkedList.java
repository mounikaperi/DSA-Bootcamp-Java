package com.java.dsa.linkedLists;

public class ReverseKGroupLinkedList {
    public static Node reverseKGroup(Node head, int k) {
        /*
        Iterative Approach:
        - To reverse a linkedlist in groups of size k, the goal is to traverse the list of
            segment of k nodes and reverse each group individually.
        - After reversing each group, we connect it to previous group by updating tail
        - This process continues until the entire list is traversed, we return new head
          of the reversed list.

          Initialize pointers:
          - current to head
          - newHead to null
          - tail to null
          - groupHead to current

          traverse list in groups of k
            - for each group k, set groupHead to curr;
            - reverse nodes in group by updating next pointers using prev and nextNode

          connect the reversed group to the previous one
          - after reversing, if tail is !null, connect the previous group's end to the current
          reversed group's head.
          - update tail to the point to the last node of the curent group

           Repeat the process untill all nodes in the list are processed
           return newHead which points to the head of the fully reversed list.

         */
    }
}
