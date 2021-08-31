package com.activemq.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author huxingxin
 * @createTime 2021年08月27日 10:34:18
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring_jms.xml")
public class ProducerApp {
    @Autowired
    private Producer producer;

    @Test
    public  void testSend() {
        for (int i = 0; i < 10; i++) {
            producer.sendTextMessage("消息 " + i);
        }
    }
}
