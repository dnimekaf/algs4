package algorithms.chapt1;

import java.util.Arrays;

public class TwoSumFast {
    BinarySearch bs;

    public TwoSumFast(BinarySearch search) {
        bs = search;
    }

    public int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(bs.rank(-a[i], a) > i) {
                cnt++;
            }
        }
        return cnt;
    }
}
