import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 18.07.13
 * Time: 14:06
 * To change this template use File | Settings | File Templates.
 */
public class Client1Test {
    public static void main(String[] args) throws UnknownHostException {
        int port = Integer.parseInt(args[1]);
        String ipAddress = args[0];

        InetAddress inetAddress = InetAddress.getByName(ipAddress);

        try {
            Socket socket = new Socket(inetAddress, port);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            line = in.readUTF();
            System.out.println(line);

            while(true) {
                line = keyboard.readLine();
                System.out.println(">\t" + line);
            }

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }
}
