package com.basictest.expection.demo2;

/**
 * Created in 2021/3/25 10:36
 *
 * @author: huxingxin
 */
public class SalException extends Exception{
    public SalException(){}

    public SalException(String message){
        super(message);
    }

    public SalException(Throwable throwable){
        super(throwable);
    }
}
