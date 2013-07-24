/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 24.07.13
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */
public class ExSqrt {
    public static void main(String[] args) {
        int steps = 100;
        int x, y;
        System.out.println("p\t| q\t| p x q\t| sqrt(pq)");
        System.out.println("----------------------------------------------------------------------");
        for (int i = 0, j = steps; i < steps; i++, j--) {
            //if (i%2!=0)
            System.out.println((i) + "\t| " + (j) + "\t| " + (i*j) + "\t| " + (Math.sqrt(i*j)));
        }

        System.out.println("----------------------------------------------------------------------\n");

        /* Дано:
         p < q
         p*q = 40
          */
    }
}
