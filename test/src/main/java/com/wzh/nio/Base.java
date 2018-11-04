package com.wzh.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;

public class Base {
    static Logger log= LoggerFactory.getLogger(Base.class);
    public static void readByBuffer(SocketChannel channel){
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        try {
            channel.read(byteBuffer);
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                log.debug(String.valueOf(byteBuffer.get()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
