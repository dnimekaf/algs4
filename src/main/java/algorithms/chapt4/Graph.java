package algorithms.chapt4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph {

    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public Graph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v,w);
        }
    }

    public int V() { return V; }
    public int E() { return E; }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
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
