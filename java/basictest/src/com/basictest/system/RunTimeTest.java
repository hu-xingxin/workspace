package com.basictest.system;

/**
 * Created in 2021/2/23 10:26
 *
 * @description:
 * @Author: huxingxin
 */
public class RunTimeTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("处理器数量："+ runtime.availableProcessors());
        System.out.println("空闲内存数："+ runtime.freeMemory()/1024d/1024d);
        System.out.println("总内存数："+ runtime.totalMemory()/1024d/1024d);
        System.out.println("可用最大内存数："+ runtime.maxMemory()/1024d/1024d);
    }
}
