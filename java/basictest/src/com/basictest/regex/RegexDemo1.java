package com.basictest.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created in 2021/3/17 21:21
 *
 * @author: huxingxin
 */
public class RegexDemo1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w");
        Matcher matcher = pattern.matcher("H");
        boolean isMatches = matcher.matches();
        System.out.println(isMatches);
        System.out.println("\1");
    }
}
