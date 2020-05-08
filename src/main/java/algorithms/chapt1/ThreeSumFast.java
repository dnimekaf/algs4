package algorithms.chapt1;

import java.util.Arrays;
import java.util.function.Consumer;

public class ThreeSumFast implements Consumer<int[]> {
    BinarySearch bs;

    public ThreeSumFast(BinarySearch search) {
        bs = search;
    }

    public int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++ ) {
                if (bs.rank(-a[i]-a[j], a) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    @Override
    public void accept(int[] ints) {
        count(ints);
    }
}
