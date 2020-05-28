package algorithms.chapt3;

import java.util.Iterator;

public class SequentialSearchST<Key, Value> implements ST<Key, Value> {
    private Node first;
    private int N = 0;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get (Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }

    @Override
    public void delete(Key key) {
        Node prev = null;
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(key)) {
                if (prev != null) {
                    prev.next = x.next;
                } else {
                    first = x.next;
                }
                N--;
                return;
            }
            prev = x;
        }
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }



}
