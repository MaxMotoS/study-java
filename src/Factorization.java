/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 24.07.13
 * Time: 14:56
 * To change this template use File | Settings | File Templates.
 */
public class Factorization {
    private int p = 0;
    private int q = 0;

    public void init(long pq) {
        int p = (int)Math.sqrt(pq);
        while ((pq % p) != 0) {
            p--;
        }
        q = (int)(pq / p);
        System.out.println(String.format("p = %X \nq = %X", p, q));
    }

    public static void main(String[] args) {
        Factorization f = new Factorization();
        f.init(0x17_ED_48_94_1A_08_F9_81L);
    }
}
