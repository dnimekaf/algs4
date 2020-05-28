package algorithms.chapt2;

public class InsertionSort extends SortBase {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            int j = i;
            Comparable currentValue = a[i];
            while (j > 0 && a[j-1].compareTo(currentValue) > 0) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = currentValue;
        }
    }
}
