package com.wzh.design_pattern.responsibility_list.service;

public class BaseService {
    public void handleReq(){
        System.out.println(this.getClass().getName());
    }
}
