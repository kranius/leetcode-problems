package com.kranius.listutils;

import java.util.Comparator;

public class ListUtils<T extends Comparable<T>> {

    // 141. Linked List Cycle
    //
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

    // 21. Merge Two Sorted Lists
    public ListNode<T> mergeTwoList(ListNode<T> list1, ListNode<T> list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode<T> head = new ListNode<>();

        if (list1.val.compareTo(list2.val) <= 0) {
            head.val = list1.val;
            head.next = mergeTwoList(list1.next, list2);
        } else {
            head.val = list2.val;
            head.next = mergeTwoList(list1, list2.next);
        }
        return head;
    }
}