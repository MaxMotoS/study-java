/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 25.07.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
public class ByteToString {
    public static void main(String[] args) {
        for (String str : args) {
            System.out.print((char)Integer.parseInt(str, 16));
        }
    }
}
