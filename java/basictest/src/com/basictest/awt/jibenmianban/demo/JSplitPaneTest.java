package com.basictest.awt.jibenmianban.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description
 * @author: hxx
 * @create: 2021-07-02 16:35
 **/
public class JSplitPaneTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JSplitPane");
        frame.setSize(1000,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panelRight = new Panel(new CardLayout());
        Color colors[] = {Color.GREEN,Color.RED,Color.BLUE};
        for (int i=0;i<3;i++){
            Panel panel = new Panel();
            panel.setBackground(colors[i]);
            panelRight.add(panel,i+"");
        }

        Panel panelLeft = new Panel();
        for (int i=0;i<3;i++){
            JButton button = new JButton("按钮" + (i + 1));
            button.addActionListener(new SimpleListener(panelRight));
            panelLeft.add(button);
        }

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLeft, panelRight);
        splitPane.setDividerLocation(100);

        frame.setContentPane(splitPane);
        frame.setVisible(true);
    }

    /**
     * 自定义按钮监听事件
     */
    static class SimpleListener implements ActionListener {
        private Panel panelRight;

        public SimpleListener(Panel panelRight) {
            this.panelRight = panelRight;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout layout = (CardLayout)panelRight.getLayout();
            JButton button = (JButton)e.getSource();
            String buttonText = button.getText();
            switch (buttonText){
                case "按钮1":
                    layout.first(panelRight);
                    break;
                case "按钮2":
                    layout.show(panelRight,"1");
                    break;
                case "按钮3":
                    layout.last(panelRight);
                    break;
            }
        }
    }
}
