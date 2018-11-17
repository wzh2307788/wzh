package com.wzh.jvm;

public class BigObjectTest {
    public static void test() throws InterruptedException {
        int t = 0;
        while (true) {
            System.out.println(t++);
            /**
             byte[] b=new byte[1024*1024*1024];  // 1、一次性分配1GB,报错 OutOfMemory
             byte[] b=new byte[512*1024*1024];  // 2、一次性报错512MB,ok
             char[] b=new char[512*1024*1024];  // 1、一次性分配1GB,报错 OutOfMemory
             char[] b=new char[256*1024*1024];  // 2、一次性报错512MB,ok
             **/


                byte[] b = new byte[512 * 1024 * 1024];  //进入老年代
                b = null;  // 注释此行，报错OutOfMemory
            System.out.println("b=null and k="+t);
            byte[] c = new byte[512 * 1024 * 1024];
            System.out.println("b.length ；" + c.length);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
