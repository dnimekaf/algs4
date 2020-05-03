package algorithms.chapt1;

public class Euclid {
    /**
     * Наибольший общий делитель
     * @param p
     * @param q
     * @return
     */
    public int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q,r);
    }
}
