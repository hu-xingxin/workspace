package com.basictest.mianxiangduixiang.jicheng;

/**
 * Created in 2021/2/1 19:26
 *
 * @description:
 * @Author: huxingxin
 */
public class People{
    private int age;
    private String name;
    private String employee;

    public People() {

    }

    public People(int age){
        this.age = age;
    }

    public People(int age,String name){
        this(age);
        this.name = name;
    }

    public People(int age,String name,String employee){
        this(age,name);
        this.employee = employee;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }



    public void speak(){
        System.out.println("我是一个People");
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", employee='" + employee + '\'' +
                '}';
    }
}
