package com.basictest.awt.jibenmianban.demo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-23 14:51
 **/
public class JSplitPaneTest1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(200,100,600,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JSplitPane布局的右边部分
        Panel panelRight = new Panel();
        panelRight.setBounds(150,0,500,400);
        //用于存放图片的容器组件
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("E:\\tmp\\image\\cat.jpg"));
        label.setBounds(10,10,500,400);
        panelRight.add(label);

        //存储图片的集合
        ArrayList<ImageIcon> iconList = new ArrayList<>();
        String[] imgArr = {"E:\\tmp\\image\\cat.jpg","E:\\tmp\\image\\cat1.jpg","E:\\tmp\\image\\app.png",};
        iconList.add(new ImageIcon(imgArr[0]));
        iconList.add(new ImageIcon(imgArr[1]));
        iconList.add(new ImageIcon(imgArr[2]));

        //JSplitPane布局的左边部分
        Panel panelLeft = new Panel();
        panelLeft.setBounds(0,0,100,400);
        for (int i = 0; i < 3; i++){
            JButton jButton = new JButton("image" + i);
            jButton.addActionListener(new SimpleListener(panelRight,iconList,label));
            panelLeft.add(jButton);
        }

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelLeft,panelRight);
        splitPane.setDividerLocation(150);

        frame.setContentPane(splitPane);
        frame.setVisible(true);
    }

    /**
     * 自定义按钮监听事件
     */
    static class SimpleListener implements ActionListener {
        private Panel panelRight;
        private ArrayList<ImageIcon> iconList;
        private JLabel label;

        public SimpleListener(Panel panelRight,ArrayList<ImageIcon> iconList,JLabel label){
            this.panelRight = panelRight;
            this.iconList = iconList;
            this.label = label;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String text = source.getText();
            switch (text){
                case "image0":
                    label.setIcon(iconList.get(0));
                    break;
                case "image1":
                    label.setIcon(iconList.get(1));
                    break;
                case "image2":
                    label.setIcon(iconList.get(2));
                    break;
            }
        }
    }
}