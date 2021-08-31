package com.basictest.awt.container;

import javax.swing.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-20 06:38
 **/
public class JDialogTest {
    public static void main(String[] args) {
        JDialog jDialog = new JDialog();
        jDialog.setTitle("lol");
        jDialog.setBounds(50,50,400,300);
        jDialog.setLayout(null);
        jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


        jDialog.setVisible(true);

    }
}
