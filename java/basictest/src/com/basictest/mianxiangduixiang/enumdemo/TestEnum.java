package com.basictest.mianxiangduixiang.enumdemo;

/**
 * Created in 2021/2/13 19:43
 *
 * @description:
 * @Author: huxingxin
 */
public class TestEnum {
    public void judge(SeasonEnum seasonEnum){
        switch (seasonEnum){
            case SPRING:
                System.out.println("春暖花开");
                break;
            case SUMMER:
                System.out.println("夏日炎炎");
                break;
            case FALL:
                System.out.println("秋高气爽");
                break;
            case WINTER:
                System.out.println("冬日飘雪");
                break;
        }
    }

    public static void main(String[] args) {
        for (SeasonEnum seasonEnum: SeasonEnum.values()) {
            System.out.println(seasonEnum);
            new TestEnum().judge(seasonEnum);
        }
    }
}
