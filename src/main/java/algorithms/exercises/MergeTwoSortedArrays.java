package algorithms.exercises;

public class MergeTwoSortedArrays {

    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aPos = 0, bPos = 0;
        for (int i = 0; i < result.length; i++) {
            if (aPos >= a.length)           result[i] = b[bPos++];
            else if (bPos >= b.length)      result[i] = a[aPos++];
            else if (a[aPos] < b[bPos])     result[i] = a[aPos++];
            else                            result[i] = b[bPos++];
        }
        return result;
    }

    // one array
    public int[] merge(int[] a, int mid) {
        int[] result = new int[a.length];
        int aPos = 0, bPos = mid + 1;
        for (int i = 0; i < result.length; i++) {
            if (aPos > mid)                 result[i] = a[bPos++];
            else if (bPos >= a.length)      result[i] = a[aPos++];
            else if (a[aPos] < a[bPos])     result[i] = a[aPos++];
            else                            result[i] = a[bPos++];
        }
        return result;
    }


    // all in one array
    public int[] merge(int[] a, int lo, int mid, int hi) {
        int[] result = new int[a.length];
        int aPos = lo, bPos = mid + 1;
        for (int i = lo; i < hi; i++) {
            if (aPos > mid)                 result[i] = a[bPos++];
            else if (bPos >= hi)            result[i] = a[aPos++];
            else if (a[aPos] < a[bPos])     result[i] = a[aPos++];
            else                            result[i] = a[bPos++];
        }
        return result;
    }
}
