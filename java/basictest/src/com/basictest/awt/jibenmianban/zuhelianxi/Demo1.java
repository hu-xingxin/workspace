package com.basictest.awt.jibenmianban.zuhelianxi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author huxingxin
 * @ClassName Demo1.java
 * @Description 在JTextField中输入数据 在旁边加一个按钮JButton
 *              当点击按钮的时候，判断JTextFiled中有没有数据
 *              并使用JOptionPane进行提示
 * @createTime 2021年07月19日 14:43:00
 */
public class Demo1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(100,100,400,400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new FlowLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setText("请输入：");

        JTextField jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(200,30));

        JButton jButton = new JButton("检测");
        jButton.setSize(30,30);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextField.getText();
                if (text.length()==0){
                    JOptionPane.showMessageDialog(jFrame,"文本类容为空");
                }else {
                    JOptionPane.showMessageDialog(jFrame,"文本内容不为空");
                }
            }
        });

        jFrame.add(label);
        jFrame.add(jTextField);
        jFrame.add(jButton);

        jFrame.setVisible(true);
    }
}
