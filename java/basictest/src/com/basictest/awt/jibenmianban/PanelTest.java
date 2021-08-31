package com.basictest.awt.jibenmianban;

import javax.swing.*;
import java.awt.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-22 22:04
 **/
public class PanelTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(200,100,400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelA = new JPanel();
        panelA.setBounds(50,50,300,100);
        panelA.setBackground(Color.RED);
        JButton buttonA = new JButton("JAVA");
        JButton buttonB = new JButton("HTML");
        JButton buttonC = new JButton("CSS");
        panelA.add(buttonA);
        panelA.add(buttonB);
        panelA.add(buttonC);

        JPanel panelB = new JPanel();
        panelB.setBounds(50,150,300,100);
        panelB.setBackground(Color.GREEN);
        JButton buttonD = new JButton("Python");
        JButton buttonE = new JButton(".NET");
        JButton buttonF = new JButton("C#");
        panelB.add(buttonD);
        panelB.add(buttonE);
        panelB.add(buttonF);

        frame.add(panelA);
        frame.add(panelB);

        frame.setVisible(true);

    }
}
