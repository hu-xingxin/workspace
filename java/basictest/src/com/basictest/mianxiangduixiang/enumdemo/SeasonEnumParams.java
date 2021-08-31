package com.basictest.mianxiangduixiang.enumdemo;

/**
 * Created in 2021/2/13 19:52
 *
 * @description:
 * @Author: huxingxin
 */
public enum SeasonEnumParams {
    SPRING("春暖花开"),SUMMER("夏日炎炎"),FALL("秋高气爽"),WINTER("冬日飘雪");

    private String season;

    private SeasonEnumParams(String season){
        this.season = season;
    }

    public String getSeason(){
        return season;
    }
}
