package com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 26.07.13
 * Time: 23:54
 * To change this template use File | Settings | File Templates.
 */
public class TestVKKKKK {
    public static void main(String[] arg) throws IOException {
        Socket socket = new Socket("95.142.192.65", 80);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write((byte)0x01);
    }
}
