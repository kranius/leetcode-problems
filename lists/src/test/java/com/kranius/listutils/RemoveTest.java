package com.kranius.listutils;

import org.junit.jupiter.api.Test;

public class RemoveTest {
    ListUtils<Integer> utils = new ListUtils<>();

    ListNode<Integer> numbers = new ListNode<Integer>(0, new ListNode<Integer>(1,  new ListNode<Integer>(2)));


    public static void printList(ListNode<Integer> liste) {
        while (liste != null) {
            System.out.println(liste.val);
            liste = liste.next;
        }
    }

    @Test
    public void removeOneElement() {
        printList(utils.removeElements(numbers, 1));
    }
}
