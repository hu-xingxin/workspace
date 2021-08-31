package com.basictest.io.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created in 2021/4/9 15:14
 *
 * @author: huxingxin
 */
public class ReadObject {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("E:\\tmp\\object.txt"));
//            User user = (User) ois.readObject();
//            System.out.println(user);
            Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
