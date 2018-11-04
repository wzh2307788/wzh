package com.wzh.exception;

public class ReturnTest {
    public static void main(String[] args) {



        System.out.println("扩展目录"+System.getProperty("java.ext.dirs"));
        System.out.println( "the result of test is "+test());
    }
    public static int test(){
        try{
            int j=0/0;
            return j;
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("exception");
            return 5;

        }finally {
            System.out.println(" execute finally");
            return 10;
        }
    }
}
