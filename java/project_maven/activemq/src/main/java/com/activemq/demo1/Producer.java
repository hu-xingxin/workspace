package com.activemq.demo1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author huxingxin
 * @createTime 2021年08月26日 00:57:39
 * @Description 队列模式(分食模式)-生产消息
 */
public class Producer {
    //ActiveMQ 服务地址
    private static final String url = "tcp://127.0.0.1:61616";
    //这次发送消息的名称
    private static final String topicName = "queue_style";

    public static void main(String[] args) throws JMSException {
        //1 创建ConnectionFactory 绑定地址
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //2 创建连接
        Connection connection = factory.createConnection();
        //3 启动连接
        connection.start();
        //4 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5 创建一个目标(队列类型)
        Queue queue = session.createQueue(topicName);
        //6 创建一个生产者
        MessageProducer producer = session.createProducer(queue);

        for (int i=0; i<10; i++){
            //7 创建消息
            TextMessage textMessage = session.createTextMessage("队列消息-" + i);
            //8 发送消息
            producer.send(textMessage);
        }
        //9 关闭连接
        connection.close();
    }
}
