package com.tools.hutool.encoder;

import cn.hutool.core.util.HexUtil;
import com.tools.hutool.utils.print.Comment;
import com.tools.hutool.utils.print.LogUtil;
import org.junit.Test;

import java.awt.*;

/**
 * @author huxingxin
 * @createTime 2021年07月31日 14:30:26
 * @Description hutool 16进制工具
 */
public class TestHex {

    LogUtil logUtil = new LogUtil(TestHex.class);

    @Test
    @Comment("判断是否是十六进制")
    public void isHexNumber(){
        String str1 = "2021";
        boolean b1 = HexUtil.isHexNumber(str1);
        System.out.printf("字符串 %s 是否十六机制 %s\n",str1,b1);
        String str2 = "0x2021";
        boolean b2 = HexUtil.isHexNumber(str2);
        System.out.printf("字符串 %s 是否十六机制 %s\n",str2,b2);
    }

    @Test
    @Comment("字符串和十六进制互相转换")
    public void strMutualConvertHex(){
        String str1 = "how2j.cn - java教程";
        String strHex = HexUtil.encodeHexStr(str1);
        logUtil.formatPrint("原数据",str1,"十六机制编码",strHex);
        String str2 = HexUtil.decodeHexStr(strHex);
        logUtil.formatPrint("十六机制编码",strHex,"原数据",str2);
    }

    @Test
    @Comment("颜色转换")
    public void colorConvert(){
        Color color = new Color(255, 0, 0);
        String hexColor = HexUtil.encodeColor(color);
        System.out.printf("颜色对象 %s \n 十六机制颜色码 %s\n",color,hexColor);
        Color red = HexUtil.decodeColor(hexColor);
        System.out.printf("十六机制颜色码 %s \n 颜色对象 %s\n",hexColor,red);

    }



}


