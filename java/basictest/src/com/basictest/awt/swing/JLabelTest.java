package com.basictest.awt.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-20 20:45
 **/
public class JLabelTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("LOL");
        frame.setBounds(200,200,400,300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JLabel label = new JLabel("英雄联盟");
//        label.setForeground(Color.red);
//        label.setBounds(50,50,280,30);

        JLabel label = new JLabel();
        String imgPath = "E:\\tmp\\image\\motou.gif";
        ImageIcon imageIcon = new ImageIcon(imgPath);
        label.setIcon(imageIcon);
        label.setBounds(50,50,imageIcon.getIconWidth(),imageIcon.getIconHeight());

        frame.add(label);

        frame.setVisible(true);
    }
}
