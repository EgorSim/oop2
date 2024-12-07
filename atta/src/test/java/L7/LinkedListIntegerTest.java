package L7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListIntegerTest {
    LinkedList<Integer> list = new LinkedList<>();

    @Test
    void addElemTest() {
        list.add(22);
        assertEquals(list.size(), 1);
        assertEquals(list.getHead().getValue(), 22);
        assertEquals(list.getTail().getValue(), 22);
        list.add(1);
        assertEquals(list.size(), 2);
        assertEquals(list.getHead().getValue(), 22);
        assertEquals(list.getTail().getValue(), 1);
        list.add(3);
        assertEquals(list.size(), 3);
        assertEquals(list.getHead().getValue(), 22);
        assertEquals(list.getTail().getValue(), 3);
    }

    @Test
    void findByElemTest() {
        list.add(22);
        list.add(1);
        list.add(3);
        assertEquals(list.findByValue(3).getValue(), list.getTail().getValue());
        assertEquals(list.findByValue(22).getValue(), list.getHead().getValue());
        assertEquals(list.findByValue(1).getValue(), 1);
    }

    @Test
    void deleteElemTest() {
        list.add(22);
        list.add(1);
        list.add(3);
        list.delete(22);
        assertEquals(list.size(), 2);
        assertEquals(list.getHead().getValue(), 1);
        list.delete();
        assertEquals(list.size(), 1);
        assertEquals(list.getTail().getValue(), 1);
    }

    @Test
    void ExceptionsTest() {
        assertThrows(LinkedListException.class,
                () -> list.delete());
        list.add(22);
        assertThrows(LinkedListException.class,
                () -> list.findByValue(1));
    }
}
