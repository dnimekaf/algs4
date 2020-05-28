package algorithms.chapt2;

public interface MinPQ<Key extends  Comparable<Key>> {
    void insert(Key v);
    Key min();
    Key delMin();
    boolean isEmpty();
    int size();
}
