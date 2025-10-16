package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedCyclicListTest {

    private LinkedCyclicList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedCyclicList<>();
    }

    @Test
    void testNewListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testAddElement() {
        list.add(10);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    void testAddMultipleElements() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());
    }

    @Test
    void testLargeNumberOfElements() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        assertEquals(1000, list.size());
        assertEquals(0, list.getFirst());
        assertEquals(999, list.getLast());
    }

    @Test
    void testAddByIndex() {
        list.add(10);
        list.addByIndex(20, 1);

        assertEquals(10, list.getFirst());
        assertEquals(20, list.getLast());
        assertEquals(2, list.size());
    }
}