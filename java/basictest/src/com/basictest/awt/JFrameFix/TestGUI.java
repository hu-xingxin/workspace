package com.basictest.awt.JFrameFix;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created in 2021/2/23 16:41
 *
 * @description:
 * @Author: huxingxin
 */
public class TestGUI {
    public static void main(String[] args) throws IOException {
        //JFrame是GUI中的容器
        JFrame jFrame = new JFrame("LOL");
        //设置容器的宽度和高度
        jFrame.setSize(400,300);

        //从文件中读取上次容器所在的位置
        Properties properties = new Properties();
        String path = "F:\\代码\\workspace\\java\\basictest\\src\\resource\\JFrame\\point.txt";
        properties.load(new FileInputStream(path));
        String xPoint = properties.getProperty("xPoint");
        String yPoint = properties.getProperty("yPoint");
        //容器默认位置为 300 300
        if(xPoint==null || yPoint == null){
            jFrame.setLocation(300,300);
        }else {
            jFrame.setLocation(Integer.parseInt(xPoint),Integer.parseInt(yPoint));
        }

        jFrame.setLayout(null);

        JButton jButton = new JButton("一键秒对方水晶挂");
        jButton.setBounds(50,50,280,30);
        jFrame.add(jButton);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        //开启一个新线程 实时记录容器所在的位置 存储到文件中
        new PointGetThread(jFrame).start();
    }
}
