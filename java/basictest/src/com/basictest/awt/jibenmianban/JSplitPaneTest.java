package com.basictest.awt.jibenmianban;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-23 09:08
 **/
public class JSplitPaneTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(200,100,400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelLeft = new JPanel();
        panelLeft.setBounds(50,50,100,300);
        panelLeft.setBackground(Color.red);
        JButton buttonA = new JButton("菜单一");
        JButton buttonB = new JButton("菜单二");
        JButton buttonC = new JButton("菜单三");


        panelLeft.add(buttonA);
        panelLeft.add(buttonB);
        panelLeft.add(buttonC);

        JPanel panelRight = new JPanel();
        panelRight.setBounds(155,50,240,300);
        panelRight.setBackground(Color.blue);
        JButton buttonD = new JButton("内容1");
        JButton buttonE = new JButton("内容2");
        JButton buttonF = new JButton("内容3");
        panelRight.add(buttonD);
        panelRight.add(buttonE);
        panelRight.add(buttonF);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLeft, panelRight);
        splitPane.setDividerLocation(153);

        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelRight.setBackground(Color.GREEN);
            }
        });
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelRight.setBackground(Color.CYAN);
            }
        });
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelRight.setBackground(Color.BLUE);
            }
        });

        frame.setContentPane(splitPane);
        frame.setVisible(true);

    }
}
