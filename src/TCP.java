import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 27.07.13
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class TCP {
    private final static int MAX_RESPONSE_LENGTH = 65535;

    private byte[] request = null;
    private byte[] response = null;
    private String host = "";
    private int port = 0;
    private boolean requestIsMade = false;
    private Socket socket = null;

    public TCP() {
    }

    public TCP(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public TCP(String host, int port, byte[] request) {
        this.request = request;
        this.host = host;
        this.port = port;
    }

    public byte[] getRequest() {
        return request;
    }

    public void setRequest(byte[] request) {
        requestIsMade = false;
        response = null;
        this.request = request;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        if (host.length() != 0) {
            this.host = host;
        } else {
            System.out.println("Host is empty");
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        if (port >= 0 && port <= 65535) {
            this.port = port;
        } else {
            System.out.println("Invalid number port");
        }
    }

    public byte[] getResponse() throws IOException {
        if (!requestIsMade) {
            runQuery();
        }
        return response;
    }

    public void runQuery() throws IOException {
        if (socket == null) {
            init();
        }
        if (request != null) {
            OutputStream outputStream = socket.getOutputStream();
            InputStream  inputStream  = socket.getInputStream();

            outputStream.write(request);
            outputStream.flush();

            response = new byte[MAX_RESPONSE_LENGTH];
            int r = 0;
            while(r < 1) {
                r = inputStream.read(response);
            }
        }
    }

    public void init() throws IOException {
        if (host != null) {
            socket = new Socket(host, port);
        }
    }

    public void close() throws IOException {
        socket.close();
    }
}
