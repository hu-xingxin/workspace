package com.basictest.fanxing.tongpeifu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created in 2021/3/11 21:31
 *
 * @author: huxingxin
 */
public class Demo {
    public static void main(String[] args) {
         List<Circle> list = new ArrayList<>();
         list.add(new Circle());
         Canvas canvas = new Canvas();
         canvas.drawAll(list);
    }
}
