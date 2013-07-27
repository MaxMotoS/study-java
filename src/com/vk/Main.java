package com.vk;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 26.07.13
 * Time: 0:41
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(16);

        byte[] nonce = {
                (byte) 0x78, (byte) 0x97, (byte) 0x46, (byte) 0x60
        };

        for (int i = 0; i < 16; i++) {
            buffer.put((byte)(Math.random()*127));
        }
        byte[] nonceData = buffer.array();

        Session session = new Session();
        session.init(80);

        Message message = new Message();
        message.setMessageData(ByteBuffer.allocate(nonce.length + nonceData.length).put(nonce).put(nonceData).array());

        session.request(message);
        byte[] response = session.response();
        session.close();

//        show(response);
    }

    public static void show(byte[] data) {
        int byteInLine = 16;

        for (int i = 0; i <= data.length; i++) {
            if (((i) % byteInLine) == 0) {
                System.out.print(String.format("\n%#06x\t| ", (int) ((i) / byteInLine)));
            }
            System.out.print(String.format("%#04x ", data[i]));
        }
        System.out.println();
    }
}
