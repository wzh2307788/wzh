package com.wzh.serialize;

import java.io.Serializable;

public class Father implements Serializable{
    {
        System.out.println("Father instance block");
    }
    public final String name="wcb2";
    public String sex="man";

    public String getName() {
    return name;
}

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Father( ) {
        System.out.println("Father constructor");
    }
}
