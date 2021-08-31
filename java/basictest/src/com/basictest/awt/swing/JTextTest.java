package com.basictest.awt.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-21 23:49
 **/
public class JTextTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(700,300,400,400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelName = new JLabel("账号:");
        JTextField fieldName = new JTextField("");
        fieldName.setText("请输入账号...");
        fieldName.setPreferredSize(new Dimension(80,30));

        JLabel labelPassWord = new JLabel("密码:");
//        JTextField fieldPassWord = new JTextField("");
        JPasswordField fieldPassWord = new JPasswordField("");
        fieldPassWord.setText("请输入密码...");
        fieldPassWord.setPreferredSize(new Dimension(80,30));

        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(200,150));
        textArea.setText("学习JAVA...\n");
        textArea.setText("学习JavaScript...\n");
        textArea.append("学习HTML...\n");
        textArea.append("学习CSS...\n");
        textArea.append("学习vue...\n");
        textArea.setLineWrap(true);

        frame.add(labelName);
        frame.add(fieldName);
        frame.add(labelPassWord);
        frame.add(fieldPassWord);
        frame.add(textArea);

        frame.setVisible(true);

        fieldPassWord.grabFocus();

    }
}
