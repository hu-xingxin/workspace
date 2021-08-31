package com.basictest.expection.demo2;

/**
 * Created in 2021/3/25 10:32
 *
 * @author: huxingxin
 */
public class MyException extends Exception{
    public MyException(){

    }

    public MyException(String message){
        super(message);
    }
}
