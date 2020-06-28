package algorithms.chapt4;

import java.util.LinkedList;
import java.util.List;

public class Digraph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for (int v = 0 ; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public int V() { return V; }
    public int E() { return E; }
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w,v);
            }
        }
        return R;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " вершин, " + E + " ребер\n");
        for (int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for (int w : this.adj(v)) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
