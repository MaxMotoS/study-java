import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: mvsereb3
 * Date: 22.07.13
 * Time: 12:57
 * To change this template use File | Settings | File Templates.
 */
public class SimpleHttpRequest {
    public static void main(String[] args) throws IOException {
        URL serverAddress = null;
        HttpURLConnection connection = null;
        DataInputStream in = null;
        String data = null;

        serverAddress = new URL("http://" + args[0]);

        connection = (HttpURLConnection)serverAddress.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setReadTimeout(10000);

        connection.connect();

        in = new DataInputStream(connection.getInputStream());

        while ((data = in.read()) != null) {
            System.out.println(data);
        }

        connection = null;
        serverAddress = null;
        in = null;
    }
}
