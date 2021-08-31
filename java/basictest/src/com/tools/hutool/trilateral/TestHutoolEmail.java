package com.tools.hutool.trilateral;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import org.junit.Test;

/**
 * @author huxingxin
 * @createTime 2021年08月02日 23:50:29
 * @Description
 */
public class TestHutoolEmail {
    private MailAccount account;
    @Test
    public void prepareEmail(){
        account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setAuth(true);
        account.setFrom("2569960390@qq.com"); //
        account.setUser("2569960390@qq.com"); //
        account.setPass("fyoecdehtkttdhgd"); //
        MailUtil.send(account,"2569960390@qq.com", "hutool 测试邮件" + DateUtil.now(), "测试内容", true);
    }
}
