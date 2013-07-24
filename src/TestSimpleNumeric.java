import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 23.07.13
 * Time: 14:05
 * To change this template use File | Settings | File Templates.
 */
public class TestSimpleNumeric {
    private static boolean isSimpleNumeric(long numeric) {
        for (long denominator = 2; denominator <= (numeric / 2); denominator++) {
            if ((numeric % denominator) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long numeric = Integer.parseInt(args[0]);
        if (isSimpleNumeric(numeric)) {
            System.out.print(numeric + " is simple\t");
        } else {
            System.out.print(numeric + " isn't simple\t");
        }
    }
}
