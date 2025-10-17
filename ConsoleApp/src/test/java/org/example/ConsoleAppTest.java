package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConsoleAppTest {
    @Test
    void testParseInteger() {
        Integer result = ConsoleApp.parseValue("123", Integer.class);
        assertEquals(123, result);
    }

    @Test
    void testParseString() {
        String result = ConsoleApp.parseValue("hello", String.class);
        assertEquals("hello", result);
    }

    @Test
    void testParseDouble() {
        Double result = ConsoleApp.parseValue("785.0875", Double.class);
        assertEquals(785.0875, result);
    }

    @Test
    void testShowInformationList() {
        LinkedCyclicList<String> list = new DoublyLinkedCyclicList<>();
        list.add("first");
        list.add("second");
        ConsoleApp.showInformationList(list);
    }

    @Test
    void testGetLastElement() {
        LinkedCyclicList<String> list = new DoublyLinkedCyclicList<>();
        list.add("first");
        list.add("last");
        ConsoleApp.getLast(list);
    }

    @Test
    void testClearList() {
        LinkedCyclicList<Double> list = new DoublyLinkedCyclicList<>();
        list.add(1.8888888);
        list.add(76.98876);

        ConsoleApp.clearList(list);
        assertTrue(list.isEmpty());
    }
}
