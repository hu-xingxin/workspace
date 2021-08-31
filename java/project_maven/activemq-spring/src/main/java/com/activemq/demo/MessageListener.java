package com.activemq.demo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author huxingxin
 * @createTime 2021年08月27日 10:01:01
 * @Description 消息监听类
 */
public class MessageListener implements javax.jms.MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("接收到消息 : " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
