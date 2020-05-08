package algorithms.chapt1;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private Node first;
    private int N;

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
        N++;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public T peek() {
       return first.item;
    }


    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T value = current.item;
            current = current.next;
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
