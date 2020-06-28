package chapt4;

import algorithms.chapt4.Graph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraptTest {

    @Test
    public void loadFromFileTest() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data/tinyG.txt").getFile());
        Scanner sc = new Scanner(file);
        var g = new Graph(sc);
        System.out.println(g.toString());
    }

    @Test
    public void loadFromFileTestMedium() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data/mediumG.txt").getFile());
        Scanner sc = new Scanner(file);
        var g = new Graph(sc);
        System.out.println(g.toString());
    }

    @Test
    public void loadFromFileLarge() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data/largeG.txt").getFile());
        Scanner sc = new Scanner(file);
        var g = new Graph(sc);
        System.out.println(g.toString());
    }
}
