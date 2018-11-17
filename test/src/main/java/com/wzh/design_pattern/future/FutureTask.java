package com.wzh.design_pattern.future;

import java.util.concurrent.Callable;

public class FutureTask implements Callable<Boolean> {
    int secondMills;

    FutureTask(int secondMills) {
        this.secondMills = secondMills;
    }

    @Override
    public Boolean call() throws Exception {
       Thread.sleep(8000);
       for (int i=0;i<secondMills;i++){
           System.out.println("running the task of "+secondMills+" order"+i);

        }
        System.out.println("running the task of "+secondMills);
        //  Thread.sleep(secondMills);
        System.out.println("return result: true");
        return true;
    }
}
