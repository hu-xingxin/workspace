package com.tools.hutool.encoder;

import cn.hutool.core.util.URLUtil;
import com.tools.hutool.utils.print.Comment;
import com.tools.hutool.utils.print.LogUtil;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年08月01日 13:16:14
 * @Description URL工具
 */
public class URLTest {
    LogUtil logUtil = new LogUtil(URLTest.class);

    @Test
    @Comment("URLUtil使用举例")
    public void urlConvert(){
        String url1 = "how2j.cn/k/tmall_springboot/tmall_springboot-1799/1799.html";
        String url2 = URLUtil.formatUrl(url1);
        logUtil.formatPrint("原数据",url1, "格式化之后",url2);
        String url3 = URLUtil.encode(url2);
        logUtil.formatPrint("原数据",url2, "编码数据",url3);
        String url4 = URLUtil.decode(url3);
        logUtil.formatPrint("编码数据",url3, "解码数据",url4);
        String url5 = URLUtil.getPath(url4);
        logUtil.formatPrint("原数据",url4, "对应路径",url5);
    }
}
