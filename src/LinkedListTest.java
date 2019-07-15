import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class LinkedListTest {

    @Test
    void addFirst_AddOne() {
        LinkedList list = new LinkedList();
        list.AddFirst(0);
        assertEquals("0", list.Print(false));
    }

    @Test
    void addFirst_AddTwo() {
        LinkedList list = new LinkedList();
        list.AddFirst(0);
        list.AddFirst(1);
        assertEquals("1 0", list.Print(false));
    }

    @Test
    void addFirst_AddThree() {
        LinkedList list = new LinkedList();
        list.AddFirst(0);
        list.AddFirst(1);
        list.AddFirst(2);
        assertEquals("2 1 0", list.Print(false));
    }

    @Test
    void addLast_AddOne() {
        LinkedList list = new LinkedList();
        list.AddLast(0);
        assertEquals("0", list.Print(false));
    }

    @Test
    void addLast_AddTwo() {
        LinkedList list = new LinkedList();
        list.AddLast(0);
        list.AddLast(1);
        assertEquals("0 1", list.Print(false));
    }

    @Test
    void addLast_AddThree() {
        LinkedList list = new LinkedList();
        list.AddLast(0);
        list.AddLast(1);
        list.AddLast(2);
        assertEquals("0 1 2", list.Print(false));
    }

    @Test
    void removeFirst_Null() {
        LinkedList list = new LinkedList();
        assertThrows(NoSuchElementException.class, () -> {
            list.RemoveFirst();
        });
    }

    @Test
    void removeFirst_OneObject() {
        LinkedList list = new LinkedList();
        list.AddFirst(0);
        list.RemoveFirst();
        assertEquals("",list.Print(false));
    }

    @Test
    void removeFirst_TwoObject() {
        LinkedList list = new LinkedList();
        list.AddFirst(0);
        list.AddFirst(1);
        list.RemoveFirst();
        assertEquals("0",list.Print(false));
    }

    @Test
    void removeLast_Null() {
        LinkedList list = new LinkedList();
        assertThrows(NoSuchElementException.class, () -> {
            list.RemoveLast();
        });
    }

    @Test
    void removeLast_OneObject() {
        LinkedList list = new LinkedList();
        list.AddFirst(0);
        list.RemoveLast();
        assertEquals("",list.Print(false));
    }

    @Test
    void removeLast_TwoObject() {
        LinkedList list = new LinkedList();
        list.AddFirst(0);
        list.AddFirst(1);
        list.RemoveLast();
        assertEquals("1",list.Print(false));
    }

    @Test
    void removeAt_Null() {
        LinkedList list = new LinkedList();
        assertThrows(NoSuchElementException.class, () -> {
            list.RemoveAt(0);
        });
    }

    @Test
    void removeAt_OutOfBounds() {
        LinkedList list = new LinkedList();
        assertThrows(NoSuchElementException.class, () -> {
            list.RemoveAt(5);
        });
    }

    @Test
    void removeAt_OneObject() {
        LinkedList list = new LinkedList();
        list.AddFirst(1);
        list.RemoveAt(0);
        assertEquals("",list.Print(false));
    }

    @Test
    void removeAt_ThreeObject() {
        LinkedList list = new LinkedList();
        list.AddFirst(1);
        list.AddFirst(2);
        list.RemoveAt(1);
        assertEquals("2",list.Print(false));
    }

    @Test
    void insertAt_Beginning() {
        LinkedList list = new LinkedList();
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddFirst(1);
        list.InsertAt(5, 0);
        assertEquals("5 1 2 3",list.Print(false));
    }

    @Test
    void insertAt_Middle() {
        LinkedList list = new LinkedList();
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddFirst(1);
        list.InsertAt(5, 1);
        assertEquals("1 5 2 3",list.Print(false));
    }

    @Test
    void insertAt_End() {
        LinkedList list = new LinkedList();
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddFirst(1);
        list.InsertAt(5, 3);
        assertEquals("1 2 3 5",list.Print(false));
    }

    @Test
    void hasLoopFalse() {
        LinkedList list = new LinkedList();
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddFirst(1);
        assertEquals(false, list.hasLoop());
    }

    @Test
    void GetValue_Beginning() {
        LinkedList list = new LinkedList();
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddFirst(1);
        assertEquals(1, list.GetValue(0));
    }

    @Test
    void GetValue_Middle() {
        LinkedList list = new LinkedList();
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddFirst(1);
        assertEquals(2, list.GetValue(1));
    }

    @Test
    void GetValue_End() {
        LinkedList list = new LinkedList();
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddFirst(1);
        assertEquals(3, list.GetValue(2));
    }

    @Test
    void Print_Ordered() {
        LinkedList list = new LinkedList();
        list.AddFirst(3);
        list.AddFirst(2);
        list.AddFirst(1);
        list.AddFirst(6);
        list.AddFirst(1);
        list.AddFirst(4);
        list.AddFirst(8);
        assertEquals("1 1 2 3 4 6 8", list.Print(true));
    }
}