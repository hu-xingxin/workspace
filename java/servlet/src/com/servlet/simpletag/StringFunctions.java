package com.servlet.simpletag;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-26 10:49
 **/
public class StringFunctions {
    public static String reverseString(String str){
       return new StringBuffer(str).reverse().toString();
    }
}
