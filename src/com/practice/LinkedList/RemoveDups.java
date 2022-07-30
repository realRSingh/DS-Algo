package com.practice.LinkedList;

import java.util.HashSet;

public class RemoveDups {

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(15);
        LinkedListNode n2 = new LinkedListNode(10);
        LinkedListNode n3 = new LinkedListNode(5);
        LinkedListNode n4 = new LinkedListNode(10);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        removeDups(head);
        traverse(head);
    }

    private static void removeDups(LinkedListNode node) {
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedListNode previous = null;
        while (node != null) {
            if (hashSet.contains(node.data)) {
                previous.next = node.next;
            } else {
                hashSet.add((Integer) node.data);
                previous = node;
            }
            node = node.next;
        }
    }

    private static void traverse(LinkedListNode head) {
        LinkedListNode cursor = head;
        for (int i = 1; i <= 3; i++) {
            System.out.println(cursor.data);
            cursor = cursor.next;
        }

    }
}
