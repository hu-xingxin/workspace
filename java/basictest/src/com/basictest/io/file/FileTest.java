package com.basictest.io.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created in 2021/4/8 11:06
 *
 * @author: huxingxin
 */
public class FileTest {
    public static void main(String[] args) {
        File folder = new File("E:\\tmp\\image");
        File file = new File("E:\\tmp\\music\\失眠播报 - 林晨阳.mp3");
        System.out.println(folder.getAbsolutePath());
        System.out.println(file.getAbsolutePath());
    }
}
