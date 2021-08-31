package com.basictest.io.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created in 2021/4/8 20:09
 *
 * @author: huxingxin
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        String inFilePath = "F:\\workspace\\basictest\\src\\com\\basictest\\io\\io\\FileInputStreamTest.java";
        String outFilePath = "E:\\tmp\\java.txt";
        PrintStream ps = null;
        try {
            FileInputStream fis = new FileInputStream(inFilePath);
            FileOutputStream fos = new FileOutputStream(outFilePath);
            ps = new PrintStream(fos);
            ps.println("PrintStreamTest");
            ps.println(new PrintStreamTest());
            ps.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                ps.close();
            }
        }
    }
}
