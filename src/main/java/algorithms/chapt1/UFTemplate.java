package algorithms.chapt1;

public abstract class UFTemplate {
    protected int[] id;
    protected int count;

    public UFTemplate(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public abstract int find(int p);
    public abstract void union(int p, int q);
}


