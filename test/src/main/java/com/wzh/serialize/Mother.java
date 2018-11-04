package com.wzh.serialize;

import java.io.Serializable;

public class Mother implements Serializable{
    private final String name;
    private String sex;

    {
        System.out.println("mother instance block");
    }
    public Mother() {
        System.out.println("mother init");
        this.name = "ccs2";
        this.sex = "female";
    }

/*    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }*/
}
