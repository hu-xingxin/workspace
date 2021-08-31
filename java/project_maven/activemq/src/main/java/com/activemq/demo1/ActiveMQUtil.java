package com.activemq.demo1;


import cn.hutool.core.util.NetUtil;
import org.junit.Test;

import javax.swing.*;

/**
 * @author huxingxin
 * @createTime 2021年08月25日 23:36:33
 * @Description
 */
public class ActiveMQUtil {
    @Test
    public void testMethod(){
        checkSever();
    }

    public static void checkSever(){
        if (NetUtil.isUsableLocalPort(8161)){
            JOptionPane.showMessageDialog(null,"ActiveMQ 服务器未启动...");
            System.exit(1);
        }else {
            JOptionPane.showMessageDialog(null,"ActiveMQ 服务器启动成功...");
        }
    }
}
