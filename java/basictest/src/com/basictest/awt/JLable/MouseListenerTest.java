package com.basictest.awt.JLable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-19 00:37
 **/
public class MouseListenerTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(800,600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        JLabel jLabel = new JLabel();
        String imgPath = "E:\\tmp\\image\\motou.gif";
        ImageIcon imageIcon = new ImageIcon(imgPath);
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(375,275,imageIcon.getIconWidth(),imageIcon.getIconHeight());

        jFrame.add(jLabel);

        jLabel.addMouseListener(new MouseListener() {
            //点击鼠标
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("点击鼠标");
            }
            //按下鼠标
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("按下鼠标");
            }
            //释放鼠标
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("释放鼠标");
            }
            //鼠标进入
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("鼠标进入");

                Random random = new Random();
                int x = random.nextInt(jFrame.getWidth()-jLabel.getWidth());
                int y = random.nextInt(jFrame.getHeight()-jLabel.getHeight());
                jLabel.setLocation(x,y);
            }
            //鼠标退出
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("鼠标退出");
            }
        });

        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
