package com.basictest.system;

import java.util.Map;

/**
 * Created in 2021/2/23 10:23
 *
 * @description:
 * @Author: huxingxin
 */
public class SystemParams {
    public static void main(String[] args) {
        Map<String, String> getenv = System.getenv();
        for(String name : getenv.keySet()){
            System.out.println(name + " ------> " + getenv.get(name));
        }

    }
}
