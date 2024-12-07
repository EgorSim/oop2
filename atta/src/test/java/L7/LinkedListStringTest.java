package L7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListStringTest {
    LinkedList<String> list = new LinkedList<>();

    @Test
    void addElemTest() {
        list.add("LOVV66");
        assertEquals(list.size(), 1);
        assertEquals(list.getHead().getValue(), "LOVV66");
        assertEquals(list.getTail().getValue(), "LOVV66");
        list.add("Егор Крид");
        assertEquals(list.size(), 2);
        assertEquals(list.getHead().getValue(), "LOVV66");
        assertEquals(list.getTail().getValue(), "Егор Крид");
        list.add("Платина");
        assertEquals(list.size(), 3);
        assertEquals(list.getHead().getValue(), "LOVV66");
        assertEquals(list.getTail().getValue(), "Платина");
    }

    @Test
    void findByElemTest() {
        list.add("1");
        list.add("3");
        list.add("2");
        assertEquals(list.findByValue("2").getValue(), list.getTail().getValue());
        assertEquals(list.findByValue("1").getValue(), list.getHead().getValue());
        assertEquals(list.findByValue("3").getValue(), "3");
    }

    @Test
    void deleteElemTest() {
        list.add("5");
        list.add("7");
        list.add("6");
        list.delete("5");
        assertEquals(list.size(), 2);
        assertEquals(list.getHead().getValue(), "7");
        list.delete();
        assertEquals(list.size(), 1);
        assertEquals(list.getTail().getValue(), "7");
    }

    @Test
    void ExceptionsTest() {
        assertThrows(LinkedListException.class,
                () -> list.delete());
        list.add("5");
        assertThrows(LinkedListException.class,
                () -> list.findByValue("7"));
    }
}
