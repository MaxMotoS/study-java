/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 18.07.13
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
import java.net.*;

public class Server {

    private static void msg(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        int port = 80;
        try {
            // открываем порт
            ServerSocket socketServer = new ServerSocket(port);

            // переводим в режим простлушивания порта
            Socket socket = socketServer.accept();

            InputStream sin = socket.getInputStream();
            //OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            //DataOutputStream out = new DataOutputStream(sout);

            byte[] readData = null;

            in.read(readData);

            for (byte b : readData) {
                System.out.print(String.format("%X ", b));
            }

        } catch (IOException e) {
            System.out.println("Port " + port + " isn't open");
        }
    }
}
