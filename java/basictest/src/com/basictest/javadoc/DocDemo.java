package com.basictest.javadoc;

/**
 * <p>Created in 2021/3/7 4:03</p>
 *<p>这里是DocDemo的注释</p>
 * @author huxingxin
 * @version  1.0
 *
 */
public class DocDemo {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
