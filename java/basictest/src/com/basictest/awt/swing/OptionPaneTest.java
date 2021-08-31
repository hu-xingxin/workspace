package com.basictest.awt.swing;

import javax.swing.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-21 23:41
 **/
public class OptionPaneTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(700,300,400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        int option = JOptionPane.showConfirmDialog(frame, "是否使用外挂?");
        if(JOptionPane.OK_OPTION == option){
            String answer = JOptionPane.showInputDialog(frame, "请输入YES, 表明使用外挂后果自负!");
            if("YES".equals(answer)){
                JOptionPane.showMessageDialog(frame,"你使用外挂被抓住! 罚捡肥皂三次!");
            }
        }
    }
}
