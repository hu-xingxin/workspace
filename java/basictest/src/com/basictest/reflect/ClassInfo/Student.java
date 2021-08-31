package com.basictest.reflect.ClassInfo;

/**
 * @description
 * @author: hxx
 * @create: 2021-05-14 17:19
 **/
public class Student {
    private Integer id;
    private String name;
    private String age;
    private String sex;

    public Student() {
    }

    private Student(Integer id){

    }

    public Student(Integer id, String name, String age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void print(){
        System.out.println("这是一个学生");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void study(){
        System.out.println(this.name +"正在学习");
    }

    public void sing(){
        System.out.println(this.name + "正在唱歌");
    }

    public void sing(String songName){
        System.out.println(this.name + "正在唱:" + songName);
    }
}
