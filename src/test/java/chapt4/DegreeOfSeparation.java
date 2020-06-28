package chapt4;

import algorithms.chapt4.Graph;
import algorithms.chapt4.SymbolGraph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class DegreeOfSeparation {

    public void airportsTest() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data/routes.txt").getFile());
        Scanner sc = new Scanner(file);
        SymbolGraph sg = new SymbolGraph(sc, " ");
        Graph G = sg.G();
        // BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
    }
}
