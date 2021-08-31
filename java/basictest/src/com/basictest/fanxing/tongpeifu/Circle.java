package com.basictest.fanxing.tongpeifu;

/**
 * Created in 2021/3/11 21:26
 *
 * @author: huxingxin
 */
public class Circle extends Shape{
    @Override
    public void draw(Canvas canvas) {
        System.out.println("在画布"+canvas+"画一个圆");
    }
}
