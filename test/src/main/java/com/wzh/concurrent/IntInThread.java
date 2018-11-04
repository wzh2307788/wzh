package com.wzh.concurrent;

public class IntInThread {

   static int i=0;
    public static void main(String[] args) {
    //  final  int i=0;
        Thread t=new Thread(){
            @Override
            public void run() {
                System.out.println(i++);
            }
        };
    }
}
