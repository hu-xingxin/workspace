package com.basictest.awt.swing;

import javax.swing.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-21 23:36
 **/
public class ComboBoxTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(700,300,400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] language = {"JAVA", "JavaScript", "HTML", "CSS"};
        JComboBox<String> comboBox = new JComboBox<>(language);
        comboBox.setBounds(50,50,100,30);

        frame.add(comboBox);
        frame.setVisible(true);

    }
}
