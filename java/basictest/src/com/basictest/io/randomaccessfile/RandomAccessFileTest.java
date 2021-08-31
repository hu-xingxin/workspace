package com.basictest.io.randomaccessfile;

import java.io.*;
import java.util.RandomAccess;

/**
 * Created in 2021/4/9 14:19
 *
 * @author: huxingxin
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        randomRead();
//        appendContent();
//        randomWriter();
    }


    public static void randomRead(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("E:\\tmp\\java.txt","r");
//            raf.seek(300);
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            while((hasRead= raf.read(buffer))>0){
                System.out.println(new String(buffer,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (raf!=null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void appendContent(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("E:\\tmp\\java.txt","rw");
            raf.seek(raf.length());
            String str = "柔情似水，佳期如梦，忍顾鹊桥归路！两情若是久长时，又岂在朝朝暮暮。";
            raf.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (raf!=null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void randomWriter(){
        RandomAccessFile raf = null;
        try {
            File tmp = File.createTempFile("tmp", null);
            FileOutputStream fos = null;
            FileInputStream fis = null;
            tmp.deleteOnExit();

            raf = new RandomAccessFile("E:\\tmp\\java.txt","rw");
            fos = new FileOutputStream(tmp);
            fis = new FileInputStream(tmp);

            raf.seek(100);

            byte[] buffer = new byte[1024];
            int hasRead = 0;

            while((hasRead=raf.read(buffer))>0){
                fos.write(buffer,0,hasRead);
            }

            raf.seek(100);

            String str = "纤云弄巧，飞星传恨，银汉迢迢暗度。金风玉露一相逢，便胜却人间无数。";
            raf.write(str.getBytes());

            while((hasRead= fis.read(buffer))>0){
                raf.write(buffer,0,hasRead);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (raf!=null){
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
