package algorithms.chapt1;

public class Heap {
    public int BinarySearch(int key, int[] a){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int EuclidMinCommonD(int p, int q) {
        if(q == 0) {
            return p;
        }

        int r = p % q;
        return EuclidMinCommonD(q, r);
    }
}
