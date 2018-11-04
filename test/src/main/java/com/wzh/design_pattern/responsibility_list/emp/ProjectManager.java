package com.wzh.design_pattern.responsibility_list.emp;

import com.wzh.design_pattern.responsibility_list.req.EntryRequest;
import com.wzh.design_pattern.responsibility_list.req.FeeRequest;
import com.wzh.design_pattern.responsibility_list.req.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProjectManager extends RequestHandler{
    boolean isContinue=true;
    Logger log = LoggerFactory.getLogger(DeptManager.class);
    {
       setNext(new DeptManager());
    }
    @Override
    public void handle(Request req) {

        System.out.println(" get into the " + this.getClass().getName() + Thread.currentThread().getStackTrace()[1].getMethodName()+Thread.currentThread().getStackTrace()[1].getLineNumber());
        if (req instanceof FeeRequest) {
            handle((FeeRequest) req);
        } else if (req instanceof EntryRequest) {
            handle((EntryRequest) req);
        }
    }

    public void handle(FeeRequest request) {
        System.out.println(" get into the " + this.getClass().getName() + Thread.currentThread().getStackTrace()[1].getMethodName()+Thread.currentThread().getStackTrace()[1].getLineNumber());
        boolean isContinue=true;
        if(getNext()!=null&&isContinue){
            getNext().handle(request);
        }
    }

    public void handle(EntryRequest request) {
        System.out.println(" get into the " + this.getClass().getName() + Thread.currentThread().getStackTrace()[1].getMethodName()+Thread.currentThread().getStackTrace()[1].getLineNumber());
    }
}
