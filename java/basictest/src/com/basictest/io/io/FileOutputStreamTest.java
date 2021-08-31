package com.basictest.io.io;

import java.io.*;

/**
 * Created in 2021/4/8 19:52
 *
 * @author: huxingxin
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        String inFilePath = "F:\\代码\\workspace\\java\\basictest\\src\\com\\basictest\\io\\io\\FileOutputStreamTest.java";
        String outFilePath = "E:\\tmp\\java.txt";
        try {
            fis = new FileInputStream(inFilePath);
            fos = new FileOutputStream(outFilePath,true);
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            while((hasRead=fis.read(buffer))!=-1){
                fos.write(buffer,0,hasRead);
            }
            System.out.println("文件成功写入:"+outFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis!=null){
                    fis.close();
                }
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
