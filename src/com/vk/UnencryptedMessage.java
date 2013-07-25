package com.vk;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 25.07.13
 * Time: 23:59
 * To change this template use File | Settings | File Templates.
 */
public class UnencryptedMessage extends Message {
    private final static byte HEAD_MESSAGE = (byte)0xEF;

    private byte[] messageLength;
    private long authId;
    private long messageId;
    private int messageDataLength;
    private byte[] messageData;

    public UnencryptedMessage(byte[] newMessageData) {
        authId = 0;
        messageId = 0;
        messageDataLength = newMessageData.length;
        messageData = newMessageData;

        int mesLen = (20 + messageDataLength + 16) / 4;
        if (mesLen < 126) {
            messageLength = new byte[1];
            messageLength[0] = (byte)mesLen;
        } else {
            ByteBuffer buffer = ByteBuffer.allocate(4);
            buffer.putInt(mesLen);
            messageLength = buffer.array();
        }
    }

    public byte[] sendMessage(OutputStream outputStream) throws IOException {
        messageId = (System.currentTimeMillis() << 32);
        ByteBuffer buffer = ByteBuffer.allocate(17 + messageLength.length + 20 + messageDataLength).order(ByteOrder.LITTLE_ENDIAN);
        buffer.
        //        put(HEAD_MESSAGE).
                put(messageLength).
                putLong(authId).
                putLong(messageId).
                putInt(messageDataLength).
                put(messageData);
        for (int i = 0; i < 16; i++) {
            buffer.put((byte)(Math.random()*127));
        }
        byte[] head = {(byte)0xEF};
        outputStream.write(head);
        outputStream.flush();
        outputStream.write(buffer.array());
        return buffer.array();
    }
}
