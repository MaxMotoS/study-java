/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 18.07.13
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {

    private static void msg(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            // открываем порт
            ServerSocket socketServer = new ServerSocket(port);

            // переводим в режим простлушивания порта
            Socket socket = socketServer.accept();

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;

            out.writeUTF("Hello Client!!! :)");
            out.flush();

            while(true) {
                line = in.readUTF();
                System.out.println(line);
            }

            //socketServer.close();
            //System.out.println("Port " + port + " is closed");

        } catch (IOException e) {
            System.out.println("Port " + port + " isn't open");
        }
    }
}
