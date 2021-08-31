package com.rabbitmq.demo.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author huxingxin
 * @createTime 2021年08月28日 15:52:57
 * @Description Direct 模式就是指定队列模式， 消息来了，只发给指定的 Queue, 其他Queue 都收不到。
 */
public class Producer {
    private static final String QUEUE_NAME = "direct_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1 创建工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2 设置RabbitMQ相关信息
        factory.setHost("localhost");
        //3 创建一个新的连接
        Connection connection = factory.newConnection();
        //4 创建一个通道
        Channel channel = connection.createChannel();

        for (int i = 0; i < 10; i++){
            String message = "direct 消息" + i;
            //6 发送到消息队列
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes("UTF-8"));
            System.out.println("发送消息 : " + message);
        }
        channel.close();
        connection.close();
    }
}
