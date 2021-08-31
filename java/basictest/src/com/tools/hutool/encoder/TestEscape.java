package com.tools.hutool.encoder;

import cn.hutool.core.util.EscapeUtil;
import com.tools.hutool.utils.print.Comment;
import com.tools.hutool.utils.print.LogUtil;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年07月31日 23:13:08
 * @Description 转义工具
 */
public class TestEscape {
    LogUtil logUtil = new LogUtil(TestEscape.class);

    @Test
    @Comment("转义与反转义")
    public void escape(){
        String str = "<script>location.href='http://how2j.cn';</script>";
        String str1 = EscapeUtil.escapeHtml4(str);
        logUtil.formatPrint("原数据", str,"转义后", str1);
        String str2 = EscapeUtil.unescapeHtml4(str1);
        logUtil.formatPrint("转义后", str1,"原数据", str2);
    }
}
