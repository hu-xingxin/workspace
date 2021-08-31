package com.basictest.awt.jibenmianban;

import javax.swing.*;
import java.awt.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-23 10:41
 **/
public class TabbedPanelTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(200,100,400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelA = new JPanel();
//        panelA.setBounds(50,50,300,300);
        panelA.setBackground(Color.GREEN);
        JButton buttonA = new JButton("A");
        JButton buttonB = new JButton("B");
        JButton buttonC = new JButton("C");
        panelA.add(buttonA);
        panelA.add(buttonB);
        panelA.add(buttonC);

        JPanel panelB = new JPanel();
        panelB.setBounds(50,50,400,400);
        panelB.setBackground(Color.red);
        JButton buttonD = new JButton("D");
        JButton buttonE = new JButton("E");
        JButton buttonF = new JButton("F");
        panelB.add(buttonD);
        panelB.add(buttonE);
        panelB.add(buttonF);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add(panelA);
        tabbedPane.add(panelB);
        tabbedPane.setTitleAt(0,"GREEN");
        tabbedPane.setTitleAt(1,"red");

        frame.setContentPane(tabbedPane);
        frame.setVisible(true);

    }
}
