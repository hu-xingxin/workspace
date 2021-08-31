package com.activemq.demo2;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author huxingxin
 * @createTime 2021年08月27日 09:25:53
 * @Description 主题模式-生产消息
 */
public class Producer {
    private static final String url = "tcp://127.0.0.1:61616";
    private static final String topicName = "topic_style";

    public static void main(String[] args) throws JMSException {
        //1.创建ConnectionFactory,绑定地址
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //2.创建Connection
        Connection connection = factory.createConnection();
        //3.启动连接
        connection.start();
        //4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建一个目标 (主题类型)
        Topic topic = session.createTopic(topicName);
        //6.创建一个生产者
        MessageProducer producer = session.createProducer(topic);

        for (int i = 0; i < 10; i++){
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("主题消息" + i);
            //8.发送消息
            producer.send(textMessage);
            System.out.println("发送: " + textMessage.getText());
        }
        //7. 关闭连接
        session.close();
    }
}
