/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 23.07.13
 * Time: 14:05
 * To change this template use File | Settings | File Templates.
 */
public class SimpleNumeric {
    private static boolean isSimpleNumeric(long numeric) {
        for (long denominator = 2; denominator <= (numeric / 2); denominator++) {
            if ((numeric % denominator) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long numeric = 0;
        for (; numeric < 0xFF_FF_FF_FF_FFL; numeric++) {
            if (isSimpleNumeric(numeric)) {
                System.out.print(numeric + "\t");
            }
        }
    }
}
