package com.kranius.listutils;

// we use leetcode definition
public class ListNode<T> {
    T val;
    ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T x) {
        val = x;
        next = null;
    }
}
