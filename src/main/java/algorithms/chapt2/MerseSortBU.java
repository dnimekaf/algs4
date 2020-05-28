package algorithms.chapt2;

public class MerseSortBU extends AbstractMergeSort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[a.length];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for(int lo = 0; lo < N - sz; lo += sz+sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N - 1));
            }
        }
    }
}
