package com.basictest.awt.JFrameFix;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-19 00:13
 **/
public class PointGetThread extends Thread{
    private JFrame jFrame;

    public PointGetThread(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void run() {
       while (true){
           int xPoint = jFrame.getX();
           int yPoint = jFrame.getY();
           Properties properties = new Properties();
           properties.setProperty("xPoint",xPoint+"");
           properties.setProperty("yPoint",yPoint+"");

           String path = "F:\\代码\\workspace\\java\\basictest\\src\\resource\\JFrame\\point.txt";
           try {
               properties.store(new FileOutputStream(path),"comment line");
               System.out.println(xPoint + "--" + yPoint);
               //此处需要让线程休眠一会 不然可能会导致数据写入失败
               Thread.sleep(100);
           } catch (IOException | InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
