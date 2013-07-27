package com.vk;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created with IntelliJ IDEA.
 * User: Max
 * Date: 25.07.13
 * Time: 23:57
 * To change this template use File | Settings | File Templates.
 */
public class Message {
    private byte[] authId = new byte[8];
    private byte[] messageId = new byte[8];
    private byte[] messageDataLength = new byte[4];
    private byte[] messageData;

    public int getLength() {
        return authId.length + messageId.length + messageDataLength.length + messageData.length;
    }

    public byte[] getByte() {
        return ByteBuffer.allocate(authId.length + messageId.length + messageDataLength.length + messageData.length).
                put(authId).put(messageId).put(messageDataLength).put(messageData).array();
    }

    public void setMessageData(byte[] messageData) {
        this.messageData = messageData;
        messageId = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong((long)(System.currentTimeMillis()/1000) << 32).array();
        messageDataLength = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(messageData.length).array();
    }
}
