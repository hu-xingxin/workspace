package com.basictest.innerclass.lamdba.hanshushi;

import java.util.function.Function;

/**
 * @author huxingxin
 * @ClassName FunctionDemo.java
 * @Description 函数式接口 Function<T,T> 函数型接口
 * @createTime 2021年07月15日 09:08:00
 */
public class FunctionDemo {
    public static void main(String[] args) {
        convert("张曼玉,35",str->Integer.valueOf(str.split(",")[1]));
        convert1("张曼玉,35",str->str.split(",")[1]);
        convert2(35,i->String.valueOf(i));
        convert3("张曼玉,35",str->Integer.valueOf(str.split(",")[1]),i->i+10);

    }

    /**
     * 把字符串转换成数字
     * @param str
     * @param function
     */
    public static void convert(String str, Function<String,Integer> function){
        Integer i = function.apply(str);
        System.out.println(i);
    }

    /**
     * 字符串操作 字符串输出
     * @param str
     * @param function
     */
    public static void convert1(String str, Function<String,String> function){
        String age = function.apply(str);
        System.out.println(age);
    }

    /**
     * 数字转字符串
     * @param i
     * @param function
     */
    public static void convert2(Integer i, Function<Integer,String> function){
        function.apply(i);
        System.out.println(i);
    }

    /**
     * 把字符串转换成数字进行操作 然后输出
     * @param str
     * @param function1
     * @param function2
     */
    public static void convert3(String str, Function<String,Integer> function1, Function<Integer,Integer> function2){
//        Integer i = function1.apply(str);
//        Integer j = function2.apply(i);

        Integer i = function1.andThen(function2).apply(str);
        System.out.println(i);
    }
}
