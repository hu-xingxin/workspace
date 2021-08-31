package com.basictest.awt.date;



import com.eltima.components.ui.DatePicker;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Locale;

/**
 * @author huxingxin
 * @ClassName DateGUITest.java
 * @Description
 * @createTime 2021年07月21日 09:09:00
 */
public class DateGUITest1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(200,200,400,300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        JXDatePicker jxDatePicker = new JXDatePicker();
        // 设置 date日期
        Date date = new Date();
        jxDatePicker.setDate(date);
        jxDatePicker.setBounds(137,83,177,24);

        jFrame.add(jxDatePicker);


        JButton jButton = new JButton("获取时间");
        jButton.setBounds(137,183,100,30);

        jFrame.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame,"获取控件中的日期"+ jxDatePicker.getDate());
                System.out.println(jxDatePicker.getDate());
            }
        });


        jFrame.setVisible(true);
    }
}
