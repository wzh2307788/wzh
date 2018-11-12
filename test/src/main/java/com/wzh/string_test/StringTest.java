package com.wzh.string_test;

public class StringTest {
    public static void main(String[] args) throws InterruptedException {
            String s1 = new String("hello");  //此时 hello已经放入了常量池
            String intern1 = s1.intern();
            String s2 = "hello";
            System.out.println(s1 == s2);      //false
            String s3 = new String("hello") + new String("hello");
            String intern3 = s3.intern();
            String s4 = "hellohello";
            System.out.println(s3 == s4);

            Thread.sleep(90000000);
    }
}

