package com.basictest.xiancheng.checkfile;

import java.io.*;
import java.lang.reflect.Field;

/**
 * @author huxingxin
 * @ClassName CheckFileThread.java
 * @Description
 * @createTime 2021年07月21日 12:03:00
 */
public class CopyFileThread implements Runnable{
    private File srcFile;
    private File copyToFile;

    public CopyFileThread(File srcFile, File copyToFile){
        this.srcFile = srcFile;
        this.copyToFile = copyToFile;
    }

    @Override
    public void run() {
        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(copyToFile)) {

            byte[] buffer = new  byte[1024*1024];
            int index;
            while ((index = fis.read(buffer)) != -1){
                fos.write(buffer,0,index);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
