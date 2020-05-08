package algorithms.chapt1;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int N = 0;

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(T item) {
        Node newNode = new Node(item, null);
        if (last != null) {
            last.next = newNode;
        }
        if (first == null) {
            first = newNode;
        }
        last = newNode;
        N++;
    }

    public T dequeue() {
        Node f = first;
        first = first.next;
        N--;
        return f.item;
    }

    private class QueueIterator implements Iterator<T> {
        Node current = first;

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

    public Iterator<T> iterator() {
        return new QueueIterator();
    }
}
