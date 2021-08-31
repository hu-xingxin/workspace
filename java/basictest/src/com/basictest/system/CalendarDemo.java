package com.basictest.system;

import javafx.scene.input.DataFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created in 2021/3/14 21:02
 *
 * @author: huxingxin
 */
public class CalendarDemo {
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2003,7,30);
//        calendar.add(Calendar.MONTH,6);
//        Date time = calendar.getTime();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(time);
//        System.out.println(format);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2003,7,31);
        calendar.set(Calendar.MONTH,8);
//        Date time1 = calendar.getTime();
        calendar.set(Calendar.DATE,5);
        Date time = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(time);
        System.out.println(format);
    }
}
