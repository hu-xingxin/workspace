package com.tools.hutool.system;

import cn.hutool.core.util.RuntimeUtil;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年08月02日 11:01:04
 * @Description
 */
public class TestRuntime {
    @Test
    public void runtimeTool(){
        // 该方法有问题 没有对输出流进行关闭 会造成程序阻塞
        String str = RuntimeUtil.execForStr("cmd /k mysqldump -h127.0.0.1 -uroot -p123456 nifi_1 > D:\\nifi_1.sql");
        System.out.println(str);
    }
}
