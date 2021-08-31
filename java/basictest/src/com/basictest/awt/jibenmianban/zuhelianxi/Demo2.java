package com.basictest.awt.jibenmianban.zuhelianxi;

import javax.swing.*;
import java.awt.*;

/**
 * @author huxingxin
 * @ClassName Demo2.java
 * @Description
 * @createTime 2021年07月19日 15:18:00
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(100,100,400,400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new FlowLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //进度条
        JProgressBar jProgressBar = new JProgressBar();
        jProgressBar.setPreferredSize(new Dimension(300,30));
        jProgressBar.setMaximum(100);
        jProgressBar.setStringPainted(true);

        jFrame.add(jProgressBar);

        jFrame.setVisible(true);

        int i = 1;
        //进度每增加%1 每次增加多休眠15毫秒
        while (jProgressBar.getValue()!=100){
            i+=15;
            Thread.sleep(100+ i);
            System.out.println(100 + i);
            jProgressBar.setValue(jProgressBar.getValue()+1);
        }
    }
}
