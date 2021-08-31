package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huxingxin
 * @createTime 2021年08月22日 19:19:39
 * @Description
 */
public class DateUtil {
    public static String getDateTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
