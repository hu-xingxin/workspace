package com.basictest.awt.jibenmianban;

import javax.swing.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-23 10:08
 **/
public class ScrollPaneTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(200,100,400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        for (int i = 0; i < 1000; i++){
            textArea.append(String.valueOf(i));
        }
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.setContentPane(scrollPane);
        frame.setVisible(true);
    }
}
