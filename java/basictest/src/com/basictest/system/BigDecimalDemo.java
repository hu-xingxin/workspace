package com.basictest.system;

import java.math.BigDecimal;

/**
 * Created in 2021/3/14 20:49
 *
 * @author: huxingxin
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.05");
        BigDecimal b = new BigDecimal("0.01");
        System.out.println(a.add(b));
        System.out.println(0.05 + 0.01);
    }
}
