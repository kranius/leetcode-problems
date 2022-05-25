package com.kranius.listutils;

import java.util.Comparator;

public class ListUtils<T extends Comparable<T>> {

    // 141. Linked List Cycle
    //
    public boolean hasCycle(ListNode<T> head) {
        ListNode<T> slow = head;
        ListNode<T> fast = head;

        while (fast != null && fast.next != null) {
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

    // 160. Intersection of two Linked List
    public ListNode<T> getIntersectionNode(ListNode<T> headA, ListNode<T> headB) {
        if (headA == null || headB == null)
            return null;

        ListNode<T> a = headA;
        ListNode<T> b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    // 203. Remove Linked List elements
    public ListNode<T> removeElements(ListNode<T> head, T val) {
        if (head == null)
            return null;

        head.next = removeElements(head.next, val);

        return head.val.compareTo(val) == 0 ? head.next : head;
    }

    // 206. Reverse Linked List
    public ListNode<T> reverseList(ListNode<T> head) {
        ListNode<T> newHead = null;
        ListNode<T> next = null;

        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }

    // 234. Palindrome Linked List
    public boolean isPalindrome(ListNode<T> head) {

        if (head == null)
            return true;

        ListNode<T> mid = halfList(head);
        ListNode<T> secondHalf = reverseList(mid.next);

        ListNode<T> p1 = head;
        ListNode<T> p2 = secondHalf;
        /* reverse 2nd half
           check if 1st half and 2nd half are palindrome
           reverse 2nd half again
         */
        boolean result = true;

        while (result && p2 != null) {
            if (p1.val.compareTo(p2.val) != 0)
                result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        mid.next = reverseList(secondHalf);

        return result;
    }

    public ListNode<T> halfList(ListNode<T> head) {
        if (head == null)
            return null;

        ListNode<T> slow = head;
        ListNode<T> fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

/*
   public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        ListNode mid = halfList(head);
        ListNode secondHalf = reverseList(mid.next);

        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;

        while (result && p2 != null) {
            if (p1.val != p2.val)
                result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        mid.next = reverseList(secondHalf);

        return result;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode halfList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
 */
