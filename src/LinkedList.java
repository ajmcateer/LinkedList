import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Linked List class
 */
public class LinkedList {
    /**
     * private class used by the linked list to store data and next location of a node in the list
     */
    private class Node{
        Node next;
        int data;

        Node(Node _next, int _data){
            this.next = _next;
            this.data = _data;
        }
    }

    /**
     * stores the start of the list
     */
    private Node head = null;

    /**
     * Stores the end of the list
     */
    private Node tail = null;

    /**
     * public property that stores the size of the list
     */
    public int currentSize = 0;

    /**
     * Adds a new Node to the beginning of the list
     * @param data the integer you want to add to the list
     */
    public void AddFirst(int data){
        if (head == null)
        {
            head = new Node(null, data);
            tail = head;
            currentSize++;
        }
        else
        {
            Node newNode = new Node(head, data);
            head = newNode;
            currentSize++;
        }
    }

    /**
     * Adds an object to the end of the list
     * @param data The integer you want to add to the list
     */
    public void AddLast(int data)
    {
        if (head == null){
            head = new Node(null,data);
            tail=head;
            currentSize++;
        }
        else
        {
            tail.next = new Node(null, data);
            tail = tail.next;
            currentSize++;
        }
    }


    /**
     * Removes an element at the selected position in the list
     * @param pos The position of the element you want to remove
     */
    public void RemoveAt(int pos)
    {
        Node node = head;
        if (head == null){
            throw new NoSuchElementException();
        } else if (pos > currentSize - 1)
        {
            throw new IndexOutOfBoundsException();
        }
        else if (pos == 0)
        {
            head = head.next;
            currentSize--;
        }
        else
        {
            for (int i = 0; i < pos - 1; i++)
            {
                node = node.next;
            }
            Node next = node.next.next;
            node.next = next;
            currentSize--;
        }
    }

    /**
     * Adds an element to the selected position of the list
     * @param data the data to add
     * @param pos the position to add the data
     */
    public void InsertAt(int data, int pos){
        if (pos > currentSize)
        {
            throw new IndexOutOfBoundsException();
        }
        else if (pos == 0)
        {
            Node newNode = new Node(head, data);
            head = newNode;
            currentSize--;
        }
        else
        {
            Node temp = head;
            for(int i = 0; i < pos - 1; i++){
                temp = temp.next;
            }
            Node newNode = new Node(temp.next, data);
            temp.next = newNode;
            currentSize--;
        }
    }

    /**
     * Removes the first element of the list
     */
    public void RemoveFirst()
    {
        if (head == null)
        {
            throw new NoSuchElementException();
        }
        else if (currentSize == 1)
        {
            head = null;
            tail = null;
            currentSize--;
        }
        else
        {
            head = head.next;
            currentSize--;
        }
    }

    /**
     * Removes the last element of the list
     */
    public void RemoveLast(){
        if (head == null)
        {
            throw new NoSuchElementException();
        }
        else if (currentSize == 1)
        {
            head = null;
            tail = null;
            currentSize--;
        }
        else
        {
            Node current = head.next;
            Node previous = head;
            while (current.next != null)
            {
                current = current.next;
                previous = previous.next;
            }
            previous.next = null;
            tail = previous;
            currentSize--;
        }
    }

    /**
     * @return Returns true or false depending on whether there is a loop in the list or not
     */
    public Boolean hasLoop()
    {
        Boolean isLoop = true;
        if (head == null)
        {
            isLoop = false;
        }
        else
        {
            Node current = head;
            for(int i = 0; i < currentSize; i++)
            {
                if (current.next == null)
                {
                    isLoop = false;
                }
                else
                {
                    current = current.next;
                }
            }
        }
        return isLoop;
    }

    /**
     * Gets the value of the Node at the specified position
     * @param pos The position you want to get data from
     * @return The data from the node
     */
    public int GetValue(int pos)
    {
        Node temp = head;
        for (int i = 0; i < pos; i++)
        {
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     * Returns a string of the list
     * @param ordered Tells the method if you want to order it or return it as is
     * @return a string of the list
     */
    public String Print(Boolean ordered)
    {
        Node current = head;
        if (ordered)
        {
            int[] unsortedArray = new int[currentSize];
            for (int i = 0; i <= currentSize - 1; i++)
            {
                unsortedArray[i] = current.data;
                current = current.next;
            }
            Arrays.sort(unsortedArray);
            StringBuilder output = new StringBuilder();
            for (int var : unsortedArray)
            {
                output.append(var).append(" ");
            }
            return output.toString().trim();
        }
        else
        {
            StringBuilder output = new StringBuilder();
            while (current != null)
            {
                output.append(current.data).append(" ");
                current = current.next;
            }
            return output.toString().trim();
        }
    }
}
