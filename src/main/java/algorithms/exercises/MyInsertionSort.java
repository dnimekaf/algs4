package algorithms.exercises;

import algorithms.chapt2.SortBase;

public class MyInsertionSort extends SortBase {


    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++ ) {
            Comparable currentValue = a[i];
            int j = i;
            while (j > 0 && a[j-1].compareTo(currentValue) > 0) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = currentValue;
        }
    }
}
