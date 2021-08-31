package com.basictest.innerclass.lamdba.hanshushi;

import java.util.function.Predicate;

/**
 * @author huxingxin
 * @ClassName PredicateDemo.java
 * @Description 函数式接口 Predicate<T> 断言型接口
 * @createTime 2021年07月14日 23:20:00
 */
public class PredicateDemo {
    public static void main(String[] args) {
        //判断字符串额长度是否为4
        boolean isLength1 = checkStr("java", str -> str.length() == 4);
        //判断字符串的长度是否为4 或者 长度是否小于1
        boolean isLength2 = checkStr("java",
                                    str -> str.length() == 4,
                                    str->str.length() < 1);
        
        System.out.println(isLength1);
        System.out.println(isLength2);
    }

    public static boolean checkStr(String str, Predicate<String> predicate){
        return predicate.negate().test(str);
    }
    public static boolean checkStr(String str, Predicate<String> predicate1, Predicate<String> predicate2){
        return predicate1.or(predicate2).test(str);
    }
}
