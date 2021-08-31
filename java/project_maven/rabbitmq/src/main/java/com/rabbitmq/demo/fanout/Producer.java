package com.rabbitmq.demo.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author huxingxin
 * @createTime 2021年08月27日 14:40:33
 * @Description  消息生产者
 * fanout 模式就是广播模式~
 * 消息来了，会发给所有的队列~
 * 消息消费者 只能接收到消息消费者启动之后 成产者生产的消息
 */
public class Producer {
    private static final String EXCHANGE_NAME = "fanout_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        //1 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2 设置RabbitMQ相关信息
        factory.setHost("localhost");
        //3 创建一个新的连接
        Connection connection = factory.newConnection();
        //4 创建一个通道
        Channel channel = connection.createChannel();
        //5 交换机声明(参数: 交换机名称,交换机类型)
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

        for (int i = 0; i < 10; i++){
            String message = "direct 消息 " + i;
            channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes("UTF-8"));
            System.out.println("发送消息: " + message);
        }
        channel.close();
        connection.close();
    }
}
