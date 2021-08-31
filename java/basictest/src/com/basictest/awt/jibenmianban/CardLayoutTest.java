package com.basictest.awt.jibenmianban;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @description
 * @author: hxx
 * @create: 2021-06-23 11:23
 **/
public class CardLayoutTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(200,10,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel comboBoxPane = new JPanel();
        String items[] = {"按钮面板","输入框面板"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBoxPane.add(comboBox);

        JPanel cardA = new JPanel();
        cardA.setBackground(Color.GREEN);
        cardA.add(new JButton("A"));
        cardA.add(new JButton("B"));
        cardA.add(new JButton("C"));


        JPanel cardB = new JPanel();
        cardB.setBackground(Color.RED);
        cardB.add(new JTextField("输入框",20));

        JPanel cards = new JPanel(new CardLayout());
        cards.add(cardA,"按钮面板");
        cards.add(cardB,"输入框面板");

        frame.add(comboBoxPane,BorderLayout.NORTH);
        frame.add(cards,BorderLayout.CENTER);

        frame.setVisible(true);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //Swing中ComboBox改变选择时ItemStateChanged 触发两次。一次时旧的选项deselect时触发，另一个是在新的选项select时触发。
                if(e.getStateChange() == e.SELECTED){
                    CardLayout cardLayout = (CardLayout)(cards.getLayout());
                    System.out.println((String) e.getItem());
                    cardLayout.show(cards,(String) e.getItem());
                }
            }
        });
    }
}
