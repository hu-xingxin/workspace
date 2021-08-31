package com.tools.hutool.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ImageUtil;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年08月02日 11:53:33
 * @Description
 */
public class TestImage {
    @Test
    public void imageScale(){
        System.out.println("开始缩放图片...");
        ImageUtil.gray(FileUtil.file("D:\\1.jpg"),FileUtil.file("D:\\3.jpg")    );
        System.out.println("图片缩放完毕...");
    }
}
