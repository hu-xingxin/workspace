package com.basictest.reflect.systemloader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-14 15:41
 **/
public class BootStrapTest {
    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for ( URL urL:urLs) {
            System.out.println(urL.toExternalForm());
        }
    }
}
