package com.wzh.serialize;

import java.io.*;

public class SerializeUtil<T> {
    /**
     * 什么是序列化？
     * 自己的理解：获取对象相关的信息： 类，属性，类型，取值 ，将这些信息进行结构化组织并文本化到存储介质中。
     *  官方定义：序列化 (Serialization)将对象的状态信息转换为可以存储或传输的形式的过程。
     *
     * @return
     */
    private static String FILE_NAME;
    private static Class handleClass;

    public static Class getHandleClass() {
        return handleClass;
    }

    public static void setHandleClass(Class handleClass) {
        SerializeUtil.handleClass = handleClass;
    }

    public String getFileName() {
        return FILE_NAME;
    }

    public static void setFileName(String fileName) {
        FILE_NAME = fileName;
    }

    public static void serialize(Object o)  {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void init(Class classType) {
        setFileName("./test/src/main/java/com/wzh/serialize/"
                + classType.getSimpleName() + ".txt");
    }
    public  T get(){
        T t=null;
        return  t;
    }

    public static <T> T unSerialize(Class<T> t  ) {

        T result = null;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            result = (T) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in == null) return result;
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
