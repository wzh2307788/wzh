package com.wzh.nio;

import java.nio.Buffer;
import java.nio.LongBuffer;

public class BufferTest {
    public static void main(String[] args) {
        LongBuffer longBuffer=LongBuffer.allocate(9);
        printBufferInfo(longBuffer);
        longBuffer.put(10l);
        longBuffer.put(new long[]{20l, 30l});
        longBuffer.put(40l);
        longBuffer.put(50l);
        printBufferInfo(longBuffer);
        longBuffer.flip(); //flip翻转，指的是读写转换，   写-》读
        printBufferInfo(longBuffer);
        while(longBuffer.hasRemaining()){
            System.out.println(longBuffer.get());
        }
        printBufferInfo(longBuffer);
    }
    public static void printBufferInfo(Buffer buffer){
        System.out.println("-----------------------");
        System.out.println("position="+buffer.position());
        System.out.println("limit="+buffer.limit());
        System.out.println("capacity=" +buffer.capacity());
    }
}
