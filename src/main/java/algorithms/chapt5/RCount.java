package algorithms.chapt5;

import lombok.Data;

public class RCount {
    private final int R;

    public RCount(int R) {
        this.R = R;
    }

    public void hz(Node[] a) {
        int N = a.length;
        String[] aux = new String[R];
        int[] count = new int[R+1];

        for (int i = 0; i < N; i++) {
            count[a[i].key +1]++;
        }

        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }

        for (int i = 0; i < N; i++) {
            aux[count[a[i].key]++] = a[i].val;
        }

        for(int i = 0; i < N; i++) {
            a[i].val = aux[i];
        }
    }

    @Data
    public class Node {
        public int key;
        public String val;
    }
}



