import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 24.07.13
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */
public class TestConnectVK {
    public static void main(String[] args) {
        try {
            long timestamp = System.currentTimeMillis();
            System.out.println(timestamp + "\t" + String.format("%X", timestamp));
            System.out.println(timestamp/1000 + "\t" + String.format("%X", timestamp/1000));
            //System.out.println(timestamp<<32 + String.format("%X", (timestamp<<32)));

            Socket socket = new Socket("127.0.0.1", 1702);
            socket.setSoTimeout(10);
            System.out.print("Connected to 95.142.192.65:80");

            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            DataInputStream inData = new DataInputStream(in);

            byte[] data = {(byte) 0x00, 0x05, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xC4, 0x7A, (byte) 0xE5, 0x51,
                    0x14, 0x00, 0x00, 0x00, 0x78, (byte) 0x97, 0x46, 0x60, 0x3E, 0x05, 0x49, (byte) 0x82, (byte) 0x8C, (byte) 0xCA, 0x27, (byte) 0xE9,
                    0x66, (byte) 0xB3, 0x01, (byte) 0xA4, (byte) 0x8F, (byte) 0xEC, (byte) 0xE2, (byte) 0xFC};

            out.write(data);
          //  out.flush();

            out.close();

            // читаем ответ сервера, одновременно сливая его в открытый файл
/*            int r = 1;
            while(r > 0)
            {
                r = in.read(data);
                for (byte b : data) {
                    System.out.print(String.format("%X ", b));
                }
            }
*/
            /*byte[] readData = null;

            inData.read(readData);
            //in.read(readData);

            for (byte b : readData) {
                System.out.print(String.format("%X ", b));
            }*/

        } catch (IOException e) {
            System.out.print("Not connected");
        }

    }
}
