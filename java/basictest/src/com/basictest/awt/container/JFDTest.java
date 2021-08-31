package com.basictest.awt.container;

import javax.swing.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-20 06:44
 **/
public class JFDTest {
    public static void main(String[] args) {
        JFrame f = new JFrame("lol");
        f.setBounds(100,100,800,600);

        JDialog d = new JDialog();
        d.setTitle("lol");
        d.setBounds(400,300,400,200);
        // 设置为模态
        d.setModal(true);
        d.setLayout(null);

        // 窗体大小不可变化
        d.setResizable(false);

        JButton b = new JButton("一键爆基地");
        b.setBounds(50,50,280,30);

        d.add(b);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        d.setVisible(true);

    }
}
