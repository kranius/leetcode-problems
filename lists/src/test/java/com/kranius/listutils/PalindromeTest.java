package com.kranius.listutils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {
    ListUtils<Integer> utils = new ListUtils<>();

    @Test
    public void simpleOddPalindrome() {
        ListNode<Integer> liste = new ListNode<>(1);
        liste.next = new ListNode<>(2);
        liste.next.next = new ListNode<>(3);
        liste.next.next.next = new ListNode<>(2);
        liste.next.next.next.next = new ListNode<>(1);

        assertTrue(utils.isPalindrome(liste));
    }

    @Test
    public void simpleEvenPalindrome() {
        ListNode<Integer> liste = new ListNode<>(1);
        liste.next = new ListNode<>(2);
        liste.next.next = new ListNode<>(2);
        liste.next.next.next = new ListNode<>(1);

        assertTrue(utils.isPalindrome(liste));
    }


    @Test
    public void notPalindrome() {
        ListNode<Integer> liste = new ListNode<>(1);
        liste.next = new ListNode<>(2);
        liste.next.next = new ListNode<>(3);
        liste.next.next.next = new ListNode<>(4);
        liste.next.next.next.next = new ListNode<>(1);

        assertFalse(utils.isPalindrome(liste));
    }

    @Test
    public void notPalindromeAgain() {
        ListNode<Integer> liste = new ListNode<>(0);
        liste.next = new ListNode<>(2);
        liste.next.next = new ListNode<>(3);
        liste.next.next.next = new ListNode<>(2);
        liste.next.next.next.next = new ListNode<>(1);

        assertFalse(utils.isPalindrome(liste));
    }
}
