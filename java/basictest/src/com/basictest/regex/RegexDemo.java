package com.basictest.regex;

/**
 * Created in 2021/3/17 21:09
 *
 * @author: huxingxin
 */
public class RegexDemo {


    public static void main(String[] args) {
        String str = "Hello , Java !";
        System.out.println(str.replaceFirst("\\w","▇"));
        System.out.println(str.replaceFirst("\\w?","▇"));
        System.out.println(str.replaceFirst("\\w*","▇"));
        System.out.println(str.replaceFirst("\\w??","▇"));
        System.out.println(str.replaceFirst("\\w*?","▇"));
    }
}
