package chapt1;

import algorithms.chapt1.BinarySearch;
import algorithms.chapt1.Euclid;
import algorithms.chapt1.Heap;
import algorithms.chapt1.StaticSETofInts;
import org.junit.jupiter.api.Test;
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


}
