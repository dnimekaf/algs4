import algorithms.chapt1.Stack;
import algorithms.chapt2.*;
import algorithms.exercises.MergeTwoSortedArrays;
import algorithms.exercises.MyInsertionSort;
import models.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class chapt2 {

    @Test
    public void selectionSortTest() {
        var tested = new SelectionSort();
        String[] arr = new String[] {"S","O","R","T","E","X","A","M","P","L","E"};
        Assertions.assertEquals(false, tested.isSorted(arr));
        tested.sort(arr);
        Assertions.assertEquals(true, tested.isSorted(arr));
        tested.show(arr);

    }

    @Test
    public void insertionSortTest() {
        var tested = new MyInsertionSort();
        String[] arr = new String[] {"S","O","R","T","E","X","A","M","P","L","E"};
        Assertions.assertEquals(false, tested.isSorted(arr));
        tested.sort(arr);
        Assertions.assertEquals(true, tested.isSorted(arr));
        tested.show(arr);

    }

    @Test
    public void shellSortTest() {
        var tested = new ShellSort();
        String[] arr = new String[] {"S","O","R","T","E","X","A","M","P","L","E"};
        Assertions.assertEquals(false, tested.isSorted(arr));
        tested.sort(arr);
        Assertions.assertEquals(true, tested.isSorted(arr));
        tested.show(arr);

    }

    @Test
    public void mergeSortTest() {
        var tested = new MergeSort();
        String[] arr = new String[] {"M", "E", "R", "G", "E", "S","O","R","T","E","X","A","M","P","L","E"};
        Assertions.assertEquals(false, tested.isSorted(arr));
        tested.sort(arr);
        Assertions.assertEquals(true, tested.isSorted(arr));
        tested.show(arr);

    }

    @Test
    public void mergeTest1() {
        var tested = new MergeTwoSortedArrays();

        var result = tested.merge(new int[]{1,4,8,10, 2,3,5,7,11,12,13}, 0, 3, 11);
        for(int i =0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    @Test
    public void quickSortTest() {
        var tested = new QuickSort();
        String[] arr = new String[] {"Q", "U", "I", "C", "K", "S","O","R","T","E","X","A","M","P","L","E"};
        Assertions.assertEquals(false, tested.isSorted(arr));
        tested.sort(arr);
        tested.show(arr);
        Assertions.assertEquals(true, tested.isSorted(arr));
        tested.show(arr);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 5, 6})
    public void maxPQTest(int M) throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("data/tinyBatch.txt").getFile());
        Scanner sc = new Scanner(file);
        MinPQImpl<Transaction> tested = new MinPQImpl<Transaction>(16);
        while(sc.hasNext()) {
            tested.insert(new Transaction(sc.nextLine()));;
        }
        sc.close();
        while(tested.size() > M) {
            tested.delMin();
        }
        Stack<Transaction> transactions = new Stack<>();
        while(tested.isEmpty() == false) {
            transactions.push(tested.delMin());
        }

        for(Transaction t : transactions) {
            System.out.println(t);
        }
    }

    @Test
    public void BinareHeapSortTest() {
        var tested = new BinaryHeapSort();
        String[] arr = new String[] {"B", "I", "N", "A", "R", "Y", "H", "E", "A", "P", "S","O","R","T","E","X","A","M","P","L","E"};
        Assertions.assertEquals(false, tested.isSorted(arr));
        tested.sort(arr);
        Assertions.assertEquals(true, tested.isSorted(arr));
        tested.show(arr);
    }

}
