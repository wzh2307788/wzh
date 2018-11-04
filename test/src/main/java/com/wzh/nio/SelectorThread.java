package com.wzh.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorThread extends Thread {
  private  Selector selector;

    public SelectorThread(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            //获取注册的channel数量
            if(selector.select()<1){
                return ;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
             /*   if(selectionKey.isWritable())
                SocketChannel socketChannel= (SocketChannel) selectionKey.channel();
*/
             if(selectionKey.isReadable()){
                 Base.readByBuffer((SocketChannel) selectionKey.channel());
             }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
