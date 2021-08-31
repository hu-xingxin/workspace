package com.basictest.awt.JLable;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-19 13:53
 **/
public class KeyListenerTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400,300);
        jFrame.setLocation(580,200);
        jFrame.setLayout(null);

        JLabel jLabel = new JLabel();
        String imgPath = "E:\\tmp\\image\\motou.gif";
        ImageIcon imageIcon = new ImageIcon(imgPath);
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(50,50,imageIcon.getIconWidth(),imageIcon.getIconHeight());

        jFrame.addKeyListener(new KeyListener() {

            //键被按下并弹起
            @Override
            public void keyTyped(KeyEvent e) {

            }

            //键被按下
            @Override
            public void keyPressed(KeyEvent e) {
                //左
                if(e.getKeyCode()==37){
                    jLabel.setLocation(jLabel.getX()-10,jLabel.getY());
                }
                //上
                if(e.getKeyCode()==38){
                    jLabel.setLocation(jLabel.getX(),jLabel.getY()-10);
                }
                //右
                if(e.getKeyCode()==39){
                    jLabel.setLocation(jLabel.getX()+10,jLabel.getY());
                }
                //下
                if(e.getKeyCode()==40){
                    jLabel.setLocation(jLabel.getX(),jLabel.getY()+10);
                }
            }

            //键被弹起
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        jFrame.add(jLabel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
