package com.basictest.awt.jibenmianban.demo;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author huxingxin
 * @ClassName TabbedPanelTest.java
 * @Description 按照eclipse的风格显示多个java文件
 * @createTime 2021年07月19日 11:26:00
 */
public class TabbedPanelTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(100,100,1000,700);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] javaName = new String[4];
        javaName[0] = "F:\\代码\\workspace\\java\\basictest\\src\\com\\basictest\\awt\\jibenmianban\\CardLayoutTest.java";
        javaName[1] = "F:\\代码\\workspace\\java\\basictest\\src\\com\\basictest\\awt\\jibenmianban\\JSplitPaneTest.java";
        javaName[2] = "F:\\代码\\workspace\\java\\basictest\\src\\com\\basictest\\awt\\jibenmianban\\PanelTest.java";
        javaName[3] = "F:\\代码\\workspace\\java\\basictest\\src\\com\\basictest\\awt\\jibenmianban\\ScrollPaneTest.java";


        //把JTextArea放到JScrollPane里面
        //然后把JScrollPane放置到JTabbedPane
        //最后把jFrame的面板换成JTabbedPane
        JTabbedPane jTabbedPane = new JTabbedPane();
        for (int i = 0;i < 4; i++){
            JScrollPane jScrollPane = null;
            try (BufferedReader br = new BufferedReader(new FileReader(javaName[i]));){
                JTextArea jTextArea = new JTextArea();
                jTextArea.setBounds(0,0,1000,700);
                //读取文件类容
                String line;
                while ((line = br.readLine()) != null){
                    jTextArea.append(line + "\n");
                }
                jTextArea.setLineWrap(true);//自动换行
                //设置字体
                Font songFont = new Font("宋体", Font.BOLD, 23);
                jTextArea.setFont(songFont);
                //把JTextArea放到JScrollPane里面
                jScrollPane = new JScrollPane(jTextArea);
            }catch (Exception e){
                e.printStackTrace();
            }
            //把JScrollPane放置到JTabbedPane
            jTabbedPane.add(jScrollPane);
            //文件名
            String fileName = javaName[i].substring(javaName[i].lastIndexOf("\\") + 1);
            jTabbedPane.setTitleAt(i,fileName);
        }
        //最后把jFrame的面板换成JTabbedPane
        jFrame.setContentPane(jTabbedPane);
        jFrame.setVisible(true);
    }
}
