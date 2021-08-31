package com.basictest.awt.swing;

import javafx.scene.control.CheckBox;

import javax.swing.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-21 10:12
 **/
public class CheckBoxTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(400,400,400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JCheckBox checkBoxA = new JCheckBox("Java");
        checkBoxA.setSelected(true);
        checkBoxA.setBounds(50,100,130,30);
        JCheckBox checkBoxB = new JCheckBox("JavaScript");
        checkBoxB.setBounds(50,150,130,10);

        frame.add(checkBoxA);
        frame.add(checkBoxB);
        frame.setVisible(true);
    }
}
