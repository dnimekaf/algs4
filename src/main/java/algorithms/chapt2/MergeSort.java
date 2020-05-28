package algorithms.chapt2;

public class MergeSort extends AbstractMergeSort {


    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (hi - lo) / 2 + lo;
        sort(a, lo, mid); // Сортировка левой половины
        sort(a, mid + 1, hi); // Сортировка правой половины
        if (less(a[mid], a[mid+1])) return;
        merge(a, lo, mid, hi); // Слияние результатов
    }
}
