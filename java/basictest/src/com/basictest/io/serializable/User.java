package com.basictest.io.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created in 2021/4/9 15:09
 *
 * @author: huxingxin
 */
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeInt(id);
        oos.writeObject(new StringBuffer(name).reverse());
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        this.id = ois.readInt();
        this.name = ((StringBuffer)ois.readObject()).reverse().toString();
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
