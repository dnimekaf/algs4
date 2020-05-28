package chapt1;

import algorithms.chapt1.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void euclidGcdTest() {
        var test = new Euclid();
        var result = test.gcd(42, 24);
        assertEquals(6, result);
    }

    @Test
    public void eudclidGcdTestByMe() {
        var test = new Heap();
        var result = test.EuclidMinCommonD(42,24);
        assertEquals(6, result);
    }

    @Test
    public void binarySearchTest() {
        var arr = new int[]{1,2,5,7,9,13,24,26,78,96,102,113};
        var bsListing = new BinarySearch();
        var listingResult = bsListing.rank(78, arr);
        assertEquals(8, listingResult);
        var bs = new Heap();
        var result = bs.BinarySearch(78, arr);
        assertEquals(listingResult, result);
    }

    @Test
    public void statisSetofIntsTest() {
        var arr = new int[]{1,2,5,7,9,13,24,26,78,96,102,113};
        var tested =  new StaticSETofInts(arr);
        assertEquals(true, tested.contains(2));
//        assertEquals(false, tested.contains(3));
//        assertEquals(true, tested.contains(113));
//        assertEquals(true, tested.contains(1));
//        assertEquals(true, tested.contains(13));
//        assertEquals(false, tested.contains(24));
    }

    @Test
    public void DijkstraEvaluateTest() {
        var exp1 = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        var exp2 = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )";
        var tested = new Dijkstra();
        double result = tested.Evaluate(exp1);
        assertEquals(101.0, result);
        result = tested.Evaluate(exp2);
        assertEquals(1.618033988749895, result);
    }

    @Test
    public void FixedCapacityStackOfStringsTest() {
        var tested = new FixedCapacityStackOfStrings(10);
        String[] data = new String[] {"to", "be", "or", "not", "to", "be", "that", "is"};
        for (String item : data) {
            tested.push(item);
        }
        assertEquals(8, tested.size());
        assertEquals("is", tested.pop());
        assertEquals("that", tested.pop());

    }

    @Test
    public void FixedCapacityStackTest() {
        var tested = new FixedCapacityStack<String>(2);
        String[] data = new String[] {"to", "be", "or", "not", "to", "be", "that", "is"};
        for (String item : data) {
            tested.push(item);
        }
        assertEquals(8, tested.size());
        assertEquals("is", tested.pop());
        assertEquals("that", tested.pop());

    }

    @Test
    public void IterationTest() {
        var tested = new FixedCapacityStack<String>(2);
        String[] data = new String[] {"to", "be", "or", "not", "to", "be", "that", "is"};
        for (String item : data) {
            tested.push(item);
        }
        assertEquals(8, tested.size());
        for (String el : tested) {
            System.out.println(el);
        }
    }

    @Test
    public void LinkedListIterationTest() {
        var tested = new Stack<String>();
        String[] data = new String[] {"to", "be", "or", "not", "to", "be", "that", "is"};
        for (String item : data) {
            tested.push(item);
        }
        assertEquals(8, tested.size());
        for (String el : tested) {
            System.out.println(el);
        }
    }

    @Test
    public void QueueTest() {
        var tested = new Queue<String>();
        assertEquals(true, tested.isEmpty());
        assertEquals(0, tested.size());

        tested.enqueue("to");
        assertEquals(false, tested.isEmpty());
        assertEquals(1, tested.size());

        var value = tested.dequeue();
        assertEquals(true, tested.isEmpty());
        assertEquals(0, tested.size());
        assertEquals("to", value);

        String[] data = new String[] {"to", "be", "or", "not", "to", "be", "that", "is"};
        for (String item : data) {
            tested.enqueue(item);
        }
        assertEquals(8, tested.size());
        for (String el : tested) {
            System.out.println(el);
        }
    }

    @Test
    public void TwoSumFastTest() {
        int[] a = new int[10000];

        for(int i = 0; i < a.length; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(-100, 100);
        }

        var tested = new TwoSumFast(new BinarySearch());
        var timer = new StopWatch();
        timer.start();
        var result = tested.count(a);
        System.out.println(String.format("Count: %s. Elapsed: %s", result, timer.getTime()));
    }

    @Test
    public void ThreeSumFastTest() {
        int[] a = new int[10000];

        for(int i = 0; i < a.length; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(-100, 100);
        }

        var tested = new ThreeSumFast(new BinarySearch());
        var timer = new StopWatch();
        timer.start();
        var result = tested.count(a);
        System.out.println(String.format("Count: %s. Elapsed: %s", result, timer.getTime()));
    }

    // Выполняется бесконечно
    @Disabled
    @Test
    public void ThreeSumFastTimerTest() {
        var tested = new ThreeSumFast(new BinarySearch());
        var ratio = new DoublingRatio();
        ratio.run(tested);
    }

    @Test
    public void ReverseTest() {
        var tested = new Queue<Integer>();
        tested.enqueue(1);
        tested.enqueue(2);
        tested.enqueue(3);
        tested.enqueue(4);
        tested.enqueue(5);
        var reversed = tested.reverse();
        assertEquals(5, reversed.dequeue());
        assertEquals(4, reversed.dequeue());
        assertEquals(3, reversed.dequeue());
        assertEquals(2, reversed.dequeue());
        assertEquals(1, reversed.dequeue());
        assertEquals(1, tested.dequeue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"tinyUF.txt", "mediumUF.txt", "largeUF.txt"})
    public void WeightedUFTest(String filename) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data/" + filename).getFile());
        Scanner sc = new Scanner(file);
        var firstList = sc.nextLine();
        int numDigits = Integer.parseInt(firstList);
        var tested = new WeightedQuickUnionUF(numDigits);
        StopWatch sw = new StopWatch();
        sw.start();
        while(sc.hasNext()){
            String nextLine = sc.nextLine();
            String[] parts = nextLine.split(" ");
            tested.union(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }

        sw.stop();
        System.out.println(String.format("Elapsed: %s", sw.getTime())); // 1 24 2136



    }


}
