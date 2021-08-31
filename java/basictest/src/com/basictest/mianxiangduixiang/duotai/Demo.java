package com.basictest.mianxiangduixiang.duotai;

/**
 * Created in 2021/3/6 21:47
 *
 * @description:
 * @Author: huxingxin
 */
public class Demo {
    public static void main(String[] args) {
        BaseClass baseClass = new BaseClass();

        SubClass subClass = new SubClass();
//        subClass.getId();

        BaseClass fatherClass = new SubClass();
//        fatherClass.getId();//引用变量只能调用它编译时类型的方法，而不能调用它运行时类型的方法
        SubClass sonCLass1 = (SubClass) fatherClass;
        sonCLass1.getId();

//        SubClass sonClass = (SubClass) new BaseClass();
//        sonClass.getId();

        boolean is1 = baseClass instanceof SubClass;
        boolean is2 = subClass instanceof SubClass;
        boolean is3 = fatherClass instanceof SubClass;
        boolean is4 = subClass instanceof BaseClass;
        System.out.println(is1);
        System.out.println(is2);
        System.out.println(is3);
        System.out.println(is4);


    }
}
