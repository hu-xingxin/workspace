package com.basictest.fanxing.tongpeifu;

import java.util.List;

/**
 * Created in 2021/3/11 21:26
 *
 * @author: huxingxin
 */
public class Canvas {
    public void drawAll(List<? extends Shape> shapes){
        for (Shape shape:shapes) {
            shape.draw(this);
        }
    }
}
