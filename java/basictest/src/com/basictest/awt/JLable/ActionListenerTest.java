package com.basictest.awt.JLable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description: 按钮监听测试
 * @author: hxx
 * @create: 2021-06-19 13:42
 **/
public class ActionListenerTest {
    public static boolean flag = true;//用于标记图片状态
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(400,300);
        jFrame.setLocation(580,200);
        jFrame.setLayout(null);

        //JLabel 对象可以显示文本、图像或同时显示二者
        JLabel jLabel = new JLabel();
        String imgPath = "E:\\tmp\\image\\motou.gif";
        ImageIcon imageIcon = new ImageIcon(imgPath);
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(50,50,imageIcon.getIconWidth(),imageIcon.getIconHeight());

        JButton jButton = new JButton("隐藏图片");
        jButton.setBounds(150,200,100,30);
        //给按钮添加监听事件
        jButton.addActionListener(new ActionListener(){
            // 当按钮被点击时，就会触发 ActionEvent事件
            // actionPerformed 方法就会被执行
            @Override
            public void actionPerformed(ActionEvent e) {
                //隐藏图片
                if(flag){
                    jLabel.setVisible(false);
                    jButton.setText("显示图片");
                    flag = false;
                }else {
                    //显示图片
                    jLabel.setVisible(true);
                    jButton.setText("隐藏图片");
                    flag = true;
                }
            }
        });

        jFrame.add(jLabel);
        jFrame.add(jButton);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
