package com.activemq.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author huxingxin
 * @createTime 2021年08月27日 10:01:28
 * @Description 消费者
 */
@Component
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination textDestination;

    public void sendTextMessage(final String text){
        System.out.println("发送消息: " + text);
        jmsTemplate.send(textDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });
    }
}
