package com.wzh.referencetransfer;

public class IntegerReference {
    public static void main(String[] args) {
        Integer a=1;  //通过Integer.valueof将原始类型转成引用类型
        Integer b=2;
        System.out.println("a="+a+";b="+b);

        changeContent(a);
        System.out.println("a="+a+";b="+b);
        a=8; //     a的地址已经被改变了
        System.out.println("a="+a+";b="+b);
    }

    public static void changeContent(Integer a ){
       a=4;
    }
}
