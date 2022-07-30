package com.practice.LinkedList;

public class LinkedListNode<T> {
    public LinkedListNode next, prev, last;
    public T data;

    public LinkedListNode(T d, LinkedListNode n, LinkedListNode p) {
        data = d;
        setNext(n);
        setPrevious(n);
    }

    public LinkedListNode(T data) {
        this.data = data;
    }

    public void setNext(LinkedListNode n) {
        next = n;
        if (this == last) {
            last = n;
        }
        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    public void setPrevious(LinkedListNode p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }

    public LinkedListNode clone() {
        LinkedListNode next2 = null;
        if (next != null) {
            next2 = next.clone();
        }
        LinkedListNode head2 = new LinkedListNode(data, next2, null);
        return head2;
    }
}
