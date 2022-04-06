package com.kranius.listutils;

// we use leetcode definition
public class ListNode<T> {
    T val;
    ListNode<T> next;

    public ListNode() {
        val = null;
        next = null;
    }

    public ListNode(T x) {
        val = x;
        next = null;
    }

    public boolean compare(T val) {
    return true;
    }
}
