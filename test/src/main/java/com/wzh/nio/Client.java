package com.wzh.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Client {
    static Logger log = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        //就绪选择，selector作为任务分发器，把就绪的请求，派发给空闲channel
        Selector selector = Selector.open();
        socketChannel.bind(new InetSocketAddress(7777));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        new SelectorThread(selector).start();
    }
}
