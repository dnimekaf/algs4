package algorithms.chapt1;

public class UFQuickSearch extends UFTemplate {

    public UFQuickSearch(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < id.length; i++ ) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }
}
