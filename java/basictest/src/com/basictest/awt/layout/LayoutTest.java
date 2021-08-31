package com.basictest.awt.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-22 14:29
 **/
public class LayoutTest {
    public static void main(String[] args) {
        layout_grid();
    }

    //绝对定位布局
    public static void layout_null(){
        JFrame frame = new JFrame();
        frame.setBounds(200,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置布局器为null，即进行绝对定位，容器上的组件都需要指定位置和大小
        frame.setLayout(null);

        // 指定位置和大小
        JButton buttonA = new JButton("JAVA");
        buttonA.setBounds(50,50,100,30);
        JButton buttonB = new JButton("JavaScript");
        buttonB.setBounds(50,100,100,30);
        JButton buttonC = new JButton("HTML");
        buttonC.setBounds(50,150,100,30);
        // 没有指定位置和大小，不会出现在容器上
        JButton buttonD = new JButton("CSS");
//        buttonD.setBounds(50,200,100,30);

        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        // buttonD没有指定位置和大小，不会出现在容器上
        frame.add(buttonD);

        frame.setVisible(true);
    }

    //浮动布局
    public static void layout_flow(){
        JFrame frame = new JFrame();
        frame.setBounds(200,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置布局器为FlowLayerout
        // 容器上的组件水平摆放
        frame.setLayout(new FlowLayout());

        JButton buttonA = new JButton("JAVA");
        JButton buttonB = new JButton("JavaScript");
        JButton buttonC = new JButton("HTML");
        JButton buttonD = new JButton("CSS");

        // 加入到容器即可，无需单独指定大小和位置
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);

        frame.setVisible(true);
    }

    //环绕布局
    public static void layout_border(){
        JFrame frame = new JFrame();
        frame.setBounds(200,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置布局器为BorderLayerout
        // 容器上的组件按照上北下南左西右东中的顺序摆放
        frame.setLayout(new BorderLayout());

        JButton buttonA = new JButton("JAVA");
        JButton buttonB = new JButton("JavaScript");
        JButton buttonC = new JButton("HTML");
        JButton buttonD = new JButton("CSS");
        JButton buttonE = new JButton("Python");

        // 加入到容器的时候，需要指定位置
        frame.add(buttonA,BorderLayout.NORTH);//北
        frame.add(buttonB,BorderLayout.SOUTH);//南
        frame.add(buttonC,BorderLayout.WEST);//西
        frame.add(buttonD,BorderLayout.EAST);//东
        frame.add(buttonE,BorderLayout.CENTER);//中间

        frame.setVisible(true);
    }

    //网格布局
    public static void layout_grid(){
        JFrame frame = new JFrame();
        frame.setBounds(200,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置布局器为GridLayerout，即网格布局器
        // 该GridLayerout的构造方法表示该网格是2行3列
        frame.setLayout(new GridLayout(2,3));

        JButton buttonA = new JButton("JAVA");
        JButton buttonB = new JButton("JavaScript");
        JButton buttonC = new JButton("HTML");
        JButton buttonD = new JButton("CSS");
        JButton buttonE = new JButton("Python");

        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(buttonE);

        frame.setVisible(true);
    }
}
