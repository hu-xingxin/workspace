package com.basictest.awt.date;



import com.eltima.components.ui.DatePicker;

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
public class DateGUITest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setBounds(200,200,400,300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        // 格式
        String defaultFormat = "YYYY-MM-dd HH:mm:ss";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 18);
        Dimension dimension = new Dimension(177, 24);
        int[] hilightDays = {1,3,5,7};
        int[] disableDays = {4,6,5,9};

        DatePicker datePicker = new DatePicker(date,defaultFormat,font,dimension);
        datePicker.setFont(font);
        datePicker.setBounds(137,83,177,24);

        // 设置一个月份中需要高亮显示的日子
        datePicker.setHightlightdays(hilightDays,Color.RED);
        // 设置一个月份中不需要的日子，呈灰色显示
        datePicker.setDisableddays(disableDays);
        // 设置国家
        datePicker.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datePicker.setTimePanleVisible(true);

        jFrame.add(datePicker);

        JButton jButton = new JButton("获取时间");
        jButton.setBounds(137,183,100,30);

        jFrame.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame,"获取控件中的日期"+ datePicker.getValue());
                System.out.println(datePicker.getValue());
            }
        });


        jFrame.setVisible(true);
    }
}
