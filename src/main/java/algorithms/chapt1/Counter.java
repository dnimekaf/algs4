package algorithms.chapt1;

public class Counter {
    private final String id;
    private int value;

    public Counter(String id) {
        this.id = id;
    }

    public void increment() {
        value++;
    }

    public int tally() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s %d", id, value);
    }

}
