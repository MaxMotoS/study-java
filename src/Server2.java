import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: max
 * Date: 22.07.13
 * Time: 0:57
 * To change this template use File | Settings | File Templates.
 */
public class Server2 {

    private final static String HELLO_CLIENT = "Hello, client!";

    private int port = 17289;
    private Socket socket;
    private ServerSocket serverSocket;
    private String line;

    public void startServer(int newPort) throws IOException {
        port = newPort;

        startServer();
    }

    public void startServer() throws IOException {
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            out.writeUTF(HELLO_CLIENT);
            out.flush();

            while(true) {
                line = in.readUTF();
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) {
        Server2 server = new Server2();
        try {
            server.startServer();
        } catch (IOException e) {
            System.out.println("Server isn't start");
        }
    }
}
