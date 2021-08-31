package com.basictest.expection.demo2;

/**
 * Created in 2021/3/25 10:27
 *
 * @author: huxingxin
 */
public class ThrowDemo {
    public static void main(String[] args){
        try {
            testException();
        } catch (MyException e) {
            System.out.println("testException");
        }
    }

    public static void testException() throws MyException {
        if (true){
            throw new MyException("myException");
        }
    }
}
