package algorithms.chapt4;

import java.util.HashMap;
import java.util.Scanner;

public class SymbolGraph {
    private HashMap<String, Integer> st;
    private String[] keys;
    private Graph G;

    public SymbolGraph(Scanner sc, String separator) {
        st = new HashMap<>();
        while (sc.hasNext()) {
            String[] a = sc.nextLine().split(separator);
            for (int i = 0; i < a.length; i++) {
                if (!st.containsKey(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }
        keys = new String[st.size()];
        for (String name : st.keySet()) {
            keys[st.get(name)] = name;
        }
        G = new Graph(st.size());
        sc.reset();
        while (sc.hasNext()) {
            String[] a = sc.nextLine().split(separator);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s) {
        return st.containsKey(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph G() {
        return G;
    }


}
