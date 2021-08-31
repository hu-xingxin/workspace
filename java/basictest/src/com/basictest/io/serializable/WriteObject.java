package com.basictest.io.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created in 2021/4/9 15:10
 *
 * @author: huxingxin
 */
public class WriteObject {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("E:\\tmp\\object.txt"));
//            User user = new User();
//            user.setId(11);
//            user.setName("胡兴新");
//            oos.writeObject(user);

            Person person = new Person();
            person.setId(11);
            person.setName("哈哈哈");
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
