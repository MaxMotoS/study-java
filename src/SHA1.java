import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 24.07.13
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public class SHA1 {
    public static byte[] toSHA1(byte[] convertme) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md.digest(convertme);
    }

    public static void main(String[] args) {
        if (args.length ==1) {
            byte[] sha1 = toSHA1(args[0].getBytes());
            for (byte b : sha1) {
                System.out.print(String.format("%X ", b));
            }
        } else {
            byte[] data = new byte[args.length];
            for (int i = 0; i < args.length; i++) {
                data[i] = (byte)Integer.parseInt(args[i], 16);
            }
            for (byte b : data) {
                System.out.print(String.format("%X ", b));
            }
            System.out.println("\n");
            byte[] sha1 = toSHA1(data);
            for (byte b : sha1) {
                System.out.print(String.format("%X ", b));
            }
        }
    }
}
