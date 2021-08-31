package com.basictest.awt.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-22 10:29
 **/
public class ProgressBarTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(400,400,400,400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setMaximum(100);
        progressBar.setValue(54);
        progressBar.setStringPainted(true);

        frame.add(progressBar);

        frame.setVisible(true);
    }
}
