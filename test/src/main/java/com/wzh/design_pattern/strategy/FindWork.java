package com.wzh.design_pattern.strategy;

//策略模式：
public class FindWork {
    public static void main(String[] args) {

        GoodCompany goodCompany=new GoodCompany();
        GoodPrepared goodPrepared=new GoodPrepared(goodCompany);
        goodPrepared.job();
    }
}
