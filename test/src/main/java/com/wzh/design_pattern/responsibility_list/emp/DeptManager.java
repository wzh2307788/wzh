package com.wzh.design_pattern.responsibility_list.emp;

import com.wzh.design_pattern.responsibility_list.req.EntryRequest;
import com.wzh.design_pattern.responsibility_list.req.FeeRequest;
import com.wzh.design_pattern.responsibility_list.req.Request;
import com.wzh.design_pattern.responsibility_list.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class DeptManager  extends RequestHandler{
    boolean isContinue=true;
    Logger log = LoggerFactory.getLogger(DeptManager.class);

    @Override
    public boolean handle(Request req) {

        System.out.println(" get into the " + this.getClass().getName() + Thread.currentThread().getStackTrace()[1].getMethodName()+Thread.currentThread().getStackTrace()[1].getLineNumber());
        if (req instanceof FeeRequest) {
            return  handle((FeeRequest) req);
        } else if (req instanceof EntryRequest) {
            return   handle((EntryRequest) req);
        }

        return false;
    }

    public boolean handle(FeeRequest request) {
        System.out.println(" get into the " + this.getClass().getName() + Thread.currentThread().getStackTrace()[1].getMethodName()+Thread.currentThread().getStackTrace()[1].getLineNumber());

        return false;
    }

    public boolean handle(EntryRequest request) {
        System.out.println(" get into the " + this.getClass().getName() + Thread.currentThread().getStackTrace()[1].getMethodName()+Thread.currentThread().getStackTrace()[1].getLineNumber());
        return false;
    }
}
