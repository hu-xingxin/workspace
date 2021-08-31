package com.tools.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年07月30日 17:08:28
 * @Description
 */
public class JunitTest2 {
    @Test
    public void test(){
        System.out.println("junit测试...");
        int a = 1+2;
        Assert.assertEquals(a, 1);
    }

    @Test
    public void test1(){
        System.out.println("junit测试1...");
    }

    @Test
    public void test2(){
        System.out.println("junit测试2...");
    }

    @Test
    public void test3(){
        System.out.println("junit测试3...");
    }

    @Before
    public void before(){
        System.out.println("junit测试before...");
    }
    @After
    public void after(){
        System.out.println("junit测试after...");
    }
}
