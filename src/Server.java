/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 18.07.13
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
import java.net.*;
import java.util.Locale;

public class Server {

    private static void msg(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        int port = 1702;
        try {
            // открываем порт
            ServerSocket socketServer = new ServerSocket(port);

            while(true){
                // переводим в режим простлушивания порта
                Socket socket = socketServer.accept();

                // получаем входной поток
                InputStream in = socket.getInputStream();

                // читаем входной поток и отображаем его на экране
                byte[] b = new byte[4096];

                while (true) {
                    int r;
                    r = in.read(b);
                    if (r > 0) {
                        showReadData(b, System.out, r);
                        socket.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showReadData(byte[] data, PrintStream out, int r) {
        int offsetData = 2;
        int byteInLine = 16;

        out.print(String.format("Header:\t%X\nLength:\t%X", data[0], data[1]));
        for (int i = offsetData; i < r; i++) {
            if (((i - offsetData) % byteInLine) == 0) {
                out.print(String.format("\n%#06x\t| ", (int) ((i - offsetData) / byteInLine)));
            }
            out.print(String.format("%#04x ", data[i]));
        }
        out.println();
    }
}
