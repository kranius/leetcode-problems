package com.kranius.listutils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HasCycleTest {

    ListUtils<Integer> utils = new ListUtils<>();

    @Test
    public void emptyList() {
        var liste = new ListNode<Integer>();

        assertFalse(utils.hasCycle(liste));
    }

    @Test
    public void oneElementList() {
        var liste = new ListNode<>(42);

        assertFalse(utils.hasCycle(liste));
    }

    @Test
    public void simpleCycle() {
        var liste = new ListNode<>(1);
        liste.next = new ListNode<>(2);
        liste.next.next = liste;

        assertTrue(utils.hasCycle(liste));
    }
}
