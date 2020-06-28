package algorithms.chapt3;

public class SparseVector {
    private SequentialSearchST<Integer, Double> st;

    public SparseVector() {
        st = new SequentialSearchST<>();
    }

    public int size() {
        return st.size();
    }

    public void put(int i , double x) {
        st.put(i,x);
    }

    public double get(int i){
        if (!st.contains(i)) return 0.0;
        return st.get(i);
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : st.keys()) {
            sum += that[i] * this.get(i);
        }
        return sum;
    }


}
