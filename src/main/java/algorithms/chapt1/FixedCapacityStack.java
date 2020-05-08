package algorithms.chapt1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<T> implements Iterable<T>{
    private T[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (T[])new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    public T pop() {
        T item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    private void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }
        public T next() {
            if (i == 0) {
                throw new NoSuchElementException();
            }
            return a[--i];
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

