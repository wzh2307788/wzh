package com.wzh.design_pattern.singleson;

public class Medicine {
    static  Medicine instance;
    private Medicine(){}

    public static Medicine getInstance(){

        if(instance==null){
            synchronized (Medicine.class){
                if(instance==null){
                    instance=new Medicine();
                }

            }
        }
        return instance;
    }

}
