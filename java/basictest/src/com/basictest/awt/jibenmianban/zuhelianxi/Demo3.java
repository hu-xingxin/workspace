package com.basictest.awt.jibenmianban.zuhelianxi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @author huxingxin
 * @ClassName Demo3.java
 * @Description 练习-复制文件夹提供进度条，把文件复制的进度显示出来。
 * @createTime 2021年07月19日 15:30:00
 */
public class Demo3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(100,100,800,400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new FlowLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //源文件地址
        JLabel labelSource = new JLabel("源文件地址");
        JTextField jTextFieldSource = new JTextField();
        jTextFieldSource.setPreferredSize(new Dimension(100,30));
        //目标路径
        JLabel labelCopyTo = new JLabel("复制到");
        JTextField jTextFieldCopyTo = new JTextField();
        jTextFieldCopyTo.setPreferredSize(new Dimension(100,30));

        //复制按钮
        JButton jButton = new JButton("开始复制");

        //进度条
        JProgressBar jProgressBar = new JProgressBar();
        jProgressBar.setPreferredSize(new Dimension(300,30));
        jProgressBar.setStringPainted(true);

        //给按钮添加拷贝文件事件
        jButton.addActionListener(new SimpleActionListener(jFrame,jTextFieldSource,jTextFieldCopyTo,jProgressBar));


        jFrame.add(labelSource);
        jFrame.add(jTextFieldSource);
        jFrame.add(labelCopyTo);
        jFrame.add(jTextFieldCopyTo);
        jFrame.add(jButton);
        jFrame.add(jProgressBar);

        jFrame.setVisible(true);
    }

    /**
     * 自定义按钮监听事件
     */
    static class SimpleActionListener implements ActionListener{
        private JFrame jFrame;
        private JTextField jTextFieldSource;
        private JTextField jTextFieldCopyTo;
        private JProgressBar jProgressBar;


        public SimpleActionListener(JFrame jFrame,JTextField jTextFieldSource,JTextField jTextFieldCopyTo,JProgressBar jProgressBar){
            this.jFrame = jFrame;
            this.jTextFieldSource = jTextFieldSource;
            this.jTextFieldCopyTo = jTextFieldCopyTo;
            this.jProgressBar = jProgressBar;
        }

       @Override
       public void actionPerformed(ActionEvent e) {
           String pathSource = jTextFieldSource.getText();//源文件
           String pathCopyTo = jTextFieldCopyTo.getText();//目标路径
           //如果源文件地址和copyTo地址为空
           if(pathSource.length()==0 || pathCopyTo.length()==0){
               JOptionPane.showMessageDialog(jFrame,"请输入有效文件或者路径！");
           }else {
               File file = new File(pathSource);
               boolean exists = file.exists();
               //判断源文件地址是否存在
               if (!exists){
                   //不存在 提示
                   JOptionPane.showMessageDialog(jFrame,"源文件不存在！");
               }else {
                   //存在 则拷贝文件到目标地址
                   //时间戳
                   long times = System.currentTimeMillis();
                   //文件后缀名
                   String suffix = pathSource.substring(pathSource.lastIndexOf(".") + 1);
                   long length = file.length();//文件大小（单位字节）
                   try (FileInputStream fis = new FileInputStream(file);
                        FileOutputStream fos = new FileOutputStream(new File(pathCopyTo,times+"."+suffix));){

                       jProgressBar.setMaximum((int)length);//把文件大小用作进度条最大值

                       byte[] buffer = new byte[1024*1024];
                       int index;
                       int value = 0;
                       while ((index = fis.read(buffer)) != -1){
                           fos.write(buffer,0,index);
                           value += index;
                           jProgressBar.setValue(value);//拷贝多少 进度条增加多少
                       }

                   } catch (FileNotFoundException fileNotFoundException) {
                       fileNotFoundException.printStackTrace();
                       JOptionPane.showMessageDialog(jFrame,fileNotFoundException.getMessage());
                   } catch (IOException ioException) {
                       ioException.printStackTrace();
                       JOptionPane.showMessageDialog(jFrame,ioException.getMessage());
                   }
                   int fileSize = (int)length/1024;//文件大小 用KB 表示
                   JOptionPane.showMessageDialog(jFrame,"拷贝完毕:"+pathCopyTo+times+"."+suffix+"\n文件大小为：" + fileSize + "KB");
               }
           }
       }
   }
}
