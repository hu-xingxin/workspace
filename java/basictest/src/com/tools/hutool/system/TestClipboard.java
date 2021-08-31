package com.tools.hutool.system;

import cn.hutool.core.swing.ClipboardUtil;
import com.tools.hutool.utils.print.Comment;
import com.tools.hutool.utils.print.LogUtil;
import org.junit.Test;


/**
 * @author huxingxin
 * @createTime 2021年08月02日 10:48:57
 * @Description
 */
public class TestClipboard {
    LogUtil logUtil = new LogUtil(TestClipboard.class);

    @Test
    @Comment("粘贴版")
    public void clipboard(){
        String str1 = "how2j.cn- java教程";
        ClipboardUtil.setStr(str1);
        String str2 = ClipboardUtil.getStr();
        logUtil.formatPrint("把如下数据通过ClipboardUtil 保存到粘贴板里",str1,"通过ClipboardUtil 从粘贴板里取数据",str2);
    }
}
