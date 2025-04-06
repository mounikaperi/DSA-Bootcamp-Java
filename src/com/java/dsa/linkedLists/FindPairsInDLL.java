package com.java.dsa.linkedLists;

public class FindPairsInDLL {
    public static ArrayList<int[]> findPairs(Node head, int k) {
        ArrayList<int[]> list = new ArrayList<>();
        Node end = head;
        while (end.next != null) {
            end = end.next;
        }
        Node temp = head;
        Node start = head;
        while (start.data < end.data) {
            if (start.data + end.data == k) {
                list.add(new int [] {start.data, end.data});
                start = start.next;
                end = end.prev;
            } else if (start.data + end.data > k) {
                 end = end.prev;
            } else {
                start = start.next;
            }
        }
        return list;
    }
}