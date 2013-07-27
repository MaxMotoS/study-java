package com.vk;

import com.vk.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.CRC32;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 26.07.13
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
public class Session {
    private Socket socket;
    private int length;
    private int packetId;
    private Message message;
    private CRC32 hash;

    private byte[] concatanationArray(byte[] a, byte[] b) {
        byte[] newArray = new byte[a.length + b.length];
        int indexNewArray = 0;
        for (int i = 0; i < a.length; i++) { newArray[indexNewArray++] = a[i];}
        for (int i = 0; i < b.length; i++) { newArray[indexNewArray++] = b[i];}
        return newArray;
    }

    public void request(Message message) throws IOException {
        hash.reset();
        hash.update(ByteBuffer.
                allocate(4 + 4 + message.getLength()).
                order(ByteOrder.LITTLE_ENDIAN).
                putInt(length).
                putInt(packetId).
                put(message.getByte()).
                array());
        OutputStream outputStream = socket.getOutputStream();
        length = message.getLength() + 12;
        outputStream.write(ByteBuffer.
                allocate(4 + 4 + message.getLength() + 4).
                order(ByteOrder.LITTLE_ENDIAN).
                putInt(length).
                putInt(packetId).
                put(message.getByte()).
                putInt((int) hash.getValue()).
                array());
        outputStream.flush();
    }


    public byte[] response() throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[4096];
        while (true) {
            int r;
            r = inputStream.read(b);
            if (r > 0) {
                break;
            }
        }
        return b;
    }

    public void init(int port) throws IOException {
        socket = new Socket("95.142.192.65", 80);
        socket.setSoTimeout(120 * 1000);
        hash = new CRC32();
        packetId = 0;
    }

    public void close() throws IOException {
        socket.close();
    }
}
