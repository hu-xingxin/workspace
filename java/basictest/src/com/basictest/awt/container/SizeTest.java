package com.basictest.awt.container;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-20 06:52
 **/
public class SizeTest {
    public static boolean flag = true;//窗口锁定状态

    public static void main(String[] args) {
        JFrame f = new JFrame("lol");
        f.setBounds(400,400,400,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDialog d = new JDialog(f);
        d.setTitle("模态窗口");
        d.setBounds(500,550,200,200);
        d.setLayout(null);
        d.setModal(true);
        //默认锁定住窗口大小
        d.setResizable(false);

        //打开一个模态窗口
        JButton fb = new JButton("打开一个模态窗口");
        fb.setBounds(50,50,280,30);
        fb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                d.setVisible(true);
            }
        });

        //控制窗口的大小是否被锁定住
        JButton db = new JButton("解锁大小");
        db.setBounds(25,50,150,30);
        db.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(flag){
                    d.setResizable(true);
                    db.setText("解锁锁定");
                    flag = false;
                    System.out.println("解锁");
                }else {
                    d.setResizable(false);
                    db.setText("锁定大小");
                    flag=true;
                    System.out.println("锁定");
                }

            }
        });

        f.add(fb);
        d.add(db);

        f.setVisible(true);

    }
}
