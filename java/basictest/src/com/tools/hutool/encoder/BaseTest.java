package com.tools.hutool.encoder;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;
import com.tools.hutool.utils.print.Comment;
import com.tools.hutool.utils.print.LogUtil;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年08月01日 14:42:15
 * @Description Base32_64工具
 */
public class BaseTest {
    LogUtil logUtil = new LogUtil(BaseTest.class);

    @Test
    @Comment("base-32-64转换")
    public void baseConvert(){
        String charset = "utf-8";
        String content = "how2j.cn - java教程";

        String str1 = Base32.encode(content, charset);
        logUtil.formatPrint("原字符串",content,"32位编码后",str1);
        String str2 = Base32.decodeStr(str1, charset);
        logUtil.formatPrint("32位编码后",str1,"原字符串",str2);

        String str3 = Base64.encode(content, charset);
        logUtil.formatPrint("原字符串",content,"64位编码后",str3);
        String str4 = Base64.decodeStr(str3, charset);
        logUtil.formatPrint("64位编码后",str3,"原字符串",str4);
    }
}
