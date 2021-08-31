package com.basictest.innerclass.lamdba.strem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huxingxin
 * @ClassName Demo.java
 * @Description
 * @createTime 2021年07月15日 09:54:00
 */
public class StreamDemo {
    public static void main(String[] args) {
        //创建一个集合，存储多个字符串元素
        ArrayList<String> list = new ArrayList<String>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");

        /**
         * filter 代码演示
         */
        //筛选出 集合里面以张开头的 并且把结果收集在集合中
//        List<String> listZhang = list.stream().filter(str -> str.startsWith("张")).collect(Collectors.toList());

        //筛选出 集合里面以张开头的元素 然后遍历输出在控制台
//        list.stream().filter(str -> str.startsWith("张")).forEach(System.out::println);

        //筛选出 集合里面长度为3的元素 然后遍历输出在控制台
//        list.stream().filter(str -> str.length()==3).forEach(System.out::println);

        //筛选出 集合里面以张开头的 长度为3的元素  然后遍历输出在控制台
        list.stream().filter(str -> str.startsWith("张")).filter(str -> str.length()==3).forEach(System.out::println);


    }
}
