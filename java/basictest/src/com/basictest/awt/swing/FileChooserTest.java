package com.basictest.awt.swing;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-22 14:01
 **/
public class FileChooserTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(400,400,400,400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //则此窗口将置于屏幕的中央
        frame.setLocationRelativeTo(null);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return ".txt";
            }
        });

        JButton buttonOpen = new JButton("打开文件");
        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showOpenDialog(frame);
                File file = fileChooser.getSelectedFile();
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    JOptionPane.showMessageDialog(frame,"计划打开文件: "  + file.getAbsolutePath());
                }
            }
        });

        JButton buttonSave = new JButton("保存文件");
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showSaveDialog(frame);
                File file = fileChooser.getSelectedFile();
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    JOptionPane.showMessageDialog(frame,"计划保存到文件: " + file.getAbsolutePath());
                }
            }
        });

        frame.add(buttonOpen);
        frame.add(buttonSave);

        frame.setVisible(true);

    }
}
