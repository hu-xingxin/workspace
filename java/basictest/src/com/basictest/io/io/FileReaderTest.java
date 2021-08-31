package com.basictest.io.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created in 2021/4/8 17:09
 *
 * @author: huxingxin
 */
public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            String filePath = "F:\\workspace\\basictest\\src\\com\\basictest\\io\\io\\FileInputStreamTest.java";
            fileReader = new FileReader(filePath);
            char[] buffer = new char[32];
            int hasRead = 0;
            while((hasRead=fileReader.read(buffer))!=-1){
                System.out.println(new String(buffer,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
