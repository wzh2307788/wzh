package com.wzh.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Server {
    static Base base=new Base();
    Logger log = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = null;
        Selector selector = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 7777));
            serverSocketChannel.accept();

            selector = Selector.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        } finally {
            if (serverSocketChannel != null) {
                serverSocketChannel.close();
            }
            if (selector != null) {
                selector.close();
            }
        }
    }

    public static void handleSelector(Selector selector) throws IOException {
        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
        while(iterator.hasNext()){
            SelectionKey selectionKey = iterator.next();
            if(selectionKey.isAcceptable()){
                ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
               SocketChannel socketChannel = channel.accept()   ;
               base.readByBuffer(socketChannel);
            }
        }



    }
}
