
package com.basictest.mianxiangduixiang.chushihuakuai;

/**
 * Created in 2021/3/6 22:38
 *
 * @description:
 * @Author: huxingxin
 */
public class StaticClass {
    private String name;
    {
        name = "name";
        System.out.println("第一个初始化快");
    }

    {
        System.out.println("第二个初始化块");
    }

    public StaticClass(){
        System.out.println("这里是无参构造器");
    }

    public static void main(String[] args) {
//        StaticClass staticClass = new StaticClass();
//        System.out.println(staticClass.name);
//        StaticClassDemo.out();
        System.out.println(StaticClassDemo.name);
    }
}

/**
 * Created in 2021/3/6 22:38
 *
 * @description:
 * @Author: huxingxin
 */
class StaticClassDemo{
    public static String name = null;

    static {
        name="hxx";
        System.out.println("这里是静态初始化代码快");
    }

    {
        System.out.println("这里是普通始化代码快");
    }

    public static void out(){
        System.out.println("hello java");
    }
}
