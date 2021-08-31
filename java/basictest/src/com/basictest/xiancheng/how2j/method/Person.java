package com.basictest.xiancheng.how2j.method;

/**
 * @author huxingxin
 * @ClassName Person.java
 * @Description
 * @createTime 2021年07月22日 14:59:00
 */
public class Person {
    private int id;
    private int age;

    public Person() {
    }

    public Person(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addAge(){
        this.age = age+1;
        System.out.println(Thread.currentThread().getName() + "--" + age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
