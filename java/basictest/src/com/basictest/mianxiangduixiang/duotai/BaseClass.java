package com.basictest.mianxiangduixiang.duotai;

/*** 这个类绘制一个条形图
 * @author runoob
 * @version 1.2
 */
public class BaseClass {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*** 这个类绘制一个条形图
     * @author runoob
     * @version 1.2
     */
    public void speak(){
        System.out.println("我是父类");
    }
}
