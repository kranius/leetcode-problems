package com.kranius.listutils;

public class ListUtils<T> {

    // 141. Linked List Cycle
    public boolean hasCycle(ListNode<T> head) {
        ListNode<T> slow = head;
        ListNode<T> fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }

        return false;
    }
}
