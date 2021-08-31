package com.basictest.awt.layout;

import com.basictest.awt.container.JFrameTest;

import javax.swing.*;
import java.awt.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-22 14:51
 **/
public class ButtonLayoutTest {
    public static void main(String[] args) {
        calculator();
    }

    public static void calculator(){
        JFrame frame = new JFrame();
        frame.setBounds(200,100,322,272);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(8,8,frame.getWidth()-32,frame.getHeight()-62);
        // 设置布局器为GridLayerout，即网格布局器
        // 该GridLayerout的构造方法表示该网格是4行5列 上下 左右间距为4
        panel.setLayout(new GridLayout(4,5,8,8));
        frame.add(panel);

        String[] signs = {"7","8","9","/","sq","4","5","6","*","%","1","2","3","-","1/x","0","+/-",".","+","="};
        for (String sign : signs){
            JButton button = new JButton(sign);
            panel.add(button);
        }

        frame.setVisible(true);
    }
}
