package com.wzh.referencetransfer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class RefrenceTransfer {
    public static void main(String[] args) {
        ArrayList<String> lista=new ArrayList<String>(4);
        ArrayList<String> listb=new ArrayList<String>(4);
        ArrayList<String> listc=new ArrayList<String>(4);
        lista.add("a");
        listb.add("b");
        listc.add("c");


        printList(lista);
        printList(listb);

        swap(lista,listb);

        System.out.println("after swap lista ,listb");
        printList(lista);
        printList(listb);

        System.out.println("change the reference's internal value");

    }

    public static void swap(List a,List b){
        List list=a;
        a=b;
        b=list;

        changeContent(a);
        changeContent(b);
    }
    public static void printList(final List list){
        list.stream().forEach(new Consumer<String>() {
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    public static void changeContent(final List<String> list){
        ArrayList<String> listStr=new ArrayList<String>();
        listStr.add("a");
        listStr.add("b");

        listStr.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                appendValue(list,s);
            }
        });


    }

    private static void appendValue(List<String> list,final String value) {
        boolean isContainA=list.stream().anyMatch(new Predicate<String>() {
            @Override
            public boolean test(String o) {

                return o.contains(value);
            }
        });
        if(isContainA){
            list.add(value+value);
        }
    }
}
