import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 27.07.13
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
public class ExecTCP {
    private final static int BYTE_IN_LINE = 16;
    private final static int BYTE_IN_GROUP = 4;
    private final static int CONVERT_RADIX = 16;

    public static void main(String[] args) throws IOException {
        if(args[0].compareTo("--help") == 0) {
            System.out.print(
                    "ExecTCP <host> <port> <request>\n" +
                    "\thost\t- name or ip of host that send request" +
                    "\tport\t- port of host" +
                    "\tpequest\t- request that send to host"
            );
            return;
        }

        TCP tcp = new TCP(args[0], Integer.parseInt(args[1]));
        tcp.init();

        tcp.setRequest(convertHexString(args[2]));
        showByteArray(tcp.getResponse());

        tcp.close();
    }

    private static void showByteArray(byte[] bytes) {
        int showBytes = 0;
        for (byte b : bytes) {
            if (showBytes % BYTE_IN_LINE == 0) {
                System.out.print(String.format("\n%04X\t", (int) (showBytes / BYTE_IN_LINE)));
            }
            if (showBytes % BYTE_IN_GROUP == 0) {
                System.out.print("  ");
            }
            System.out.print(String.format(" %02X", b));
            showBytes++;
        }
        System.out.println();
    }

    private static byte[] convertHexString(String str) {
        if (str.length() >= 2) {
            byte[] bytes = new byte[(int)(str.length() / 2)];
            for (int i = 0, ib = 0; i < str.length(); i += 2, ib++) {
                bytes[ib] = Byte.parseByte(str.substring(i, i+2), CONVERT_RADIX);
            }
            return bytes;
        } else {
            return null;
        }
    }

}
