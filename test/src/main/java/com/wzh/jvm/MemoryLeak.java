package com.wzh.jvm;

import java.util.ArrayList;

public class MemoryLeak {
    public static void main(String[] args) {
        ArrayList<String[]>stringList=new ArrayList();
        while (true) {
            String[] s=new String[8092];
            stringList.add(s);
        }
    }
}
