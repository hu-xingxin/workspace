package com.activemq.demo2;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author huxingxin
 * @createTime 2021年08月27日 09:36:34
 * @Description
 */
public class Consumer {
    private static final String url = "tcp://127.0.0.1:61616";
    private static final String topicName = "topic_style";

    public static void main(String[] args) throws JMSException {
        //1 创建工厂 绑定url
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //2 创建连接
        Connection connection = factory.createConnection();
        //3 启动连接
        connection.start();
        //4 获取session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5 创建一个主题
        Topic topic = session.createTopic(topicName);
        //6 创建一个消费者
        MessageConsumer consumer = session.createConsumer(topic);
        //7 创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收消息: " + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //8. 因为不知道什么时候有，所以没法主动关闭，就不关闭了，一直处于监听状态
        //connection.close();
    }
}
