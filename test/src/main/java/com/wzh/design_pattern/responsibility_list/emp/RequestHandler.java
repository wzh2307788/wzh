package com.wzh.design_pattern.responsibility_list.emp;

import com.wzh.design_pattern.responsibility_list.req.Request;

public abstract class RequestHandler {

    private RequestHandler next;
    public abstract void handle(Request req) ;

    public RequestHandler getNext() {
        return next;
    }

    public void setNext(RequestHandler next) {
        this.next = next;
    }
}
