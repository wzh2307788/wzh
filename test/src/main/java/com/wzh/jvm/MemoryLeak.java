package com.wzh.jvm;

import java.util.ArrayList;
// -Xmx4M -XX:+PrintGC -XX:+PrintGCDetails
public class MemoryLeak {
    public static void main(String[] args) {
        ArrayList<String[]>stringList=new ArrayList();
        while (true) {
            String[] s=new String[8092];
            stringList.add(s);
        }
    }
}
