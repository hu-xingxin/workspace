package com.basictest.awt.swing;

import javax.swing.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-21 23:27
 **/
public class RadioTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(400,400,400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JRadioButton radioA = new JRadioButton("JAVA");
        radioA.setBounds(50,50,130,30);
        radioA.setSelected(true);

        JRadioButton radioB = new JRadioButton("JavaScript");
        radioB.setBounds(50,100,130,30);

        JRadioButton radioC = new JRadioButton("html");
        radioC.setBounds(50,150,130,30);

        JRadioButton radioD = new JRadioButton("css");
        radioD.setBounds(50,200,130,30);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioC);
        buttonGroup.add(radioD);

        frame.add(radioA);
        frame.add(radioB);
        frame.add(radioC);
        frame.add(radioD);

        frame.setVisible(true);
    }
}
