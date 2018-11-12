package com.wzh.design_pattern.responsibility_list.emp;

import com.wzh.design_pattern.responsibility_list.req.FeeRequest;
import com.wzh.design_pattern.responsibility_list.req.Request;

import java.util.List;

public abstract class RequestHandler {

    private RequestHandler next;

    public abstract boolean handle(Request req);
    protected double maxFee;
    protected List employees;
    public boolean handle(FeeRequest req){

        if(req.getFee()<maxFee){
            return true;
        }
        if(employees.indexOf(req.getEmployee())>0){
            return true;
        }
        return false;
    }
    public boolean hadNext() {
        return getNext() != null;
    }



    public RequestHandler getNext() {
        return next;
    }

    public void setNext(RequestHandler next) {
        this.next = next;
    }
}
