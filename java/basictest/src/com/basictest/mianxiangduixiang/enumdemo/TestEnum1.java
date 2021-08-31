package com.basictest.mianxiangduixiang.enumdemo;

/**
 * Created in 2021/3/7 23:51
 *
 * @author: huxingxin
 */
public class TestEnum1 {
    public static void main(String[] args) {
        SeasonEnumParams spring = Enum.valueOf(SeasonEnumParams.class, "SPRING");
        System.out.println(spring.getSeason());
    }
}
