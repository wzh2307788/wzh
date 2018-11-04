package com.wzh.serialize;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SerializeUtil.init(Father.class);

        SerializeUtil.serialize(new Father());
        System.out.println(( SerializeUtil.unSerialize(Father.class)).getName());


        SerializeUtil.init(Mother.class);
        SerializeUtil.serialize(new Mother());
        Mother m=SerializeUtil.unSerialize(Mother.class);
    //    System.out.println((SerializeUtil.unSerialize(Mother.class)).getName());


        /*对于final字段， 序列化后再反序列化【中间变更final字段取值】
        1、如果final字段是声明时初始化的，反序列化为为新值
        2、如果final字段是在构造函数里初始化，反序列后为旧值。
        反序列化，不会使用setXXX方法和构造函数。

         */
    }
}
