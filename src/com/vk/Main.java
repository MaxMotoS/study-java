package com.vk;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 26.07.13
 * Time: 0:41
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        byte[] nonce = {
                (byte) 0x60, (byte) 0x46, (byte) 0x97, (byte) 0x78
        };

        Socket socket = new Socket("95.142.192.65", 80);
        socket.setSoTimeout(600000);
        System.out.println("Connected to 95.142.192.65:80");

        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();

        UnencryptedMessage message = new UnencryptedMessage(nonce);
        byte[] byteMessage = message.sendMessage(out);
        out.flush();

        showReadData2(byteMessage, System.out, byteMessage.length );


        // читаем ответ сервера, одновременно сливая его в открытый файл
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

    public static void showReadData(byte[] data, PrintStream out, int r) {
        int offsetData = 1;
        int byteInLine = 16;

        out.print(String.format("Length:\t%X", data[0]));
        for (int i = offsetData; i <= r; i++) {
            if (((i - offsetData) % byteInLine) == 0) {
                out.print(String.format("\n%#06x\t| ", (int) ((i - offsetData) / byteInLine)));
            }
            out.print(String.format("%#04x ", data[i]));
        }
        out.println();
    }

    public static void showReadData2(byte[] data, PrintStream out, int r) {
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
