package com.tools.hutool.encoder;

import cn.hutool.core.text.UnicodeUtil;
import com.tools.hutool.utils.print.Comment;
import com.tools.hutool.utils.print.LogUtil;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年08月01日 14:52:56
 * @Description Unicode工具
 */
public class UnicodeTest {
    LogUtil logUtil = new LogUtil(UnicodeTest.class);

    @Test
    @Comment("unicode转换")
    public void unicodeConvert(){
        String content = "how2j.cn - java教程";

        String str1 = UnicodeUtil.toUnicode(content);
        logUtil.formatPrint("原字符串",content, "unicode字符串", str1);
        String str2 = UnicodeUtil.toString(str1);
        logUtil.formatPrint("unicode字符串",str1, "原字符串", str2);

        String.valueOf(1);

    }
}
