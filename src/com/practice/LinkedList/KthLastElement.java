package com.practice.LinkedList;

public class KthLastElement {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode("5");
        LinkedListNode<Integer> n2 = new LinkedListNode("10");
        LinkedListNode<Integer> n3 = new LinkedListNode("15");
        LinkedListNode<Integer> n4 = new LinkedListNode("20");
        LinkedListNode<Integer> n5 = new LinkedListNode("25");
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        kthLastRecursive(head, 2);
        //kthLastIterative(head, 3);
    }

    /*Very Important Approach*/
    private static LinkedListNode kthLastIterative(LinkedListNode<Integer> head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        /* Move p1 k nodes into list */
        for (int i = 0; i < k; i++) {
            if (p1 == null)
                return null; // Out of bounds
            p1 = p1.next;
        }
        /* Move them at the same pace. When p1 hits the end, p2 will be at the right element */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


    private static int kthLastRecursive(LinkedListNode<Integer> head, int k) {
        if (head == null) {
            return 0;
        }
        int index = kthLastRecursive(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th last Node is =" + head.data);
        }
        return index;
    }
}