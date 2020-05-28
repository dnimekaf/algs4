package algorithms.chapt2;

public interface MaxPQ<Key> {
    void insert(Key v);
    Key max();
    Key delMax();
    boolean isEmpty();
    int size();

}