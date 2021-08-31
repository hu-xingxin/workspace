package com.basictest.io.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created in 2021/4/8 20:02
 *
 * @author: huxingxin
 */
public class FileWriterTest {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        String inFilePath = "F:\\workspace\\basictest\\src\\com\\basictest\\io\\io\\FileInputStreamTest.java";
        String outFilePath = "E:\\tmp\\java.txt";
        try {
            fr = new FileReader(inFilePath);
            fw = new FileWriter(outFilePath);
            char[] buffer = new char[32];
            int hasRead = 0;
            while((hasRead=fr.read(buffer))!=-1){
                fw.write(buffer,0,hasRead);
            }
            System.out.println("文件成功写入:"+outFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr!=null){
                    fr.close();
                }
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
