package com.basictest.io.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Created in 2021/4/8 15:29
 *
 * @author: huxingxin
 */
public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("F:\\code\\workspace\\java\\basictest\\src\\com\\basictest\\io\\io\\FileOutputStreamTest.java");
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            while((hasRead=fis.read(buffer))!=-1){
                System.out.println(new String(buffer,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
