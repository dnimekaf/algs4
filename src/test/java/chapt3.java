import algorithms.chapt3.BST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class chapt3 {

    private BST<Integer, String> getTested() {
        var tested = new BST<Integer, String>();
        tested.put(1, "To");
        tested.put(2, "be");
        tested.put(3, "or");
        tested.put(4, "not");
        tested.put(5, "to");
        tested.put(6, "be");
        return tested;
    }

    @Test
    public void BSTGetTest() {
        var tested = getTested();

        assertEquals("be", tested.get(6));
        assertEquals("or", tested.get(3));
    }

    @Test
    public void BSTMinTest() {
        var tested = getTested();
        assertEquals(1, tested.min());
    }

    @Test
    public void BSTMaxTest() {
        var tested = getTested();
        assertEquals(6, tested.max());
    }

    @Test
    public void BSTFloorTest() {
        var tested = getTested();
        assertEquals(6, tested.floor(7));
    }

    @Test
    public void BSTCeilingTest() {
        var tested = getTested();
        assertEquals(1, tested.ceiling(0));
    }

    @Test
    public void BSTDeleteMinTest() {
        var tested = getTested();
        tested.deleteMin();
        assertEquals(2, tested.min());
    }

    @Test
    public void BSTDeleteTest() {
        var tested = getTested();
        assertEquals("be", tested.get(2));
        tested.delete(2);
        assertEquals(null, tested.get(2));
    }

    @Test
    public void BSTSelectTest() {
        var tested = getTested();
        assertEquals(3, tested.select(2));
    }

    @Test
    public void BSTRankTest() {
        var tested = getTested();
        assertEquals(2, tested.rank(3));
    }

    @Test
    public void BSTSizeTest() {
        var tested = getTested();
        assertEquals(6, tested.size());
    }

    @Test
    public void BSTToStringTest() {
        var tested = getTested();
        assertEquals("123456", tested.toString());
    }



}

