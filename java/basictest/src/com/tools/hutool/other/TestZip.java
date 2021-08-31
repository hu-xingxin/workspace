package com.tools.hutool.other;

import cn.hutool.core.util.ZipUtil;
import org.junit.Test;

import java.io.*;

/**
 * @author huxingxin
 * @createTime 2021年08月03日 00:01:18
 * @Description
 */
public class TestZip {
    @Test
    public void zipStr(){
        String srcFile = "E:\\tmp\\video";
        String copyFile = "E:\\tmp\\video.zip";
        File zip = ZipUtil.zip(srcFile,copyFile);
        System.out.println(zip.getName());
    }
}
