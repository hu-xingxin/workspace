package com.basictest.awt.container;

import javax.swing.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-20 06:33
 **/
public class JFrameTest {
    public static void main(String[] args) {
        //JFrame是GUI中的容器
        JFrame jFrame = new JFrame("lol");
        //设置宽高
//        jFrame.setLocation(200,200);
        //设置位置
//        jFrame.setSize(400,300);
        //设置位置 和宽高
        jFrame.setBounds(200,200,400,300);

        // 主窗体中的组件设置为绝对定位
        jFrame.setLayout(null);

        // 按钮组件
        JButton jButton = new JButton("一键秒对方基地挂");

        //同时设置组件的大小和位置
        jButton.setBounds(50,50,280,30);

        //把按钮加入到主窗体中
        jFrame.add(jButton);
        //关闭窗体的时候，退出程序
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 让窗体变得可见
        jFrame.setVisible(true);
    }
}
